package exceptions;

public class ValidationException extends RuntimeException{

	private final String fieldName ;
	private final String fieldMessage ;
	
	
	public ValidationException( String field , String message ) {
		
		fieldName = field;
		fieldMessage = message;
	}
	@Override
	public String getMessage() {
		
		return "Error ["+fieldName+"] " + fieldMessage;
	}
	public String getField() {
		return fieldName;
	}
	public String getJustMessage() {
		return fieldMessage;
	}
	private static final long serialVersionUID = 1998754L;

}
