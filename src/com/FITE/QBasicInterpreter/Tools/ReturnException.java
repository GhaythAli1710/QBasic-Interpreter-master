package com.FITE.QBasicInterpreter.Tools;
/**/
public class ReturnException extends Exception {
	/**/
	private static final long serialVersionUID = 110629117875938566L;
	public Object ret;
	/**/
	public ReturnException(Object ret) {
		super();
		this.ret = ret;
		// TODO Auto-generated constructor stub
	}

	public ReturnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ReturnException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReturnException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReturnException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
