package kodlamaio.hrms.entities.concretes;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "languageLevelResumeLanguages")
public class LanguageLevelResumeLanguage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected LanguageLevelResumeLanguageId languageLevelResumeLanguageId;
	
	@ManyToOne()
	@JoinColumn(name = "language_id", insertable = false, updatable = false)
	private Language language;

	@ManyToOne()
	@JoinColumn(name = "language_level_id", insertable = false, updatable = false)
	private LanguageLevel languageLevel;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	private Resume resume;
}
