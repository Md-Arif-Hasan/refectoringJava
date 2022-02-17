package workshop;

public class Player {
    String playerName;
    int places;
    int purses;
    boolean inPenaltyBox;

    public Player(String playerName, int places, int purses, boolean inPenaltyBox) {
        this.playerName = playerName;
        this.places = places;
        this.purses = purses;
        this.inPenaltyBox = inPenaltyBox;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}