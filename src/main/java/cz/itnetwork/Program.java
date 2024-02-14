package cz.itnetwork;

import java.util.Scanner;

/**
 * Program pro správu klientů pojištění
 */
public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UzivatelskeRozhrani ui = new UzivatelskeRozhrani();

        ui.vypisMoznostiVolby();

    }
}