package ru.ncedu.iauli.utils;

/**
 * The class (@code InputData) provides user with several setters and getters of host address and
 * ports' range.
 * * @author Ilya Ulitin
 */

public class InputData {

    private String hostAddress;
    private int startPortRange;
    private int finishPortRange;

    /**
     * Constructs a new data block with default parametrs, such as "localhost" as a hostAddress
     * and all ports from 0 to 65535 to be checked in further.
     */
    public InputData() {
        hostAddress = "localhost";
        startPortRange = 0;
        finishPortRange = 65535;
    }

    /**
     * @return host address from the current data as a {@code String}.
     */
    public String getHostAddress() {
        return hostAddress;
    }

    /**
     * @return the {@code int} number of the port that will be scanned at first.
     */
    public int getStartPortRange() {
        return startPortRange;
    }

    /**
     * @return the {@code int} number of the port that will be scanned at last.
     */
    public int getFinishPortRange() {
        return finishPortRange;
    }

    /**
     * @param hostAddress - {@code String} to be set in the Class as an address of the host.
     */
    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    /**
     * @param startPortRange - {@code int} number of the port that will be scanned at first.
     */
    public void setStartPortRange(int startPortRange) {
        this.startPortRange = startPortRange;
    }

    /**
     * @param finishPortRange - {@code int} number of the port that will be scanned at last.
     */
    public void setFinishPortRange(int finishPortRange) {
        this.finishPortRange = finishPortRange;
    }
}
