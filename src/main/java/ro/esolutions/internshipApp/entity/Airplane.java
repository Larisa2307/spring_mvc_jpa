package ro.esolutions.internshipApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter    //adresata lui LOMBOK
@Setter // adresata lui Lombok
@AllArgsConstructor  //adresata lui LOMBOK
@NoArgsConstructor  //adresata lui LOMBOK
@ToString  //adresata lui LOMBOK
@Entity   //adresata in jpa lui Hibernate
@Table    //adresata in jpa lui Hibernate
public class Airplane {
	@Id    //adresata in jpa lui Hibernate -> primary key
	@Column(name="id")    //adresata in jpa lui Hibernate
	@GeneratedValue(strategy = GenerationType.AUTO)    //adresata in jpa lui Hibernate
	private Long id;

	@Column
	private Integer age;

	@Column
	private String name;
}
