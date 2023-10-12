package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	@Autowired
	private JobExperienceDao jobExperienceDao;

	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<JobExperience> add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessDataResult<JobExperience>(jobExperience, "İş tecrübesi kaydedildi.");
	}

	@Override
	public DataResult<List<JobExperience>> findAllOrderByFinishDateDesc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByOrderByFinishDateDesc(),
				"İşten ayrılma tarihine göre listelendi");

	}

}
