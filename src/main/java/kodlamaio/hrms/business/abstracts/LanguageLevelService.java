package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	DataResult<LanguageLevel> add(LanguageLevel languageLevel);
}
