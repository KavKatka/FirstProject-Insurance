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

    /**
     * Gettery a Settery
     */
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
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

    @Override
    public String toString(){
        return String.format("%s %s  %d  %s",getJmeno(), getPrijmeni(), getVek(), getTelefonniCislo());
    }
}
