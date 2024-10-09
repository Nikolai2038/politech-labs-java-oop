package lab_3.exceptions;

// Custom exception for invalid file format
public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}
