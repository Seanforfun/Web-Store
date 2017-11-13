package ca.mcmaster.estore.exceptions;

public class EncodingFilterException extends Exception {

	public EncodingFilterException() {
		super();
	}

	public EncodingFilterException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EncodingFilterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EncodingFilterException(String arg0) {
		super(arg0);
	}

	public EncodingFilterException(Throwable arg0) {
		super(arg0);
	}
}
