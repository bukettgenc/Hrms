package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result {
	public ErrorResult() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	public ErrorResult(String message) {
		super(false, message);
		// TODO Auto-generated constructor stub
	}
}
