package co.com.bancolombia.certification.svn.application.exceptions;

public class CustomException extends RuntimeException{

    public static final String FIREBASE_ERROR_CONNECTION = "Error initializing Firebase connection";
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
