/*
// * Jose Ramos
// * Student ID: 00299444
// * CIS 252 - T-7847
// * October 27/2019
// * Project 3
// * -----------------------
// * Objectives:
// * This class is part of the "Project 3" assignment. To see the objectives of this lab please read the readme.txt file
// *
// * NOTE: The user can select the amount of voter besides the candidates that are 4 voters as well.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int votersAmount = 0;
        Scanner scanner = new Scanner(System.in);

        VotingMachine test = new VotingMachine();
        System.out.println("Enter the amount of voters besides the 4 candidates");
        votersAmount = scanner.nextInt();
        System.out.println();

        test.setUpVotingMachine(votersAmount);
        test.startVoting();
        test.processAllTheVotes();
    }
}
