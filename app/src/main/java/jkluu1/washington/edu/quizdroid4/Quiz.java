package jkluu1.washington.edu.quizdroid4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JenniferLuu on 2/17/15.
 */
public class Quiz implements Serializable {
    private String questionText;
    private List<String> answers;
    private int correctAnswer;

    public Quiz() {
        questionText = "";
        answers = new ArrayList<String>();
        correctAnswer = -1;
    }

    public Quiz(String ques, List<String> ans, int correct) {
        questionText = ques;
        answers = ans;
        correctAnswer = correct;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String s) {
        questionText = s;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> l) {
        answers = l;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int i) {
        correctAnswer = i;
    }

}

