package jkluu1.washington.edu.quizdroid4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by JenniferLuu on 2/17/15.
 */

public interface TopicRepository {

    public Topic createTopic(String t, String sd, String ld, List<Quiz> aq);

    public Quiz createQuiz(String ques, List<String> ans, int correct);

    public void addTopic(Topic topic);

    public List<Topic> getTopics();
}

