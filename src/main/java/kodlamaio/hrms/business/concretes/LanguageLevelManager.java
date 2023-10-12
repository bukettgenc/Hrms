package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelDao;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService {

	@Autowired
	private LanguageLevelDao languageLevelDao;

	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		super();
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public DataResult<LanguageLevel> add(LanguageLevel languageLevel) {
		// TODO Auto-generated method stub
		this.languageLevelDao.save(languageLevel);
		return new SuccessDataResult<LanguageLevel>(languageLevel, "Dil seviyesi eklendi.");
	}

}
