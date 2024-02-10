package cz.itnetwork;

import java.util.ArrayList;
import java.util.Objects;


public class Databaze {

    /**
     * Kolekce klientů
     */
    private final ArrayList<Klient> klienti;

    /**
     * Konstruktor
     */
    public Databaze() {
        klienti = new ArrayList<>();
    }

    /**
     * Metoda pro přidání klienta s parametry:
     *
     * @param jmeno          Jméno
     * @param prijmeni       Příjmení
     * @param vek            Věk
     * @param telefonniCislo Telefonní číslo
     */
    public void pridejKlienta(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        ArrayList<Klient> existujici = getKlienti();
        for (Klient klient : existujici){
            if (klient.getTelefonniCislo().equals(telefonniCislo)){
                System.out.println("Klient již existuje.");
                System.out.println(klient);
                return;
            }
        }
        klienti.add(new Klient(jmeno, prijmeni, vek, telefonniCislo));
    }


    /**
     * Getter - vypsání všech klientů
     *
     * @return Nalezení klienti
     */
    public ArrayList<Klient> getKlienti() {
        return klienti;
    }

    /**
     * Metoda pro vyhledání klienta dle jména a příjmení
     *
     * @param jmeno    Jméno
     * @param prijmeni Příjmení
     * @return Nalezený klient/Klienti
     */
    public ArrayList<Klient> vyhledejKlienta(String jmeno, String prijmeni) {
        ArrayList<Klient> nalezen = new ArrayList<>();
        for (Klient klient : klienti) {
            if (klient.getJmeno().equals(jmeno) && klient.getPrijmeni().equals(prijmeni)) {
                nalezen.add(klient);
            }
        }
        return nalezen;
    }

    /**
     * Metoda pro editaci jména
     *
     * @param id        ID klienta
     * @param noveJmeno Zadání nového jména
     * @return Nové jméno
     */
    public boolean editujJmeno(String id, String noveJmeno) {
        Klient klient = najdiPodleId(id);
        if (klient == null) {
            return false;
        }
        klient.setJmeno(noveJmeno);
        return true;
    }

    /**
     * Metoda pro editaci příjmení
     *
     * @param id           ID klienta
     * @param novePrijmeni Zadání nového příjmení
     * @return Nové příjmení
     */
    public boolean editujPrijmeni(String id, String novePrijmeni) {
        Klient klient = najdiPodleId(id);
        if (klient == null) {
            return false;
        }
        klient.setPrijmeni(novePrijmeni);
        return true;
    }

    /**
     * Metoda pro editaci věku
     *
     * @param id  ID klienta
     * @param vek Zadání nového věku
     */
    public boolean editujVek(String id, int vek) {
        Klient klient = najdiPodleId(id);
        if (klient == null) {
            return false;
        }
        klient.setVek(vek);
        return true;
    }

    /**
     * Metoda pro editaci telefonního čísla
     *
     * @param id      ID klienta
     * @param telefon Nové telefonní číslo
     */
    public boolean editujTelefonniCislo(String id, String telefon) {
        Klient klient = najdiPodleId(id);
        if (klient == null) {
            return false;
        }
        klient.setTelefonniCislo(telefon);
        return true;
    }

    /**
     * Metoda pro hledání klienta podle ID
     */
    public Klient najdiPodleId(String id) {
        for (Klient klient : klienti) {
            if (klient.getKlientId().equals(id)) {
                return klient;
            }
        }
        return null;
    }


    /**
     * Metoda pro vymazání klienta - ukončení smlouvy, vypovězení smlouvy
     */
    /*public void vymazKlienta(String jmeno, String prijmeni) {
        ArrayList<Klient> nalezeno = vyhledejKlienta(jmeno, prijmeni);
        for (Klient klient : nalezeno) {
            nalezeno.remove(klient);
        }
    }*/
    public boolean vymazKlienta(String id) {
        for (Klient klient : klienti) {
            if (Objects.equals(id, klient.getKlientId())) {
                klienti.remove(klient);
                return true;
            }
        }
        return false;
    }
}
