package ro.esolutions.internshipApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.esolutions.internshipApp.entity.Airplane;

import java.util.List;


//acum avem legatura dintre BE si  BD  -> prin JpaRepository din Spring Data Jpa(pom.xml)  JPA = java persistance api
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
	Airplane findByName(String name);

	List<Airplane> findByAge(Integer age);

	Airplane findByNameAndAge(String name, Integer age);

	List<Airplane> findAllByNameOrderByAge(String name);

	List<Airplane> findAllByOrderByAge();

	List<Airplane> findByNameIgnoreCase(String name);

	List<Airplane> findByNameContaining(String letters);

	List<Airplane> findByAgeGreaterThanEqual(Integer age);

	Integer countByAgeGreaterThanEqual(Integer age);

	@Query(value = "select * from Airplane where id>=:id", nativeQuery = true)
	List<Airplane> getAirplanesWithIdGreaterThan(Long id);

}
