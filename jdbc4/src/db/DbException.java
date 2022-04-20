package db;

//My personalized exception of type RuntimeException (don't require any treatment)
public class DbException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);
	}

}
