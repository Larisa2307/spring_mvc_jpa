package ro.esolutions.internshipApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private Integer width;

	@ManyToOne   // many dogs pe one color
	@JoinColumn(name = "color.id")
	private Color color;  // numeric  color_id
}
