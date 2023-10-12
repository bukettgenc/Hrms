package kodlamaio.hrms.entities.dtos;

import java.util.List;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.LanguageLevelResumeLanguage;
import lombok.Data;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.Technology;

@Data
public class ResumeDto {

	Resume resume;

	List<Education> educations;

//	List<LanguageLevelResumeLanguage> languageLevelResumeLanguages;

	List<JobExperience> jobExperiences;

	List<Technology> technologies;

	List<LanguageLevelResumeLanguage> languageLevelResumeLanguages;
}
