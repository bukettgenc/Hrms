package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	@Autowired
	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<City> add(City city) {
		// TODO Auto-generated method stub
		this.cityDao.save(city);
		return new SuccessDataResult<City>(city,"Şehir eklendi");
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}
}
