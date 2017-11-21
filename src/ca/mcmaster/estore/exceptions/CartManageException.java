package ca.mcmaster.estore.exceptions;

public class CartManageException extends RuntimeException {

	public CartManageException() {
		super();
	}

	public CartManageException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CartManageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CartManageException(String arg0) {
		super(arg0);
	}

	public CartManageException(Throwable arg0) {
		super(arg0);
	}

}
