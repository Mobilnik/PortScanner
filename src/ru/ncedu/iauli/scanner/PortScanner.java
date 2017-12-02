package ru.ncedu.iauli.scanner;

import ru.ncedu.iauli.utils.IncorrectHostAddressException;
import ru.ncedu.iauli.utils.IncorrectPortNumbersException;
import ru.ncedu.iauli.utils.InputData;
import ru.ncedu.iauli.utils.Parser;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The class provides users with the core of API for scanning ports.
 *
 * @author Ilya Ulitin
 */
public class PortScanner {

    /**
     * The methods provides entering the (@code InputData) using console input
     * (e.g. host address, range of the numbers of the ports to be scanned).
     *
     * @param data - data block with address of the server and the range of ports to be scanned.
     */

    private static boolean handleInput(InputData data) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter the host address: ");
        data.setHostAddress(reader.next());
        try {
            Parser.parseHostAddress(data);
        } catch (IncorrectHostAddressException e) {
            System.out.println(e.toString());
            return false;
        }

        System.out.println("Please, enter the number of the first port from the range to be scanned: ");
        data.setStartPortRange(reader.nextInt());
        System.out.println("Please, enter the number of the last port from the range to be scanned: ");
        data.setFinishPortRange(reader.nextInt());
        try {
            Parser.checkPortsRange(data);
        } catch (IncorrectPortNumbersException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    /**
     * The method checks if the current port is available for reading or not
     * by trying to open a socket.
     *
     * @param data - data block with address of the server and the range of ports to be scanned.
     * @param port - the number of the port to be checked
     */
    private static void checkPort(InputData data, int port) {
        try (Socket socket = new Socket(data.getHostAddress(), port)) {
            String text = data.getHostAddress() + " has got an opened port " + port;
            System.out.println(text);
            socket.close();
        } catch (IOException e) {
            String s = data.getHostAddress() + " has got a closed port " + port;
            System.out.println(s);
        }
    }

    /**
     * The method provides iteration over the specified scanning range. It calls
     * (@code checkPort) for every iterated port.
     *
     * @param data - data block with address of the server and the range of ports to be scanned.
     */
    public static void scan(InputData data) {
        boolean possibleToScan = handleInput(data);

        if (possibleToScan) {
            System.out.println("Scanning started: ");

            int finalPort = data.getFinishPortRange();
            int startPort = data.getStartPortRange();
            for (int port = startPort; port <= finalPort; port++) {
                checkPort(data, port);
            }
        }
    }
}
