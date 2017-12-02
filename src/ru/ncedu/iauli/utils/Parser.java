package ru.ncedu.iauli.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class (@code Parser) provides user with possibility to check the correctness
 * of the entered host address as a field of the entered (@code InputData).
 *
 * @author Ilya Ulitin
 */
public class Parser {

    /**
     * The method allows to check if the entered host address matches
     * pattern of IP (blocks contain numbers from 0 to 255) or URL (with any number of domains,
     * domains' names' lengths equal or shorter than 63 symbols, not case sensitive, only English letters and numbers) address.
     *
     * @param data - (@code InputData) with a host address set as a corresponding field.
     */
    public static void parseHostAddress(InputData data) throws IncorrectHostAddressException {
        String IPADDRESS_PATTERN = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        String DOMAIN_NAME_PATTERN = "\\b((?=[a-z0-9-]{1,63}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,63}\\b";

        Pattern ipAddress = Pattern.compile(IPADDRESS_PATTERN);
        Pattern domainName = Pattern.compile(DOMAIN_NAME_PATTERN);
        Matcher matcherIpAddress = ipAddress.matcher(data.getHostAddress());
        Matcher matcherDomainName = domainName.matcher(data.getHostAddress());

        if (matcherDomainName.matches() || matcherIpAddress.matches()) return;
        throw new IncorrectHostAddressException("Wrong host address");
    }

    /**
     * The method allows to check if the specified range of ports was set correctly
     * (e.g. no negative numbers, no numbers greater than 65535".
     * If the number of the specified start port is greater than the number of the specified stop port,
     * the method swaps them.
     *
     * @param data - (@code InputData) with a host address set as a corresponding field.
     */
    public static void checkPortsRange(InputData data) throws IncorrectPortNumbersException {
        if (data.getStartPortRange() < 0 || data.getFinishPortRange() < 0)
            throw new IncorrectPortNumbersException("Ports' numbers can't be negative");
        if (data.getFinishPortRange() > 65535 || data.getStartPortRange() > 65535)
            throw new IncorrectPortNumbersException("Ports' numbers can't be more than 65535");
        if (data.getStartPortRange() > data.getFinishPortRange()) {
            int tempPort = data.getStartPortRange();
            data.setStartPortRange(data.getFinishPortRange());
            data.setFinishPortRange(tempPort);
        }
    }
}
