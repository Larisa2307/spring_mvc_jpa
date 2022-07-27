package ro.esolutions.internshipApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.internshipApp.entity.Airplane;
import ro.esolutions.internshipApp.repository.AirplaneRepository;
import ro.esolutions.internshipApp.service.AirplaneService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor //lombok
@Controller   //adresata lui SPRING
@RequestMapping("/airplane")   //adresata lui SPRING
public class AirplaneController {

	final AirplaneService airplaneService;  //Dependency Injection

	//get:   BE -> catre FE
	@GetMapping("/dashboard")  //C
	public String getDashboard(Model model ) { //M
//		List<Airplane> ariplanesDinBD = airplaneRepository.findAll(); //Hibernate -> select * from airplanes;
//		model.addAttribute("airplanes", ariplanesDinBD);

		model.addAttribute("airplane2", airplaneService.getAirplanesByName()); // select * from airplane where name = 'F22'
//		model.addAttribute("airplane3", airplaneRepository.findByNameIgnoreCase("F22")); // select * from airplane where lower(name) = lower('F22')
//		model.addAttribute("airplane4", airplaneRepository.findByNameContaining("F")); // select * from airplane where lower(name) = lower('F22')
//		model.addAttribute("airplane5", airplaneRepository.findByAgeGreaterThanEqual(22)); // select * from airplane where age >=22;
//		model.addAttribute("airplane6", airplaneRepository.getAirplanesWithIdGreaterThan(1001L));
//		model.addAttribute("airplane7", airplaneRepository.findAll().stream().filter(x->x.getId()>=1001).collect(Collectors.toList()));
		return "airplane/dashboardView";
	}

	//POST:  din FE catre BE:  -> am un form in FE  submit => pleaca datele spre BE
	@PostMapping("/add")
	//id:null,  name:aaaa, age:2222
	public String saveAirplane(@RequestBody Airplane airplane){  //cand trimitem date din FE catre BE le prindem cu @ModelAttribute
//		System.out.println(airplane); //simulam salvarea
//		airplaneRepository.save(airplane); // Hibernate:  insert into airplane values(null->generate auto, aaaa, 2222)
		return "redirect:/airplane/dashboard";  //redirect in controllerul pe care il doresc
	}


	@GetMapping("/info/{id}")  //C
	public String getInfo(Model model, @PathVariable Long id) { //M
//		Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);//Hibernate: select * from airplane where id = {id}
//		model.addAttribute("airplane", airplaneOptional.orElse(new Airplane()));
		return "airplane/infoView";
	}

}
