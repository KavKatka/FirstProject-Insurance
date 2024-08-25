package cz.itnetwork;

import java.util.Scanner;

public class FormatovaniTextu {
    Scanner scanner;

    /**
     * Metoda naformatuje text - jméno, příjmení
     *
     * @param text Text k formátování
     * @return Naformátovaný text
     */
    public String formatujText(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }



}
