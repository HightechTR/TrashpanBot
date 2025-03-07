package trashpanbot.common;

import trashpanbot.data.exception.StringArrayEmptyException;

/**
 * Represents general utilities used by TrashpanBot.
 */
public class Utils {

    /**
     * Checks if a string is empty.
     *
     * @param input The input string to be checked.
     * @return The input string if it is non-empty.
     * @throws StringArrayEmptyException if string is empty.
     */
    public static String checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new StringArrayEmptyException("String is empty");
        }
        return input;
    }
}
