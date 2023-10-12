package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "positions")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobExperiences", "jobAdvertisements",
		"systemEmployees" })
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "position")
	@JsonIgnore
	private List<SystemEmployee> systemEmployees;

	@OneToMany(mappedBy = "position")
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;

	@OneToMany(mappedBy = "position")
	@JsonIgnore
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "position")
	@JsonIgnore
	private List<Candidate> candidates;

}
