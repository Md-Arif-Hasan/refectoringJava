package workshop;


import java.util.ArrayList;
import java.util.List;

public class TriviaGame {

    ArrayList <Player>players=new ArrayList<>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    Question question;
    List<QuestionPatternMatcher> patternMatcherList=new ArrayList<>() ;
    public TriviaGame() {
        question.QuestionSetting();
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void  add(String playerName) {
        Player player=new Player(playerName,0,0,false);
        players.add(player);
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    private boolean isOdd(int roll){
        return (roll%2!=0) ;
    }

    private boolean isEven(int roll){
        return (roll%2==0) ;
    }

    public void roll(int roll) {
        Player curPlayer =players.get(currentPlayer);
        announce(curPlayer.getPlayerName() + " is the current player");
        announce("They have rolled a " + roll);

        if (curPlayer.isInPenaltyBox()) {

            if (isOdd(roll)) {
                isGettingOutOfPenaltyBox = true;
                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                locationSetting(roll, curPlayer);
            }

            if(isEven(roll)) {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        }
        else {
            locationSetting(roll, curPlayer);
        }

    }


    private void locationSetting(int roll, Player curPlayer) {
        Question question=new Question();
        curPlayer.setPlaces(curPlayer.getPlaces()+ roll) ;
        if (curPlayer.getPlaces()> 11) curPlayer.setPlaces(curPlayer.getPlaces()-12) ;


        announce(players.get(currentPlayer)
                + "'s new location is "
                + curPlayer.getPlaces());
        announce("The category is " + currentCategory());
        askQuestion();
    }

    //refactor for loop
    public void random() {

        QuestionPatternMatcher  Rock_ScienceQ =new Rock_ScienceQ();

        QuestionPatternMatcher sportsQuestion =new SportsQuestion();


        patternMatcherList.add(popQuestion);

        patternMatcherList.add(Rock_ScienceQ);
        patternMatcherList.add(sportsQuestion);

    }

    public void askQuestion(){
        for (QuestionPatternMatcher questionPatt: patternMatcherList) {
            if(questionPatt.Match(currentCategory())){
                announce(questionPatt);
            }

        }
    }



    //Refactor if-else
    public String currentCategory() {
        Player curPlayer =players.get(currentPlayer);
        if (isPop (curPlayer.getPlaces()) )return "Pop";
        if (isScience(curPlayer.getPlaces() )) return "Science";
        if (isSports(curPlayer.getPlaces())) return "Sports";
        return "Rock";
    }

    boolean isPop(int number) {
        if(number==0 || number==4 ||number==8)return true;
        return  false;
    }

    boolean isScience(int number) {
        if(number==1 || number==5 ||number==9)return true;
        return  false;
    }

    boolean isSports(int number) {
        if(number==2 || number==6 ||number==10)return true;
        return  false;
    }

    public boolean wasCorrectlyAnswered() {
        Player curPlayer =players.get(currentPlayer);
        if (curPlayer.inPenaltyBox) {
            if (isGettingOutOfPenaltyBox) {
                return correctAnswer(curPlayer);
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }
        } else {
            correctAnswer(curPlayer);
        }
        return false;
    }

    private boolean correctAnswer(Player curPlayer) {
        announce("Answer was correct!!!!");
        curPlayer.setPurses(curPlayer.getPurses()+1);
        announce(curPlayer.getPlayerName()
                + " now has "
                + curPlayer.getPurses()
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
    }

    public boolean wrongAnswer() {
        Player curPlayer =players.get(currentPlayer);
        announce("Question was incorrectly answered");
        announce(curPlayer.getPlayerName()  + " was sent to the penalty box");

        curPlayer.setInPenaltyBox(true);

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        Player curPlayer =players.get(currentPlayer);
        return !(curPlayer.getPurses()== 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}