package match;

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
public class MatchDataController {

    @GetMapping("/match/{matchNumber}")
    public String getMatch(Model model, @PathVariable int matchNumber) {
    	String sql = "";

		try {
	    	sql = "Select * FROM `match` WHERE matchNumber=" + matchNumber;
	    	CachedRowSet set = Mariadb.Query(sql);		
			set.last();
			MatchDataModel data = new MatchDataModel(set.getInt("matchNumber"), set.getInt("teamNumber"), set.getString("autoPosition"), 
					set.getBoolean("autoSuccess"), set.getBoolean("placeSwitch"), set.getBoolean("placeScale"), set.getBoolean("placePort"), 
					set.getString("endGameAction"), set.getString("notes"));
						
			model.addAttribute("match", data);
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "test.html";
    }
    
    @GetMapping("/match")
    public String getMatchForm(Model model) {
    	model.addAttribute(new MatchDataModel());
    	return "form.html";
    }
    
    @PostMapping("/match")
    public String matchFormSubmit(@ModelAttribute MatchDataModel data) {
        return "result";
    }
}
