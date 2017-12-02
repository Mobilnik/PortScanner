package ru.ncedu.Utils;

/**
 * An exception, that is thrown when (@code Parser) was unable to handle the start and the stop numbers of
 * the scanning ports range.
 *
 * @author Ilya Ulitin
 */
public class IncorrectPortNumbersException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     */
    public IncorrectPortNumbersException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized.
     *
     * @param message the detail message.
     */
    public IncorrectPortNumbersException(String message) {
        super(message);
    }
}
