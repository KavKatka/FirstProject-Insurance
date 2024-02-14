package cz.itnetwork;

import java.util.Scanner;

public class UzivatelskeRozhrani {

    /**
     * Scanner
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Pojištění
     */
    public Pojisteni pojisteni = new Pojisteni();

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

    /**
     * Metoda pro vypsání Menu k editaci
     */
    public void vypisMenuProEditaci() {
        System.out.println();
        System.out.println("Vyberte akci pro editaci: ");
        System.out.println("A - Editace - Jméno");
        System.out.println("B - Editace - Příjmení");
        System.out.println("C - Editace - Věk");
        System.out.println("D - Editace - Telefonní číslo");
        System.out.println("E - Ukončení editace");
        System.out.println();
    }

    /**
     * Metoda pro výpis - volby a běh programu
     */
    public void vypisMoznostiVolby() {
        String volba = "";
        while (!volba.equals("6")) {
            vypisMenu();
            volba = scanner.nextLine().trim();
            switch (volba) {
                case "1":
                    System.out.println("Vaše volba: 1 - Přidat novou pojištěnou osobu");
                    System.out.println();
                    pojisteni.pridejKlienta();
                    System.out.println();
                    System.out.println("Pokračujte klávesou ENTER...");
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Vaše volba: 2 - Vyhledat všechny pojištěné osoby");
                    System.out.println();
                    pojisteni.vyhledejVsechnyKlienty();
                    System.out.println();
                    System.out.println("Pokračujte klávesou ENTER...");
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("Vaše volba: 3 - Vyhledat pojištěnou osobu");
                    System.out.println();
                    pojisteni.vyhledejKlienta();
                    System.out.println();
                    System.out.println("Pokračujte klávesou ENTER...");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Vaše volba: 4 - Upravit záznam u klienta");
                    System.out.println();
                    String editace = "";
                    while (!editace.equals("E")) {
                        vypisMenuProEditaci();
                        editace = scanner.nextLine().toUpperCase().trim();
                        switch (editace) {
                            case "A":
                                System.out.println("Vaše volba - A - Editace - Jméno");
                                System.out.println();
                                pojisteni.vyhledejKlienta();
                                pojisteni.editujJmeno();
                                System.out.println();
                                break;
                            case "B":
                                System.out.println("Vaše volba - B - Editace - Příjmení");
                                System.out.println();
                                pojisteni.vyhledejKlienta();
                                pojisteni.editujPrijmeni();
                                System.out.println();
                                break;
                            case "C":
                                System.out.println("Vaše volba - C - Editace - Věk");
                                System.out.println();
                                pojisteni.vyhledejKlienta();
                                pojisteni.editujVek();
                                System.out.println();
                                break;
                            case "D":
                                System.out.println("Vaše volba - D - Editace - Telefonní číslo");
                                System.out.println();
                                pojisteni.vyhledejKlienta();
                                pojisteni.editujTelefonniCislo();
                                System.out.println();
                                break;
                            case "E":
                                System.out.println("Vaše volba - E - Ukončení editace");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Neplatná volba, zkuste to znovu.");
                                break;
                        }
                    }
                    System.out.println();
                    System.out.println("Pokračujte klávesou ENTER...");
                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println("Vaše volba: 5 - Smazat pojištěnou osobu");
                    System.out.println();
                    pojisteni.vymazKlienta();
                    System.out.println();
                    System.out.println("Pokračujte klávesou ENTER...");
                    scanner.nextLine();
                    break;
                case "6":
                    System.out.println("Vaše volba: 6 - Konec programu");
                    System.out.println("----------------------------Nashledanou----------------------------");
                    break;
                default:
                    System.out.println("Neplatná volba, prosím opakujte znovu.");
                    break;
            }
        }
    }
}
