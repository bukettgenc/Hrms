package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	DataResult<Education> add(Education education);

	DataResult<List<Education>> findAllOrderByGraduatedDateDesc();
}
