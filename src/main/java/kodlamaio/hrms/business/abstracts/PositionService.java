package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Position;

public interface PositionService {
	DataResult<List<Position>>  getAll();

	DataResult<Position> add(Position position);
}
