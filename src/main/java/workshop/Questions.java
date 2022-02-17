package workshop;

import java.util.LinkedList;

public class Question {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Question(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions) {
        this.popQuestions = popQuestions;
        this.scienceQuestions = scienceQuestions;
        this.sportsQuestions = sportsQuestions;
        this.rockQuestions = rockQuestions;
    }

    public Question(){
        QuestionSetting();
    };



    public LinkedList getPopQuestions() {
        return popQuestions;
    }

    public void setPopQuestions(LinkedList popQuestions) {
        this.popQuestions = popQuestions;
    }

    public LinkedList getScienceQuestions() {
        return scienceQuestions;
    }

    public void setScienceQuestions(LinkedList scienceQuestions) {
        this.scienceQuestions = scienceQuestions;
    }

    public LinkedList getSportsQuestions() {
        return sportsQuestions;
    }

    public void setSportsQuestions(LinkedList sportsQuestions) {
        this.sportsQuestions = sportsQuestions;
    }

    public LinkedList getRockQuestions() {
        return rockQuestions;
    }

    public void setRockQuestions(LinkedList rockQuestions) {
        this.rockQuestions = rockQuestions;
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }
    public String sportsQuestions(int index) {
        return "Sports Question " + index;
    }
    public String scienceQuestions(int index) {
        return "Science Question " + index;
    }
    public String popQuestions(int index) { return "Pop Question " + index;}

    public void QuestionSetting() {

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(popQuestions(i));
            scienceQuestions.addLast(scienceQuestions(i));
            sportsQuestions.addLast(sportsQuestions(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }





}