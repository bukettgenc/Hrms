package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageLevelResumeLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {
	
	//SORULACAK
	//Teknoloji ekleme endpointine resumeu json ignore yapıp aşağıda eklerken
	//resumedaodan resumeı çekip setleyip yapmam doğru mu? Eğer bu böyleyse sadece
	//teknoloji ekleme methodu kullanılırsa oraya resumeı elle vermem gerekirse nasıl vereceğim null gitmiş oluyor.
	
	private ResumeDao resumeDao;
	private EducationDao educationDao;
	private JobExperienceDao jobExperienceDao;
	private PositionDao positionDao;
	private CompanyDao companyDao;
	private TechnologyDao technologyDao;
	private LanguageLevelResumeLanguageDao languageLevelResumeLanguageDao;

	public ResumeManager(ResumeDao resumeDao, EducationDao educationDao, JobExperienceDao jobExperienceDao,
			PositionDao positionDao, CompanyDao companyDao, TechnologyDao technologyDao,
			LanguageLevelResumeLanguageDao languageLevelResumeLanguageDao) {
		super();
		this.resumeDao = resumeDao;
		this.educationDao = educationDao;
		this.jobExperienceDao = jobExperienceDao;
		this.positionDao = positionDao;
		this.companyDao = companyDao;
		this.technologyDao = technologyDao;
		this.languageLevelResumeLanguageDao = languageLevelResumeLanguageDao;
	}

	@Override
	public DataResult<ResumeDto> add(ResumeDto resumeDto) {
		// resume kaydet
		Resume resume = this.resumeDao.save(resumeDto.getResume());
		resumeDto.getEducations().forEach(x -> x.setResume(resume));

		// education kaydet
		this.educationDao.saveAll(resumeDto.getEducations());

		// job experience kaydet
		resumeDto.getJobExperiences().forEach(je -> {
			je.setResume(resume);
			// burada pozisyon ve şirket bilgilerini input olarak girmesini bekliyorum
			this.positionDao.save(je.getPosition());
			this.companyDao.save(je.getCompany());
		});
		this.jobExperienceDao.saveAll(resumeDto.getJobExperiences());

		// technology kaydet
		resumeDto.getTechnologies().forEach(t -> t.setResume(resume));
		this.technologyDao.saveAll(resumeDto.getTechnologies());

		// language - language level- resume kaydet
		resumeDto.getLanguageLevelResumeLanguages().forEach(l -> {
			l.setResume(resume);

		});
		;
		this.languageLevelResumeLanguageDao.saveAll(resumeDto.getLanguageLevelResumeLanguages());

//		this.resumeTechnologyDao.saveAll(resumeDto.getResumeTechnologies());
//		this.languageLevelResumeLanguageDao.saveAll(resumeDto.getLanguageLevelResumeLanguages());
		return new SuccessDataResult<ResumeDto>(resumeDto, "Cv sisteme kaydedildi.");

	}
}
