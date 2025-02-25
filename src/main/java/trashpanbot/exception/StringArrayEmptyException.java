package trashpanbot.exception;

public class StringArrayEmptyException extends IndexOutOfBoundsException {
    // Exception thrown when a String in a parsed String input array is empty.
    // Extends IndexOutOfBoundsException for catch statement to catch both
    // ArrayIndexOutOfBoundsException and this exception.

    public StringArrayEmptyException(String s) {
        super(s);
    }
}
