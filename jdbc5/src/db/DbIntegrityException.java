package db;

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String msg) { //force msg to the constructor
		super(msg); //pass the string to the super class
	}

}
