package cz.itnetwork;

import java.util.ArrayList;

public class Databaze {

    /**
     * Kolekce klientů
     */
    private ArrayList<Klient> klienti;

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
        klienti.add(new Klient(jmeno, prijmeni, vek, telefonniCislo));
    }

    /**
     * Metoda pro vyhledání klienta dle jména a příjmení
     *
     * @param jmeno    Jméno
     * @param prijmeni Příjmení
     * @return Nalezený klient/Klienti
     */
    public ArrayList<Klient> vyhledejKlienta(String jmeno, String prijmeni) {
        ArrayList<Klient> nalezen = new ArrayList<>(klienti);
        return nalezen;
    }

    /**
     * Metoda pro vyhledání klienta bez parametrů
     *
     * @return Nalezení klienti
     */
    public ArrayList<Klient> najdiKlienta() {
        ArrayList<Klient> nalezen = new ArrayList<>();
        for (Klient klient : klienti) {
            if (!klienti.isEmpty()) {
                System.out.println(klient);
            } else {
                System.out.println("Klient nenalezen.");
            }
        }
        return nalezen;
    }

    /**
     * Metoda pro vymazání klienta - ukončení smlouvy, vypovězení smlouvy
     *
     * @param jmeno    Jméno
     * @param prijmeni Příjmení
     */
    public void vymazKlienta(String jmeno, String prijmeni) {
        ArrayList<Klient> nalezeno = vyhledejKlienta(jmeno, prijmeni);
        for (Klient klient : klienti) {
            nalezeno.remove(klient);
        }
    }
}
