/*
// * Jose Ramos
// * Student ID: 00299444
// * CIS 252 - T-7847
// * October 27/2019
// * Project 3
// * -----------------------
// * Objectives:
// * This class is part of the "Project 3" assignment. To see the objectives of this lab please read the readme.txt file.
// *
// * NOTE: If a candidate got more than the 50 percent of the votes, that candidate win automatically.
*/

import java.util.Scanner;

public class VotingMachine {

    private LinkedList<Voter> voters = new LinkedList<>(); // This will s
    private LinkedList<Candidate> candidates = new LinkedList<>(); // This will store all the candidates
    private LinkedList<Candidate> nonWiningCandidates = new LinkedList<>(); // This will store the candidates that did not win in order from 2nd place to the last
    private Candidate winner;
    private Candidate mostVotedCandidate;
    private Candidate leastVotedCandidate;
    private Scanner scanner = new Scanner(System.in);

    // This method will set up the voting machine.
    public void setUpVotingMachine(int votersSize){

        candidates.append(new Candidate("Spongebob Squarepants", "Krusty Krab","Making Bikini Bottom a safer city where everyone can make as much bubbles as they want."));
        candidates.append(new Candidate("Kanye West", "The Chosen Few Party", "This party supports your dreams."));
        candidates.append(new Candidate("The Rock Dwayne Johnson","WWE Party","This party supports WWE careers."));
        candidates.append(new Candidate("Will Smith","The fresh future of America","A party of Men in Black that fights for a better world where every can pursuit their happiness and became a legend."));

        for(int i = 0; i<votersSize; i++){
            voters.insert(new Voter(candidates));
        }
        for(int i = 0; i<candidates.length(); i++){
            candidates.moveToPos(i);
            candidates.getValue().setVoterOptions(candidates);
            candidates.moveToPos(i);
            voters.append(candidates.getValue());
        }
        candidates.moveToStart();
    }

    // This is the class that will start taking the vote form each voter
    public void startVoting(){

        for(int i= 0; i<voters.length(); i++){

            System.out.println("Enter your vote in the order of most favorite to least favorite candidate: ");
            System.out.println("Example: 3 (Hit enter), 4 (Hit enter), 2 (Hit enter), 1 (Hit enter).");
            System.out.println("OR \"3 4 2 1\" and then(Hit enter).\n");

            int voterNumber = 1;
            while(!candidates.isAtEnd()){
                System.out.println("Press " + voterNumber++ + " to vote for: " + candidates.getValue().getName());
                candidates.next();
            }
            candidates.moveToStart();
            System.out.println("Press 0 to see candidates information.");

            for(int n=0; n<candidates.length(); n++){

                int voterChoice = scanner.nextInt();

                if( voterChoice == 0){
                    printCandidateInformation();
                    voterChoice = scanner.nextInt();
                }

                while(voterChoice < 1 || voterChoice > candidates.length()){
                    System.out.println("Enter an integer between 1 and "+ candidates.length());
                    voterChoice = scanner.nextInt();
                    if( voterChoice == 0){
                        printCandidateInformation();
                    }
                }

                voters.getValue().voterOptions.moveToPos(voterChoice - 1); // Setting the boolean of a selected option to true.

                while(voters.getValue().voterOptions.getValue().isChooseByVoter()){
                    System.out.println("This candidate was selected already choose another");

                    // Getting a input and verifying the input.
                    voterChoice = scanner.nextInt();
                    while(voterChoice < 1 || voterChoice > candidates.length()){
                        System.out.println("Enter an integer between 1 and "+ candidates.length());
                        voterChoice = scanner.nextInt();
                        if( voterChoice == 0){
                            printCandidateInformation();
                        }
                    }

                    voters.getValue().voterOptions.moveToPos(voterChoice - 1);
                }
                voters.getValue().rankedVotes.append(voters.getValue().voterOptions.getValue());
                voters.getValue().voterOptions.getValue().setChooseByVoter(true);
            }
            voters.getValue().voterOptions.moveToStart();
            voters.next();
        }
        voters.moveToStart();
    }

    // This will start counting all the votes and if one of the candidates got more than 50% follow an algorithm that is not RCV.
    // If none of the candidates got more than 50% of the votes, then the RCV algorithm will be used.
    public void processAllTheVotes(){

        startCountingVotes();
        mostVotedCandidate = getMostVotedCandidate();
        leastVotedCandidate = getLeastVotedCandidate();

        if(mostVotedCandidate.getVotes() > voters.length()/2){
            winner = mostVotedCandidate;
            noRCVNeeded();
            printResults();
        }
        else{
            resetAllVotes();
            winner = startRankedChoiceVoting();
            printResults();
        }

    }

    // This is the algorithm that is going to run if one of the candidates got more than 50% of the votes and RCV is not needed.
    private void noRCVNeeded(){

        System.out.println(candidates.length() + " candidates and " + voters.length() + " votes.\n");
        System.out.println("Number of votes per candidates:");
        mostVotedCandidate = getMostVotedCandidate();
        leastVotedCandidate = getLeastVotedCandidate();
        for(int i = 0; i<candidates.length(); i++) {
            System.out.println(candidates.getValue().getName() + ": " + candidates.getValue().getVotes());
            if (candidates.getValue().getName().equals(leastVotedCandidate.getName())) {
                nonWiningCandidates.insert(candidates.remove());

                if (!candidates.isAtEnd()) {
                    System.out.println(candidates.getValue().getName() + ": " + candidates.getValue().getVotes());
                } else {
                    candidates.prev();
                }

                for (int n = 0; n < voters.length(); n++) {
                    if (voters.getValue().rankedVotes.getValue().getName().equals(nonWiningCandidates.getValue().getName())) {
                        voters.getValue().rankedVotes.remove();
                        break;
                    }
                    voters.next();
                }
                voters.moveToStart();
            }
            candidates.next();
        }
        candidates.moveToStart();
        while(candidates.length()>1){
            leastVotedCandidate = getLeastVotedCandidate();
            for(int i = 0; i<candidates.length(); i++) {
                if (candidates.getValue().getName().equals(leastVotedCandidate.getName())) {
                    nonWiningCandidates.insert(candidates.remove());
                }
                candidates.next();
            }
            candidates.moveToStart();
        }
    }

