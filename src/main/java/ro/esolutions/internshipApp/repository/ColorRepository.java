package ro.esolutions.internshipApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.internshipApp.entity.Color;
import ro.esolutions.internshipApp.entity.Dog;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
