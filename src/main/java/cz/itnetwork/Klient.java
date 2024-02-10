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
     * ID klienta
     */
    private final String klientId;

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
        this.klientId = IdGenerator.vygenerujId();
    }

    /**
     * Gettery a Settery
     */
    public String getJmeno() {
        return jmeno.substring(0, 1).toUpperCase() + jmeno.substring(1);
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni.substring(0, 1).toUpperCase() + prijmeni.substring(1);
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    public String getKlientId() {
        return klientId;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-30s %-30s %-3d  %-9s", getKlientId(), getJmeno(), getPrijmeni(), getVek(), getTelefonniCislo());
    }

}
