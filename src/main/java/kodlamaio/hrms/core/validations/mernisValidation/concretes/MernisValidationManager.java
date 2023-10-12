package kodlamaio.hrms.core.validations.mernisValidation.concretes;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.validations.mernisValidation.abstracts.MernisValidationService;

@Service
public class MernisValidationManager implements MernisValidationService {

	@Override
	public boolean mernisValidate(String identity_number) {
		return true;

	}

}
