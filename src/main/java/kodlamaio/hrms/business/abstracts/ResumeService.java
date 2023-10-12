package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {
	DataResult<ResumeDto> add(ResumeDto resumeDto) ;
}
