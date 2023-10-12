package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	@Autowired
	private EducationDao educationDao;

	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<Education> add(Education education) {
		// TODO Auto-generated method stub
		this.educationDao.save(education);
		return new SuccessDataResult<Education>(education, "Eğitim bilgileri kaydedildi.");
	}

	@Override
	public DataResult<List<Education>> findAllOrderByGraduatedDateDesc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByOrderByGraduatedDateDesc(),
				"Mezuniyet tarihine göre listelendi");
	}
	
}
