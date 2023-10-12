package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "e_mail")
	private String eMail;

	@Column(name = "password")
	private String password;

	@Column(name = "repassword")
	// dbye kolon olarak eklememek için
	@Transient
	// @JsonProperty(access = Access.WRITE_ONLY)
	private String repassword;

	// @Temporal(TemporalType.DATE) (Tarih eklenirken DATE,TIME ve TIMESTAMP olarak
	// düzenlenip dbye ekleniyor.)

	// kayıt oluştururken tarih ve saati kendisi yazıyor
	// @CreationTimestamp

	@CreationTimestamp
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;

	@UpdateTimestamp
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;
}
