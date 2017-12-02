package ru.ncedu.iauli.utils;

/**
 * An exception, that is thrown when (@code Parser) was unable to
 * parse an URL or IP address from the (@code InputData).
 *
 * @author Ilya Ulitin
 */
public class IncorrectHostAddressException extends Exception {

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     */
    public IncorrectHostAddressException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized.
     *
     * @param message the detail message.
     */
    public IncorrectHostAddressException(String message) {
        super(message);
    }
}
