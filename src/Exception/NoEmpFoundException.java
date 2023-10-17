package Exception;

public class NoEmpFoundException extends Exception {
	private String excMes;

	public NoEmpFoundException() {
		super();
	}

	public NoEmpFoundException(String excMes) {
		super();
		this.excMes = excMes;
		System.out.println(this.excMes);
	}
	
	
	
}
