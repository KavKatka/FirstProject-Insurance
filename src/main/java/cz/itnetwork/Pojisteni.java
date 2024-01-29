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
     * Getter
     *
     * @return databáze
     */
    public Databaze getDatabaze() {
        return databaze;
    }


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
        String jmeno = scanner.nextLine().trim().toUpperCase();

        System.out.println("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim().toUpperCase();

        System.out.println("Zadejte věk:");
        int vek = 0;
        boolean chyba;
        do {
            try {                                                    // try-catch blok - pro zachycení vyjímky - uzivatel zadá třeba písmena
                vek = Integer.parseInt(scanner.nextLine().trim());
                chyba = false;
            } catch (Exception e) {
                System.out.println("Nesprávná hodnota.");
                chyba = true;
            }
        } while (chyba);

        System.out.println("Zadejte telefonní číslo:  (Ve formátu: XXXXXXXXX)");
        String telefonniCislo = scanner.nextLine().trim();
        int maxZnaku = 9;
        while (telefonniCislo.length() < maxZnaku || telefonniCislo.length() > maxZnaku) {
            System.out.println("Neplatný formát, zkuste prosím zadat znovu telefonní číslo (9 číslic).");
            telefonniCislo = scanner.nextLine().trim();
        }
        databaze.pridejKlienta(jmeno, prijmeni, vek, telefonniCislo);
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
        ArrayList<Klient> vyhledany = databaze.vyhledejKlienta(hledaneJmeno, hledanePrijmeni);
        if (!vyhledany.isEmpty()) {
            System.out.println("Nalezeny tyto záznamy: ");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Klient klient : vyhledany) {
                System.out.println(klient);
            }
        } else {
            System.out.println("Klient nenalezen.");
        }
    }

    /**
     * Metoda pro vyhledání všech uložených klientů v databázi
     */
    public void vyhledejVsechnyKlienty() {
        ArrayList<Klient> nalezeno = databaze.getKlienti();
        if (!nalezeno.isEmpty()) {

            System.out.println("Nalezeny tyto záznamy: ");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Klient klient : nalezeno) {
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
        System.out.println();

        if (!nalezeno.isEmpty()) {
            if (nalezeno.length() > 1) {
                System.out.println("Nalezeny tyto záznamy: ");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println(nalezeno);
                System.out.println();
                System.out.println("Vyberte, který záznam, podle ID, chcete smazat:");
                String vybraneID = scanner.nextLine();


            }
            System.out.println("Opravdu chcete vymazat tohoto klienta? [ANO / NE]\n" + nalezeno);
            String opravdu = "";
            opravdu = scanner.nextLine().toLowerCase().trim();
            if (opravdu.equals("ano")) {
                databaze.vymazKlienta(jmenoKeSmazani, prijmeniKeSmazani);
                System.out.println("Klient byl vymazán z databáze.");
            } else {
                System.out.println("Klient byl ponechán v databázi.");
            }
        }
        System.out.println();
    }

    /**
     * Metody pro editaci
     *
     * @param jmeno    Jméno
     * @param prijmeni Příjmení
     */
    public void editujJmeno(String jmeno, String prijmeni) {
        ArrayList<Klient> nalezen = databaze.vyhledejKlienta(jmeno, prijmeni);
        System.out.println("Zadejte nové jméno: ");
        String noveJmeno = scanner.nextLine().trim();
        for (Klient klient : nalezen) {
            klient.setJmeno(noveJmeno);
        }
    }

    public void editujPrijmeni(String jmeno, String prijmeni) {

    }

    public void editujVek() {

    }

    public void editujTelefonniCislo() {

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
        System.out.println("Vyberte akci: ");
        System.out.println(" 1 - Přidat novou pojištěnou osobu");
        System.out.println(" 2 - Vyhledat všechny pojištěné osoby");
        System.out.println(" 3 - Vyhledat pojištěnou osobu");
        System.out.println(" 4 - Upravit záznam u klienta");
        System.out.println(" 5 - Smazat pojištěnou osobu");
        System.out.println(" 6 - Konec programu");
        System.out.println();
    }

    public void vypisMenuProEditaci() {
        System.out.println();
        System.out.println("Vyberte akci pro editaci: ");
        System.out.println("A - Editace - Jméno");
        System.out.println("B - Editace - Příjmení");
        System.out.println("C - Editace - Věk");
        System.out.println("D - Editace - Telefonní číslo");
        System.out.println();
    }

}
