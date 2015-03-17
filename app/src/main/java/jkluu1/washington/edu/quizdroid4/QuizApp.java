package jkluu1.washington.edu.quizdroid4;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JenniferLuu on 2/21/15.
 */
public class QuizApp extends Application implements TopicRepository{
    private static QuizApp instance;
    private List<Topic> topics;

    public QuizApp() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("You cannot instantiate more than one MyApp");
        }
    }

    public QuizApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("quizdroid3", "QuizApp loaded!");

        generate();
    }

    // Reads from text file
    public void generate() {
        String line = "";
        String question = "";
        int correctAnswer;

        String title = "";
        String shortDescription = "";
        String longDescription = "";


        topics = new ArrayList<Topic>();

        BufferedReader bufferedReader = null;

        try {
            AssetManager am = this.getAssets();
            InputStream inputStream = am.open("questions.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();

            while (line != null) {
                // Log.d("test", line);
                List<Quiz> allQuestions = new ArrayList<Quiz>();

                // While there are still questions, add them
                while (!line.equals("::")) {

                    List<String> qAnswers = new ArrayList<String>();
                    question = line;    // SET QUESTION TEXT

                    for (int i = 0; i < 4; i++) {   // ADD ALL ANSWERS (assumes 4)
                        qAnswers.add(bufferedReader.readLine());
                    }

                    correctAnswer = Integer.parseInt(bufferedReader.readLine());  // SET CORRECT ANSWER
                    Quiz q = createQuiz(question, qAnswers, correctAnswer);
                    allQuestions.add(q);
                    line = bufferedReader.readLine();
                }

                title = bufferedReader.readLine();       // SET TITLE
                shortDescription = bufferedReader.readLine();    // SET SHORT DESCRIPTION
                longDescription = bufferedReader.readLine();     // SET LONG DESCRIPTION

                Topic t = createTopic (title, shortDescription, longDescription, allQuestions);
                topics.add(t);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Topic createTopic (String t, String sd, String ld, List<Quiz> aq) {
        return new Topic(t, sd, ld, aq);
    }

    public Quiz createQuiz (String ques, List<String> ans, int correct) {
        return new Quiz(ques, ans, correct);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
