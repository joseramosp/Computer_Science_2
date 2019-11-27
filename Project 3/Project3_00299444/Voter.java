public class Voter {

    // This list will store all the candidates in ranked order
    public LinkedList<Candidate> rankedVotes = new LinkedList<>();
    // This list will store all the posible options for the voter
    public LinkedList<Candidate> voterOptions = new LinkedList<>();

    public Voter(LinkedList<Candidate> candidates){
        setVoterOptions(candidates);
    }

    // This method will set all the possible candidates for the voter
    public void setVoterOptions(LinkedList<Candidate> candidates){
        candidates.moveToStart();
        while(!candidates.isAtEnd()){
            Candidate inCandidate = candidates.getValue().clone();
            voterOptions.append(inCandidate);
            candidates.next();
        }
        candidates.moveToStart();
    }

    public Voter() {

    }

}
