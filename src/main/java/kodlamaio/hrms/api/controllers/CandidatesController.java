package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {

	@Autowired
	private final CandidateService candidateService;

	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public DataResult<Candidate> add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
}
