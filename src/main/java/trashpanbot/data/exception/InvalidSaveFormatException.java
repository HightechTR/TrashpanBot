package trashpanbot.data.exception;

import java.io.IOException;

/**
 * Thrown during save load when save file is in an invalid format.
 * This usually indicates a corrupted save file.
 */
public class InvalidSaveFormatException extends IOException {
    public InvalidSaveFormatException(String message) {
        super(message);
    }
}
