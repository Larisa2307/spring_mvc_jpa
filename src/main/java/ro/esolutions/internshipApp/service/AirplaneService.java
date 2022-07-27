package ro.esolutions.internshipApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.internshipApp.entity.Airplane;
import ro.esolutions.internshipApp.repository.AirplaneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneService {
	final AirplaneRepository airplaneRepository;


	public Airplane getAirplanesByName() {
		return airplaneRepository.findByName("F22");

	}
}
