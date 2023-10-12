package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.AllActiveJobAdvertisementsDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByStatus(Boolean status);

	List<JobAdvertisement> findByStatusOrderByLastAdvertisementDate(Boolean status);

	List<JobAdvertisement> findByStatusAndCompany_Id(Boolean status, Integer id);

	JobAdvertisement findById(int id);

	@Query("select new kodlamaio.hrms.entities.dtos.AllActiveJobAdvertisementsDto(c.companyName,p.name,j.personCount,j.lastAdvertisementDate) From JobAdvertisement j Inner Join j.company c Inner Join j.position p where j.status =:status")
	List<AllActiveJobAdvertisementsDto> getJobAdvertisementsWithDetails(Boolean status);

}
