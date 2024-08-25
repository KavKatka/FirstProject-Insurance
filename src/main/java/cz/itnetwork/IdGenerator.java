package cz.itnetwork;

/**
 * Třída reprezentuje generátor ID klienta
 */
public class IdGenerator {
    private static int pocitadlo = 1;

    /**
     * Metoda generuje unikátní ID - naformátováno - 001...
     *
     * @return ID
     */
    public static int vygenerujId() {

        return pocitadlo++;
    }
}
