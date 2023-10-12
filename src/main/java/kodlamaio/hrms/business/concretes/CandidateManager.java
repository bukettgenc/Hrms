package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.validations.emailValidation.abstracts.EmailValidationService;
import kodlamaio.hrms.core.validations.mernisValidation.abstracts.MernisValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MernisValidationService mernisValidationService;

	@Autowired
	private EmailValidationService emailValidationService;

	public CandidateManager(CandidateDao candidateDao, UserDao userDao, MernisValidationService mernisValidationService,
			EmailValidationService emailValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.mernisValidationService = mernisValidationService;
		this.emailValidationService = emailValidationService;
	}
	
	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		if (!candidateIsNullOrEmpty(candidate)) {
			return new ErrorDataResult<Candidate>(candidate, "İş arayan bilgileri geçersiz lütfen kontrol ediniz.");
		}
		if (!passwordControl(candidate.getPassword(), candidate.getRepassword())) {
			return new ErrorDataResult<Candidate>(candidate, "Girilen şifreler eşleşmiyor lütfen tekrar deneyiniz.");
		}
		if (!this.mernisValidationService.mernisValidate(candidate.getIdentityNumber())) {
			return new ErrorDataResult<Candidate>(candidate, "Doğrulama yapılamadı.");
		}
		if (!this.emailValidationService.emailValidate(candidate.getEMail())) {
			return new ErrorDataResult<Candidate>(candidate, "Doğrulama yapılamadı.");
		}
		if (this.candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorDataResult<Candidate>(candidate, "Bu tckn ile kayıt mevcut.");
		}
		if (this.userDao.existsByeMail(candidate.getEMail())) {
			return new ErrorDataResult<Candidate>(candidate, "Bu email ile kayıt mevcut.");
		}
		this.candidateDao.save(candidate);
		return new SuccessDataResult<Candidate>(candidate, "İş arayan sisteme kaydedildi.");
	}

	public boolean passwordControl(String password, String rePassword) {
		if (password.equals(rePassword)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean candidateIsNullOrEmpty(Candidate candidate) {
		if (candidate.getName().equals("") || candidate.getName() == null) {
			return false;
		} else if (candidate.getSurname().equals("") || candidate.getSurname() == null) {
			return false;
		} else if (candidate.getIdentityNumber().equals("") || candidate.getIdentityNumber() == null) {
			return false;
		} else if (candidate.getBirthYear() == 0 || candidate.getBirthYear() < 0) {
			return false;
		} else if (candidate.getEMail().equals("") || candidate.getEMail() == null) {
			return false;
		} else if (candidate.getPassword().equals("") || candidate.getPassword() == null) {
			return false;
		} else if (candidate.getRepassword().equals("") || candidate.getRepassword() == null) {
			return false;
		}

		return true;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listeleme başarılı");
	}
}
