package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="jobAdvertisements")
@Data
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private Integer jobAdvertisementId;

	@Column(name="advertisement_name")
	private String advertisementName;

	@Column(name="advertisement_content")
	@NotNull(message = "İlan içeriğini doldurunuz.")
	@NotBlank(message = "İlan içeriğini doldurunuz.")
	private String advertisementContent;

	@Column(name="salary_min")
	private Double salaryMin;
	
	@Column(name="salary_max")
	private Double salaryMax;
	
	@Column(name="person_count")
	@NotNull
	@NotBlank
	private Integer personCount;
	
	@Column(name="last_advertisement_date")
	private Date lastAdvertisementDate;
	
	@Column(name="status")
	private Boolean status;
	
	@ManyToOne()
	@JoinColumn(name="position_id")
	@NotNull
	@NotBlank
	private Position position;

	@ManyToOne()
	@JoinColumn(name="city_id")
	@NotNull
	@NotBlank
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="company_id")
	private Company company;


}
