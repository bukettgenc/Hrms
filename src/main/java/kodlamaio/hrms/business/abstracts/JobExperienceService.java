package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	DataResult<JobExperience> add(JobExperience jobExperience);

	DataResult<List<JobExperience>> findAllOrderByFinishDateDesc();
}
