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

        databaze.pridejKlienta(klient.getJmeno(), klient.getPrijmeni(), klient.getVek(), klient.getTelefonniCislo());
        databaze.pridejKlienta(klient1.getJmeno(), klient1.getPrijmeni(), klient1.getVek(), klient1.getTelefonniCislo());
        databaze.pridejKlienta(klient2.getJmeno(), klient2.getPrijmeni(), klient2.getVek(), klient2.getTelefonniCislo());
        databaze.pridejKlienta(klient3.getJmeno(), klient3.getPrijmeni(), klient3.getVek(), klient3.getTelefonniCislo());

        //Try - catch blok?

        // Pokračuj libovolnou klávesou - nějaký příkaz?


        String volba = "";
        while (!volba.equals("5")) {
            pojisteni.vypisMenu();
            volba = scanner.nextLine();
            switch (volba) {
                case "1":
                    System.out.println("Vaše volba: 1 - Přidat novou pojištěnou osobu");
                    System.out.println();
                    pojisteni.pridejKlienta();
                    System.out.println("Nový klient byl uložen do systému. Pokračujte libovolnou klávesou...");
                    break;
                case "2":
                    System.out.println("Vaše volba: 2 - Vypsat všechny pojištěné osoby");
                    System.out.println();
                    pojisteni.vyhledejVsechnyKlienty();
                    System.out.println("Pokračujte libovolnou klávesou...");
                    break;
                case "3":
                    System.out.println("Vaše volba: 3 - Vyhledat pojištěnou osobu");
                    System.out.println();
                    pojisteni.vyhledejKlienta();
                    System.out.println("Pokračujte libovolnou klávesou...");
                    break;
                case "4":
                    System.out.println("Vaše volba: 4 - Smazat pojištěnou osobu");
                    System.out.println();
                    pojisteni.vymazKlienta();
                    System.out.println();
                    System.out.println("Pokračujte libovolnou klávesou...");
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