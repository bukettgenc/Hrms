package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {
	@Autowired
	private PositionDao positionDao;

	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "Pozisyonlar listelendi.");
	}

	@Override
	public DataResult<Position> add(Position position) {
		// TODO Auto-generated method stub
		if (this.positionDao.existsByName(position.getName())) {
			return new ErrorDataResult<Position>(position, "Bu pozisyonlar tekrar edemez.");
		}
		this.positionDao.save(position);
		return new SuccessDataResult<Position>(position, "Pozisyon sisteme kaydedildi.");
	}

}
