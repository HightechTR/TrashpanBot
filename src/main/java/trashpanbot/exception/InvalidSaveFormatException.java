package trashpanbot.exception;

import java.io.IOException;

public class InvalidSaveFormatException extends IOException {
    public InvalidSaveFormatException(String message) {
        super(message);
    }
}
