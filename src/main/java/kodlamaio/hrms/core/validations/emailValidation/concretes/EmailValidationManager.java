package kodlamaio.hrms.core.validations.emailValidation.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validations.emailValidation.abstracts.EmailValidationService;

@Service
public class EmailValidationManager implements EmailValidationService {
	@Override
	public boolean emailValidate(String email) {
		return true;

	}
}
