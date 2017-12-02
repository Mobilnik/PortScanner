package ru.ncedu.iauli;

import ru.ncedu.iauli.scanner.PortScanner;
import ru.ncedu.iauli.utils.InputData;

/**
 * @author Ilya Ulitin
 */
public class Main {

    public static void main(String[] args) {
        InputData data = new InputData();
        PortScanner.scan(data);
    }
}
