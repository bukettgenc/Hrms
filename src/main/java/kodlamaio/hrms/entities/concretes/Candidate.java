package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = false)	
public class Candidate extends User {

	@Column(name = "name")
	@NotBlank(message="İsim boş olamaz")
	private String name;

	@Column(name = "surname")
	@NotBlank(message="Soyisim boş olamaz")
	private String surname;

	@Column(name = "identity_number")
	@NotNull
	@NotBlank(message="TC Kimlik Numarası alanı boş olamaz") 
	@Size(max=11,min=11,message="TC Kimlik Numarası 11 hane olmalıdır")
	private String identityNumber;

	@Column(name = "birth_year")
	@NotNull
	@NotBlank
	private Long birthYear;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="position_id")
	private Position position;
}
