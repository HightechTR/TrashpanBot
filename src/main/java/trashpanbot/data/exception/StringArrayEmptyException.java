package trashpanbot.data.exception;

/**
 * Thrown if an element of a String array is empty.
 * Extends IndexOutOfBoundsException to aid in implementation of the parser.
 */
public class StringArrayEmptyException extends IndexOutOfBoundsException {
    public StringArrayEmptyException(String s) {
        super(s);
    }
}
