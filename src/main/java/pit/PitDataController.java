package pit;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import frc.team1250.Mariadb;

@Controller
public class PitDataController {

    @GetMapping("/pit/{teamNumber}")
    public String getTeam(Model model, @PathVariable int teamNumber) {
    	String sql = "";

		try {
	    	sql = "Select * FROM `pit` WHERE teamNumber=" + teamNumber;
			ResultSet set = Mariadb.Query(sql);		
			set.last();
			PitDataModel data = new PitDataModel(set.getInt("teamNumber"), set.getString("teamName"), set.getInt("scaleClaim")
					, set.getInt("switchClaim"), set.getInt("vaultClaim"), set.getString("pitNotes"), set.getBoolean("autoBase")
					, set.getBoolean("autoSwitch"), set.getBoolean("autoscale"), set.getBoolean("typeScale"), set.getBoolean("typeSwitch")
					, set.getBoolean("typeVault"));
						
			model.addAttribute("pit", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "test.html";
    }
    
    @GetMapping("/pit")
    public String getPitForm(Model model) {
    	model.addAttribute(new PitDataModel());
    	return "pitform.html";
    }
    
    @PostMapping("/pit")
    public String pitFormSubmit(@ModelAttribute PitDataModel data) {
        return "result";
    }
}
