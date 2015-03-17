package jkluu1.washington.edu.quizdroid4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JenniferLuu on 2/17/15.
 */
public class Topic implements Serializable {
    private String title;
    private String shortDescription;
    private String longDescription;
    private List<Quiz> allQuestions;

    public Topic() {
        title = "";
        shortDescription = "";
        longDescription = "";
        allQuestions = new ArrayList<Quiz>();
    }

    public Topic(String t, String sd, String ld, List<Quiz> aq) {
        title = t;
        shortDescription = sd;
        longDescription = ld;
        allQuestions = aq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String sd) {
        shortDescription = sd;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String ld) {
        longDescription = ld;
    }

    public List<Quiz> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(List<Quiz> aq) {
        allQuestions = aq;
    }
}
