package ro.esolutions.internshipApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.esolutions.internshipApp.dto.Mark;
import ro.esolutions.internshipApp.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student") //acesta se propaga pe toate mappingurile din aceasta clasa
///myapp/student/dashboard
public class StudentController {
	// MVC
	// Requestul din browser ------> 	C
	// return String ->  denumirea V  (html)


	//endpointuri  (MVC)      REST: (API-uri)
	@GetMapping("/dashboard")   ///C
	public String getDashboard(Model model) { //M
		model.addAttribute("firstStudent", "Ion Popescu");
		model.addAttribute("secondStudent", "Gigi");
		model.addAttribute("result", 5);
		model.addAttribute("ploua", getRandomBoolean());
		model.addAttribute("names", List.of("Alex", "Ion", "Andrei"));
		model.addAttribute("numbers", List.of(100, 200, 300, 400));
		model.addAttribute("youngStudents", getYoungStudents());

		return "student/dashboardView";  /// V    fara .html,  dar vezi in app.properties configurarea pt mustache spring.mustache.suffix=.html
	}

	// PathVariable (/info/7)   vs   RequestParam (/info?id=7)

	@GetMapping("/info/{id}")  // {id}  ->  PathVariable  ->  e automat detectat in html acum
	public String getInfo(Model model, @PathVariable Integer id) {
		Map<Integer, Student> map = getStudentMap();
		model.addAttribute("student", map.get(id));

		return "student/infoView"; //view-ul -> html-ul
	}

//	http://localhost:8086/myapp/student/cat?name=mitzi
	//studentul are mai multe pisici si vreau sa aflu info despre fiecare in parte
	@GetMapping("/cat")  //
	public String getCatInfo(Model model, @RequestParam String name,
							 @RequestParam String color) {
		model.addAttribute("name", name);
		model.addAttribute("color", color);

		return "student/catView"; //view-ul -> html-ul
	}

	private Map<Integer, Student> getStudentMap() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(22, "Alex", List.of(new Mark("2"), new Mark("3"))));
		map.put(2, new Student(33, "Ioana", List.of(new Mark("2"), new Mark("3"))));
		map.put(3, new Student(11, "Ana", List.of(new Mark("2"), new Mark("3"))));
		return map;
	}


	private List<Student> getYoungStudents() {
		return getAllStudents().stream()
				.filter(s -> s.getAge() < 35)
				.collect(Collectors.toList());
	}

	private List<Student> getAllStudents() {
		return List.of(
				new Student(20, "Alex", List.of(new Mark("4"), new Mark("5"))),
				new Student(30, "Andrei", List.of()),
				new Student(40, "Ion", List.of()),
				new Student(15, "Eva", List.of()),
				new Student(1, "Corina", List.of()),
				new Student(210, "Elena", List.of())
		);
	}

	private boolean getRandomBoolean() {
		return new Random().nextInt(20) % 2 == 0;
	}

}