    public void printResults(){
        System.out.println("**********************************************************************");
        System.out.println("The winner of the elections is " + winner.getName()+"! with a total of " + winner.getVotes() + " ranked votes \n");
        System.out.println("2nd place: " + nonWiningCandidates.getValue().getName() + " with a total of " + nonWiningCandidates.getValue().getVotes() + " ranked votes \n");
        nonWiningCandidates.next();
        System.out.println("3rd place: " + nonWiningCandidates.getValue().getName() + " with a total of " + nonWiningCandidates.getValue().getVotes() + " ranked votes \n");
        nonWiningCandidates.next();
        System.out.println("4th place: " + nonWiningCandidates.getValue().getName() + " with a total of " + nonWiningCandidates.getValue().getVotes() + " ranked votes \n");

    }

    private void printCandidateInformation(){
        int voterNumber = 1;
        while(!candidates.isAtEnd()){
            System.out.println("Candidate #" +voterNumber+++": " + candidates.getValue().getName());
            System.out.println("Party: " + candidates.getValue().getParty());
            System.out.println("Platform: " + candidates.getValue().getPlatform());
            System.out.println();
            candidates.next();
        }
        candidates.moveToStart();
    }

    private void removeNonValidVotes(){
        voters.moveToStart();
        nonWiningCandidates.moveToStart();
        if(nonWiningCandidates.length() > 0){
            for(int i = 0; i< nonWiningCandidates.length(); i++){
                for(int n = 0; n< voters.length(); n++){
                    if(voters.getValue().rankedVotes.getValue().getName().equals(nonWiningCandidates.getValue().getName())){
                        voters.getValue().rankedVotes.remove();

                        if(voters.isAtEnd()) {
                            candidates.prev();
                        }
                    }
                    voters.next();
                }
                voters.moveToStart();
                nonWiningCandidates.next();
            }
            nonWiningCandidates.moveToStart();
            voters.moveToStart();
        }
    }

    private void startCountingVotes(){

        removeNonValidVotes();
        candidates.moveToStart();
        voters.moveToStart();
        for(int i = 0; i< candidates.length(); i++) {
            for(int n = 0; n< voters.length(); n++) {
                if (voters.getValue().rankedVotes.getValue().getName().equals(candidates.getValue().getName())) {
                    candidates.getValue().increaseVotes();
                }
                voters.next();
            }
            voters.moveToStart();
            candidates.next();
        }
        candidates.moveToStart();
    }

    private Candidate getMostVotedCandidate(){
        Candidate getMostVotedCandidate = candidates.getValue();

        while(!candidates.isAtEnd()){
            if(getMostVotedCandidate.getVotes() < candidates.getValue().getVotes()) {
                getMostVotedCandidate = candidates.getValue();
            }
            candidates.next();
        }
        candidates.moveToStart();
        return getMostVotedCandidate;
    }

    // This method will return the candidate that had less votes than the others candidates
    private Candidate getLeastVotedCandidate(){

        Candidate leastPopularCandidate = candidates.getValue();

        while(!candidates.isAtEnd()){
            if(leastPopularCandidate.getVotes() > candidates.getValue().getVotes()) {
                leastPopularCandidate = candidates.getValue();
            }
            candidates.next();
        }
        candidates.moveToStart();
        return leastPopularCandidate;
    }

    // This is the class that will start the RCV if none of the candidates got more than the 50% of the votes
    private Candidate startRankedChoiceVoting(){

        if(candidates.length() == 1){
            return candidates.getValue();
        }
        else{
            System.out.println("Round #" + (candidates.length() + nonWiningCandidates.length() + 1 - candidates.length())+"\n");

            startCountingVotes();
            System.out.println(candidates.length() + " candidates and " + voters.length() + " ranked votes.\n");
            System.out.println("Number of votes per candidates:");
            mostVotedCandidate = getMostVotedCandidate();
            leastVotedCandidate = getLeastVotedCandidate();
            for(int i = 0; i<candidates.length(); i++){
                System.out.println(candidates.getValue().getName() + ": " + candidates.getValue().getVotes());
                if (candidates.getValue().getName().equals(leastVotedCandidate.getName())){
                    nonWiningCandidates.insert(candidates.remove());

                    if(!candidates.isAtEnd()){
                        System.out.println(candidates.getValue().getName() + ": " + candidates.getValue().getVotes());
                    }
                    else {
                        candidates.prev();
                    }
                }
                candidates.next();
            }
            System.out.println(mostVotedCandidate.getName() + " has the highest number of votes with " + mostVotedCandidate.getVotes());
            System.out.println(leastVotedCandidate.getName() + " has the lowest number of votes with " + leastVotedCandidate.getVotes());
            System.out.println("\n**********************************************************************");
            candidates.moveToStart();
            if(candidates.length() > 1){resetAllVotes();}
            return startRankedChoiceVoting();
        }
    }

    // This method will set all the votes for all candidates in the candidates LL
    private void resetAllVotes(){
        while (!candidates.isAtEnd()){
            candidates.getValue().setVotes(0);
            candidates.next();
        }
        candidates.moveToStart();
    }
}
