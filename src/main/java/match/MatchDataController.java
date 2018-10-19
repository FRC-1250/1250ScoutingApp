package match;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MatchDataController {

	MatchDataAccess matchDataAccess = new MatchDataAccess();
	
    @GetMapping("/match/{matchNumber}")
    public String getMatch(Model model, @PathVariable int matchNumber) {
    	MatchDataModel match = matchDataAccess.getMatch(matchNumber);
    	model.addAttribute("match", match);
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
    	matchDataAccess.insertMatch(match);
    	return "test/MatchFormOutputTest";
    }
}
