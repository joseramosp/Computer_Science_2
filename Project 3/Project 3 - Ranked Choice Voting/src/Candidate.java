
public class Candidate extends Voter {

    private String name;                    // Name of the candidate
    private String party;                   // Party of the candidate
    private String platform;                // Platform of the candidate
    private boolean chooseByVoter = false;  // Is true when this candidate has been choose for by voter already
    private int votes = 0;                  // Amount of votes that a candidate has

    public Candidate(){
    }
    public Candidate(String name, String party, String platform){
        this.name = name;
        this.party = party;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void increaseVotes(){
        votes++;
    }

    public boolean isChooseByVoter() {
        return chooseByVoter;
    }

    public void setChooseByVoter(boolean chooseByVoter) {
        this.chooseByVoter = chooseByVoter;
    }
    public Candidate clone(){
        Candidate inCandidate = new Candidate(this.name,this.party,this.platform);
        return inCandidate;
    }
}
