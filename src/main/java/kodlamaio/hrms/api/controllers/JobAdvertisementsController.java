package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.AllActiveJobAdvertisementsDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {
	
	@Autowired
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public DataResult<JobAdvertisement> add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/updateStatus")
	public DataResult<JobAdvertisement> updateStatus(@RequestParam int id){
		return this.jobAdvertisementService.updateStatus(id);
	}

	@GetMapping("/findAllByStatus")
	public DataResult<List<JobAdvertisement>> findAllByStatus(){
		return this.jobAdvertisementService.findAllByStatus();
	}
	
	@GetMapping("/findAllByStatusOrderByDate")
	public DataResult<List<JobAdvertisement>> findAllByStatusOrderByDate(){
		return this.jobAdvertisementService.findAllByStatusOrderByDate();
	}
	
	@GetMapping("/findAllByStatusAndCompany")
	public DataResult<List<JobAdvertisement>> findAllByStatusAndCompany(int id){
		return this.jobAdvertisementService.findAllByStatusAndCompany(id);
	}
	
	@GetMapping("/getJobAdvertisementsWithDetails")
	public DataResult<List<AllActiveJobAdvertisementsDto>> getJobAdvertisementsWithDetails(){
		return this.jobAdvertisementService.getJobAdvertisementsWithDetails();
	}
}
