package cz.itnetwork;

import java.util.UUID;

/**
 * Třída reprezentuje generátor ID klienta
 */
public class IdGenerator {
    private static int pocitadlo = 0;

    /**
     * Metoda generuje unikátní ID - naformátováno - 001...
     *
     * @return ID
     */
    public static String vygenerujId() {
        pocitadlo++;
        String formatPocitadla = String.format("%03d", pocitadlo);
        return formatPocitadla + UUID.randomUUID().toString().substring(3, 3);
    }
}
