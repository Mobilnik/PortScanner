package ru.ncedu;

import ru.ncedu.PortScanner.PortScanner;
import ru.ncedu.Utils.InputData;

/**
 * @author Ilya Ulitin
 */
public class Main {

    public static void main(String[] args) {
        InputData data = new InputData();
        PortScanner.scan(data);
    }
}
