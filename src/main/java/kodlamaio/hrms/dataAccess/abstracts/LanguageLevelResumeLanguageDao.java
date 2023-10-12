package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.LanguageLevelResumeLanguage;
import kodlamaio.hrms.entities.concretes.LanguageLevelResumeLanguageId;

public interface LanguageLevelResumeLanguageDao extends JpaRepository<LanguageLevelResumeLanguage,LanguageLevelResumeLanguageId>{

}
