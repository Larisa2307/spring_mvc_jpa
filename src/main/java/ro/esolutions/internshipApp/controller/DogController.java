package ro.esolutions.internshipApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.esolutions.internshipApp.service.DogService;

@Controller
@RequiredArgsConstructor
public class DogController {

	final DogService dogService;

	@GetMapping("/dog/info")
	public String getDogsInfo(Model model) {
		model.addAttribute("cainiMari", dogService.getDogsByName("Labus"));
		model.addAttribute("cainiVerzi", dogService.getDogsWithColor("verde"));

		return "dog/infoView";
	}
}
