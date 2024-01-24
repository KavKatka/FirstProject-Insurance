package cz.itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Pojisteni {
    /**
     * Kolekce
     */
    private Databaze databaze;
    /**
     * Scanner - vstup od uživatele
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor
     */
    public Pojisteni() {
        databaze = new Databaze();
    }

    /**
     * Metoda pro přidání klienta a příslušné kroky v programu
     */
    public void pridejKlienta() {
        System.out.println("Zadejte jméno: ");
        String jmeno = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();
        System.out.println("Zadejte věk:");
        int vek = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Zadejte telefonní číslo:  (Ve formátu: XXXXXXXXX)");
        String telefonniCislo = scanner.nextLine().trim();
        databaze.pridejKlienta(jmeno, prijmeni, vek, telefonniCislo);
        System.out.println();
    }

    /**
     * Metoda pro vyhledání jednotlivého klienta
     */
    public void vyhledejKlienta() {
        System.out.println("Zadejte jméno: ");
        String hledaneJmeno = scanner.nextLine().trim();
        System.out.println("Zadejte příjmeni: ");
        String hledanePrijmeni = scanner.nextLine().trim();
        System.out.println();
        ArrayList<Klient> klienti = databaze.vyhledejKlienta(hledaneJmeno, hledanePrijmeni);
        if (!klienti.isEmpty()) {
            System.out.println("Nalezeny tyto záznamy: ");
            for (Klient klient : klienti) {
                System.out.println(klient);
            }
        }
    }

    /**
     * Metoda pro vyhledání všech uložených klientů v databázi
     */
    public void vyhledejVsechnyKlienty() {
        ArrayList<Klient> klienti = databaze.najdiKlienta();
        if (!klienti.isEmpty()) {
            System.out.println("Nalezeny tyto záznamy: ");
            for (Klient klient : klienti) {
                System.out.println(klient);
            }
        }
        System.out.println();
    }

    /**
     * Metoda pro vymazání klienta
     */
    public void vymazKlienta() {
        System.out.println("Zadejte jméno:");
        String jmenoKeSmazani = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení:");
        String prijmeniKeSmazani = scanner.nextLine().trim();
        String nalezeno = String.valueOf(databaze.vyhledejKlienta(jmenoKeSmazani, prijmeniKeSmazani));
        if (!nalezeno.isEmpty()) {
            System.out.println("Opravdu chcete vymazat tohoto klienta? [ANO / NE]\n" + nalezeno);
            String opravdu = "";
            opravdu = scanner.nextLine().toLowerCase().trim();
            if (opravdu.equals("ano")) {
                databaze.vymazKlienta(jmenoKeSmazani, prijmeniKeSmazani);
                System.out.println("Klient byl vymazán z databáze.");
            }
        }
        System.out.println();
    }

    /**
     * Metoda pro vypsání hlavního menu
     */
    public void vypisMenu() {
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("     Evidence pojištěných osob");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Vyberte si akci: ");
        System.out.println(" 1 - Přidat novou pojištěnou osobu");
        System.out.println(" 2 - Vypsat všechny pojištěné osoby");
        System.out.println(" 3 - Vyhledat pojištěnou osobu");
        System.out.println(" 4 - Smazat pojištěnou osobu");
        System.out.println(" 5 - Konec programu");
        System.out.println();
    }


}
