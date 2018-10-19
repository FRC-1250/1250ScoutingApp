package pit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PitDataController {

	PitDataAccess pitDataAccess = new PitDataAccess();

	@GetMapping("/pit/{teamNumber}")
	public String getTeam(Model model, @PathVariable int teamNumber) {
		PitDataModel pit = pitDataAccess.getTeam(teamNumber);
		model.addAttribute(pit);
		return "test/PitFormOutputTest";
	}

	@GetMapping("/pit")
	public String getPitForm(Model model) {
		model.addAttribute("pit", new PitDataModel());
		return "PitForm";
	}

	@PostMapping("/pit")
	public String pitFormSubmit(@ModelAttribute("pit") PitDataModel pit) {
		pitDataAccess.insertTeam(pit);
		return "test/PitFormOutputTest";
	}
}
