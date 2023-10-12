package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyService {
	
	 DataResult<Company> add(Company company);

	 DataResult<List<Company>> getAll();
	
}
