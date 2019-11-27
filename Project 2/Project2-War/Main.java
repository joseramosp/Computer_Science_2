/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * October 10/2019
 * Project 2
 * -----------------------
 * Objectives:
 * This class is part of the "Project 2" assignment. To see the objectives of this lab please read the readme.txt file
 * This is the main class where the program runs the game.
 *
 * NOTE: The only input that the user has to provide is the name of the Two players.
 *
 */

public class Main {
    public static void main(String[] args) {
        WarManager warManager = new WarManager();

        warManager.play(); // the methods deal() and setUp are called inside of this method.
    }
}
