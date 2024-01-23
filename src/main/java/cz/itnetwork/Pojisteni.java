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
     *
     */
    public Pojisteni() {
        databaze = new Databaze();
    }

    /*public void vyhledejVsechnyKlienty() {
        ArrayList<Klient> klienti = databaze.vyhledejKlienta();
        for (Klient klient : klienti) {
            System.out.println(klient);
        }
    }*/

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
