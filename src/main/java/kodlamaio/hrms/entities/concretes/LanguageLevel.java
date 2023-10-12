package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "languageLevels")
@JsonIgnoreProperties({"hibernateLazyInitilazer","handler","languages"})
public class LanguageLevel {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private Integer Id;
	
	@Column(name = "language_level")
	@NotNull
	@NotBlank(message = "Dil seviyesi boş olamaz")
	private String languageLevel;

	

}
