package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "companies")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitilazer","handler","jobAdvertisements"})
public class Company extends User {

	@Column(name = "company_name")
	@NotNull
	@NotBlank(message = "Şirket adı boş olamaz")
	private String companyName;

	@Column(name = "web_site")
	@NotNull
	@NotBlank
	private String webSite;

	@Column(name = "phone_number")
	@NotNull
	@NotBlank
	private String phoneNumber;

	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;

}
