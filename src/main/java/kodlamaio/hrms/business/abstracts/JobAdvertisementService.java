package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.AllActiveJobAdvertisementsDto;

public interface JobAdvertisementService {
	 DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);
	
	 DataResult<List<JobAdvertisement>> findAllByStatus();
	
	 DataResult<List<JobAdvertisement>> findAllByStatusOrderByDate();

	 DataResult<List<JobAdvertisement>> findAllByStatusAndCompany(int id);

	 DataResult<List<AllActiveJobAdvertisementsDto>> getJobAdvertisementsWithDetails();
	 
	 DataResult<JobAdvertisement> updateStatus(int id);

}
