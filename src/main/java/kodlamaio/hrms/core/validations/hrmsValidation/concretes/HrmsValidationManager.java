package kodlamaio.hrms.core.validations.hrmsValidation.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validations.hrmsValidation.asbtracts.HrmsValidationService;

@Service
public class HrmsValidationManager implements HrmsValidationService{

	@Override
	public boolean hrmsValidate(String eMail) {
		return true;

	}

}
