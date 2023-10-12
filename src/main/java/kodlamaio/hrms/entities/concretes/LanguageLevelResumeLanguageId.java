package kodlamaio.hrms.entities.concretes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LanguageLevelResumeLanguageId  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(name = "language_level_id")
    private Long languageLevelId;
    @Column(name = "language_id")
    private Long languageId;
    @Column(name = "resume_id")
    private Long resumeId;
}
