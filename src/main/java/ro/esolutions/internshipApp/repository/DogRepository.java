package ro.esolutions.internshipApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.internshipApp.entity.Dog;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
	List<Dog> findByNameIgnoreCase(String name);

	List<Dog> findByColorValue(String colorValue);
}
