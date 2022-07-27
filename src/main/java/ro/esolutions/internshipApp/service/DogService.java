package ro.esolutions.internshipApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.internshipApp.entity.Dog;
import ro.esolutions.internshipApp.repository.DogRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DogService {

	final DogRepository dogRepository;

	public List<Dog> getDogsByName(String name) {
		return dogRepository.findByNameIgnoreCase(name) //3 labusi
				.stream()
				.filter(dog -> dog.getWidth() > 100)  //2 labusi
				.collect(Collectors.toList());
	}

	public List<Dog> getDogsWithColor(String color) {
		return dogRepository.findByColorValue(color);
	}
}
