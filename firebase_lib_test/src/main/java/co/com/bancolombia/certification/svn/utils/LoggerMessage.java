package co.com.bancolombia.certification.svn.utils;

public class LoggerMessage {

    public static final String SUCCESSFULLY_FIREBASE_CONNECTION = "Firebase connection initialized successfully.";
    public static final String ERROR_FIREBASE_CONNECTION = "Error initializing Firebase connection.";
    public static final String ERROR_FIREBASE_CLOSE_CONNECTION = "Error closing Firebase connection.";
    public static final String SUCCESSFULLY_FIREBASE_CLOSE_CONNECTION = "Firebase connection closed successfully.";
    public static final String SEARCHING_PATTERN_ERROR = "Exist a problem trying to read the file, please verify path.";
    public static final String COMMAND_LINE_ERROR = "The command must contain at least 4 parts.";
    public static final String FEATURE_LINE_ERROR = "No valid query pattern has been found.";
    private LoggerMessage(){
        throw new IllegalStateException("Utility Class");
    }
}
