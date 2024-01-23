package cz.itnetwork;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Klient klient = new Klient("Josef", "Pospíšil", 45, "602123456");
        Klient klient1 = new Klient("Karel", "Zaskočil", 55, "603987543");
        Klient klient2 = new Klient("Jaroslava", "Matoucí", 34, "777987543");
        Klient klient3 = new Klient("Miroslava", "Konečná", 59, "723879342");

        Scanner scanner = new Scanner(System.in);
        Databaze databaze = new Databaze();
        Pojisteni pojisteni = new Pojisteni();

        //Try - catch blok?

        // Pokračuj libovolnou klávesou - nějaký příkaz?


        String volba = "";
        while (!volba.equals("5")) {
            pojisteni.vypisMenu();
            volba = scanner.nextLine();
            switch (volba) {
                case "1":
                    System.out.println("Vaše volba: 1 - Přidat novou pojištěnou osobu");
                    System.out.println("Zadejte jméno:");
                    String jmeno = scanner.nextLine();
                    System.out.println("Zadejte příjmení:");
                    String prijmeni = scanner.nextLine();
                    System.out.println("Zadejte věk:");
                    int vek = Integer.parseInt(scanner.nextLine());
                    System.out.println("Zadejte telefonní číslo:");
                    String telefonniCislo = scanner.nextLine();
                    databaze.pridejKlienta(jmeno, prijmeni, vek, telefonniCislo);
                    System.out.println("Nový klient byl uložen do systému. Pokračujte libovolnou klávesou...");
                    break;
                case "2":
                    System.out.println("Vaše volba: 2 - Vypsat všechny pojištěné osoby");

                case "3":
                    System.out.println("Vaše volba: 3 - Vyhledat pojištěnou osobu");
                    System.out.println("Zadejte jméno");
                    String hledaneJmeno = scanner.nextLine();
                    System.out.println("Zadejte příjmeni:");
                    String hledanePrijmeni = scanner.nextLine();
                    databaze.vyhledejKlienta(hledaneJmeno, hledanePrijmeni);
                    break;
                case "4":
                    System.out.println("Vaše volba: 4 - Smazat pojištěnou osobu");
                    System.out.println("Zadejte jméno:");
                    String jmenoKeSmazani = scanner.nextLine();
                    System.out.println("Zadejte příjmení:");
                    String prijmeniKeSmazani = scanner.nextLine();
                    databaze.vymazKlienta(jmenoKeSmazani, prijmeniKeSmazani);
//Opravdu si přejete vymazat tohoto klienta z databáze - ANO/NE
                    System.out.println("Klient byl vymazán z databáze. Pokračujte libovolnou klávesou...");
                    break;
                case "5":
                    System.out.println("Vaše volba: 5 - Konec programu");
                    break;
                default:
                    System.out.println("Neplatná volba, prosím opakujte znovu.");
                    break;
            }

        }


    }
}