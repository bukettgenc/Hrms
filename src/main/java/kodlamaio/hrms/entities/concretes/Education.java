package kodlamaio.hrms.entities.concretes;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "school_name")
	@NotBlank(message = "Lütfen okul adı giriniz.")
	@NotNull
	private String schoolName;

	@Column(name = "department_name")
	@NotBlank(message = "Lütfen bölüm adı giriniz.")
	@NotNull
	private String departmentName;

	@Column(name = "start_date")
	@NotNull
	private Date startDate;

	@Column(name = "graduated_date")
	private Date graduatedDate;

	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
