package match;

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
public class MatchDataController {

    @GetMapping("/match/{matchNumber}")
    public String getMatch(Model model, @PathVariable int matchNumber) {
    	String sql = "";

		try {
	    	sql = "Select * FROM `match` WHERE matchNumber=" + matchNumber;
			ResultSet set = Mariadb.Query(sql);		
			set.last();
			MatchDataModel data = new MatchDataModel(set.getInt("matchNumber"), set.getInt("teamNumber"), set.getString("autoPosition"),set.getString("autoType"), 
					set.getBoolean("autoSuccess"), set.getBoolean("placeSwitch"), set.getBoolean("placeScale"), set.getBoolean("placePort"), 
					set.getInt("scoreScale"), set.getInt("scoreSwitch"), set.getInt("scoreVault"), set.getString("endGameAction"), set.getString("notes"));
						
			model.addAttribute("match", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "test/MatchFormOutputTest";
    }
    
    @GetMapping("/match")
    public String getMatchForm(Model model) {
    	model.addAttribute("match", new MatchDataModel());
    	return "MatchForm";
    }
    
    //Specifying the value inside of the @ModelAttribute is required if the class name
    //does not match the name of entity submitted
    @PostMapping("/match")
    public String matchFormSubmit(@ModelAttribute("match") MatchDataModel match) {
    	return "test/MatchFormOutputTest";
    }
}
