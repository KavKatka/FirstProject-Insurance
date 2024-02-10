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
        String jmeno;
        do {
            System.out.println("Zadejte jméno: ");
            jmeno = scanner.nextLine().trim();
        } while (jmeno.isEmpty());

        String prijmeni;
        do {
            System.out.println("Zadejte příjmení: ");
            prijmeni = scanner.nextLine().trim();
        } while (prijmeni.isEmpty());

        System.out.println("Zadejte věk:");
        int vek = 0;
        boolean chyba;
        do {
            try {                   // try-catch blok - pro zachycení vyjímky - uzivatel zadá třeba písmena
                vek = Integer.parseInt(scanner.nextLine().trim());
                chyba = false;
            } catch (Exception e) {
                System.out.println("Nesprávná hodnota. Zkuste to znovu.");
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

        if (databaze.pridejKlienta(jmeno, prijmeni, vek, telefonniCislo)) {
            System.out.println("Klient byl přidán.");
        } else {
            System.out.println("Klient již existuje");
        }
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
            System.out.println(" ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
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
            System.out.println(" ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Klient klient : nalezeno) {
                System.out.println(klient);
            }
        } else {
            System.out.println("Nebyly nalezeny žádné záznamy.");
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
        ArrayList<Klient> nalezeno = databaze.vyhledejKlienta(jmenoKeSmazani, prijmeniKeSmazani);
        System.out.println();
        System.out.println("Nalezeny tyto záznamy: ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ID    Jméno                          Příjmení                      Věk   Telefonní číslo");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(nalezeno);
        System.out.println();
        System.out.println("Vyberte ID ke smazání: ");
        String vybraneID = scanner.nextLine().trim();
        databaze.najdiPodleId(vybraneID);

        if (databaze.vymazKlienta(vybraneID)) {
            System.out.println("Klient byl vymazán z databáze.");
        } else {
            System.out.println("Chyba");
        }
        System.out.println();
    }

    /**
     * Metody pro editaci
     */
    public void editujJmeno() {
        System.out.println();
        System.out.println("Zadejte ID klienta k editaci jména: ");
        String zadaneId = scanner.nextLine().trim();
        System.out.println("Zadejte nové jméno: ");
        String noveJmeno = scanner.nextLine().trim();
        if (databaze.editujJmeno(zadaneId, noveJmeno)) {
            System.out.println("Změna byla provedena.");
        } else {
            System.out.println("Chyba.");
        }

    }

    public void editujPrijmeni() {
        System.out.println();
        System.out.println("Zadejte ID klienta k editaci příjmení: ");
        String zadaneId = scanner.nextLine().trim();
        System.out.println("Zadejte nové příjmení: ");
        String novePrijmeni = scanner.nextLine().trim();
        if (databaze.editujPrijmeni(zadaneId, novePrijmeni)) {
            System.out.println("Změna byla provedena.");
        } else {
            System.out.println("Chyba");
        }

    }

    public void editujVek() {
        System.out.println();
        System.out.println("Zadejte ID klienta k editaci věku: ");
        String zadaneId = scanner.nextLine().trim();
        System.out.println("Zadejte nový věk: ");
        int vek;
        boolean chyba;
        do {
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
                databaze.editujVek(zadaneId, vek);
                chyba = false;
            } catch (Exception e) {
                System.out.println("Nesprávná hodnota, zkuste to znovu.");
                chyba = true;
            }
        } while (chyba);
    }

    public void editujTelefonniCislo() {
        System.out.println();
        System.out.println("Zadejte ID klienta k editaci telefonního čísla: ");
        String zadaneId = scanner.nextLine().trim();
        System.out.println("Zadejte nové telefonní číslo: ");
        String noveTelefonniCislo = scanner.nextLine().trim();
        if (databaze.editujTelefonniCislo(zadaneId, noveTelefonniCislo)) {
            System.out.println("Změna byla provedena.");
        } else {
            System.out.println("Chyba");
        }
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
