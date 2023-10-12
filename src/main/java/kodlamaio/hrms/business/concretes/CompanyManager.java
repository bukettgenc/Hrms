package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.validations.emailValidation.abstracts.EmailValidationService;
import kodlamaio.hrms.core.validations.hrmsValidation.asbtracts.HrmsValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private EmailValidationService emailValidationService;

	@Autowired
	private HrmsValidationService hrmsValidationService;
	

	public CompanyManager(CompanyDao companyDao, UserDao userDao, EmailValidationService emailValidationService,
			HrmsValidationService hrmsValidationService) {
		this.companyDao = companyDao;
		this.userDao = userDao;
		this.emailValidationService = emailValidationService;
		this.hrmsValidationService = hrmsValidationService;
	}

	@Override
	public DataResult<Company> add(Company company) {
		// TODO Auto-generated method stub
		if (!companyIsNullOrEmpty(company)) {
			return new ErrorDataResult<Company>(company, "İş veren bilgileri geçersiz lütfen kontrol ediniz.");
		}
		if (!passwordControl(company.getPassword(), company.getRepassword())) {
			return new ErrorDataResult<Company>(company, "Girilen şifreler eşleşmiyor lütfen tekrar deneyiniz.");
		}

		if (!this.emailValidationService.emailValidate(company.getEMail())) {
			return new ErrorDataResult<Company>(company, "Doğrulama yapılamadı.");
		}
		
		if (!this.hrmsValidationService.hrmsValidate(company.getEMail())) {
			return new ErrorDataResult<Company>(company, "Doğrulama yapılamadı.");
		}
		
		if (this.userDao.existsByeMail(company.getEMail())) {
			return new ErrorDataResult<Company>(company, "Bu email ile kayıt mevcut.");
		}
		this.companyDao.save(company);
		return new SuccessDataResult<Company>(company, "İş veren sisteme kaydedildi.");
	}

	public boolean passwordControl(String password, String rePassword) {
		if (password.equals(rePassword)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean companyIsNullOrEmpty(Company company) {
		if (company.getCompanyName().equals("") || company.getCompanyName() == null) {
			return false;
		} else if (company.getWebSite().equals("") || company.getWebSite() == null) {
			return false;
		} else if (company.getEMail().equals("") || company.getEMail() == null) {
			return false;
		} else if (company.getPhoneNumber().equals("") || company.getPhoneNumber() == null) {
			return false;
		} else if (company.getPassword().equals("") || company.getPassword() == null) {
			return false;
		} else if (company.getRepassword().equals("") || company.getRepassword() == null) {
			return false;
		}

		return true;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(), "Şirket listeleme başarılı");
	}

}
