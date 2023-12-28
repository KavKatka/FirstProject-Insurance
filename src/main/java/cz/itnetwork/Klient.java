package cz.itnetwork;

public class Klient {
    /**
     * Jméno klienta
     */
    private String jmeno;
    /**
     * Příjmení klienta
     */
    private String prijmeni;
    /**
     * Telefonní číslo klienta
     */
    private String telefonniCislo;
    /**
     * Věk klienta
     */
    private int vek;

    /**
     * Konstruktor
     *
     * @param jmeno          Jméno
     * @param prijmeni       Příjmení
     * @param vek            Věk
     * @param telefonniCislo Telefonní číslo
     */
    public Klient(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

}
