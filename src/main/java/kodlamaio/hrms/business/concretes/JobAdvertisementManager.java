package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.AllActiveJobAdvertisementsDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	@Autowired
	private JobAdvertisementDao jobAdvertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		if (!jobAdvertisementIsNullOrEmpty(jobAdvertisement)) {
			return new ErrorDataResult<JobAdvertisement>(jobAdvertisement, "Lütfen zorunlu alanları doldurunuz.");
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisement, "İş ilanı kaydedildi");
	}

	public boolean jobAdvertisementIsNullOrEmpty(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getPosition() == null) {
			return false;
		} else if (jobAdvertisement.getAdvertisementContent().equals("")
				|| jobAdvertisement.getAdvertisementContent() == null) {
			return false;
		} else if (jobAdvertisement.getCity() == null) {
			return false;
		} else if (jobAdvertisement.getPersonCount() == 0 || jobAdvertisement.getPersonCount() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatus() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatus(true),
				"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatusOrderByDate() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByStatusOrderByLastAdvertisementDate(true),
				"Aktif iş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatusAndCompany(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findByStatusAndCompany_Id(true, id),
				"Aktif iş ilanları şirkete göre listelendi");
	}

	@Override
	public DataResult<List<AllActiveJobAdvertisementsDto>> getJobAdvertisementsWithDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<AllActiveJobAdvertisementsDto>>(
				this.jobAdvertisementDao.getJobAdvertisementsWithDetails(true),
				"Aktif iş ilanları şirkete göre listelendi");
	}

	@Override
	public DataResult<JobAdvertisement> updateStatus(int id) {
		// TODO Auto-generated method stub
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id);
		System.out.print("jobAdvertisement:" + jobAdvertisement.getJobAdvertisementId());
		jobAdvertisement.setStatus(false);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement),"İlan pasifleştirildi.");
	}

}
