package jkluu1.washington.edu.quizdroid4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JenniferLuu on 3/3/15.
 */
public class AnswersFragment extends Fragment {
    private int score;
    private int qNumber;
    private int correctAnswer;
    private int selected;
    private boolean isFinished;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View answersFragmentView = inflater.inflate(R.layout.fragment_answers, container, false);

        Bundle bundle = this.getArguments();
        Topic topic = (Topic) bundle.getSerializable("topic");
        score = bundle.getInt("score");
        qNumber = bundle.getInt("qNumber");
        correctAnswer = bundle.getInt("correctAnswer");
        selected = bundle.getInt("selected");

        TextView r = (TextView) answersFragmentView.findViewById(R.id.results);

        TextView c = (TextView) answersFragmentView.findViewById(R.id.correct);
        TextView i = (TextView) answersFragmentView.findViewById(R.id.incorrect);

        String key = topic.getAllQuestions().get(qNumber).getAnswers().get(correctAnswer);

        if (correctAnswer == selected) {
            score++;
            r.setText("Correct!!");
        } else {
            r.setText("Sorry, that was incorrect.");
            i.setText("Your response was: " + topic.getAllQuestions().get(qNumber).getAnswers().get(selected));
        }

        c.setText("The correct Answer was : " + key);

        TextView state = (TextView) answersFragmentView.findViewById(R.id.status);
        state.setText("You have gotten " + score + " correct out of " + topic.getAllQuestions().size());
        qNumber++;

        Button b = (Button) answersFragmentView.findViewById(R.id.submit);
        if (topic.getAllQuestions().size() >= (qNumber + 1)) {
            b.setText("Next");
            isFinished = false;
        } else {
            b.setText("Finish");
            isFinished = true;
        }

        btnSetup(answersFragmentView, topic);

        return answersFragmentView;
    }

    public void btnSetup(View answersFragmentView, final Topic topic) {
        Button btn = (Button) answersFragmentView.findViewById(R.id.submit);

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (isFinished) {

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();

                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("topic", topic);
                    bundle.putInt("score", score);
                    bundle.putInt("qNumber", qNumber);
                    bundle.putInt("selected", selected);

                    QuestionsFragment questionsFragment = new QuestionsFragment();
                    questionsFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.allFragments, questionsFragment);
                    fragmentTransaction.addToBackStack(null);
                }
                fragmentTransaction.commit();
            }
        });
    }
}
