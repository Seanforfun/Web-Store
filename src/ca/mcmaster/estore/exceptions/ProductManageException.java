package ca.mcmaster.estore.exceptions;

public class ProductManageException extends RuntimeException {

	public ProductManageException() {
		super();
	}

	public ProductManageException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductManageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductManageException(String arg0) {
		super(arg0);
	}

	public ProductManageException(Throwable arg0) {
		super(arg0);
	}

}
