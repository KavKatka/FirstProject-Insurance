package cz.itnetwork;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pojisteni pojisteni = new Pojisteni();

        Klient klient = new Klient("Josef", "Pospíšil", 45, "602123456");
        Klient klient1 = new Klient("Karel", "Zaskočil", 55, "603987543");
        Klient klient2 = new Klient("Jaroslava", "Matoucí", 34, "777987543");
        Klient klient3 = new Klient("Miroslava", "Konečná", 59, "723879342");

        pojisteni.getDatabaze().pridejKlienta(klient.getJmeno(), klient.getPrijmeni(), klient.getVek(), klient.getTelefonniCislo());
        pojisteni.getDatabaze().pridejKlienta(klient1.getJmeno(), klient1.getPrijmeni(), klient1.getVek(), klient1.getTelefonniCislo());
        pojisteni.getDatabaze().pridejKlienta(klient2.getJmeno(), klient2.getPrijmeni(), klient2.getVek(), klient2.getTelefonniCislo());
        pojisteni.getDatabaze().pridejKlienta(klient3.getJmeno(), klient3.getPrijmeni(), klient3.getVek(), klient3.getTelefonniCislo());


        String volba = "";
        while (!volba.equals("6")) {
            pojisteni.vypisMenu();
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
                    pojisteni.vypisMenuProEditaci();
                    String editace = "";
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
                        default:
                            System.out.println("Neplatná volba, zkuste to znovu.");
                            break;
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
                    System.out.println("----------------------------Nashledanou.----------------------------");
                    break;
                default:
                    System.out.println("Neplatná volba, prosím opakujte znovu.");
                    break;
            }

        }


    }
}