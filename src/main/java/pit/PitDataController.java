package pit;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

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
	    	CachedRowSet set = Mariadb.Query(sql);		
			set.last();
			PitDataModel data = new PitDataModel(set.getInt("teamNumber"), set.getString("teamName"), set.getInt("scaleClaim")
					, set.getInt("switchClaim"), set.getInt("vaultClaim"), set.getString("pitNotes"), set.getBoolean("autoBase")
					, set.getBoolean("autoSwitch"), set.getBoolean("autoscale"), set.getBoolean("typeScale"), set.getBoolean("typeSwitch")
					, set.getBoolean("typeVault"));
						
			model.addAttribute("pit", data);
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "test/PitFormOutputTest";
    }
    
    @GetMapping("/pit")
    public String getPitForm(Model model) {
    	model.addAttribute("pit", new PitDataModel());
    	return "PitForm";
    }
    
    @PostMapping("/pit")
    public String pitFormSubmit(@ModelAttribute("pit") PitDataModel data) {
        return "test/PitFormOutputTest";
    }
}
