package lab_3.exceptions;

// Custom exception for file read errors
public class FileReadException extends Exception {
    public FileReadException(String message) {
        super(message);
    }
}
