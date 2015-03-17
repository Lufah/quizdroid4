package jkluu1.washington.edu.quizdroid4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JenniferLuu on 3/4/15.
 */


public class QuestionsFragment extends Fragment {

    private int score;
    private int qNumber;
    private int correctAnswer;
    private int selected;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View questionsFragmentView = inflater.inflate(R.layout.fragment_questions, container, false);

        Bundle bundle = this.getArguments();
        Topic topic = (Topic) bundle.getSerializable("topic");
        score = bundle.getInt("score");
        qNumber = bundle.getInt("qNumber");

        selected = -2;

        TextView total = (TextView) questionsFragmentView.findViewById(R.id.totalQs);
        total.setText("Question Number " + (qNumber + 1));

        TextView q = (TextView) questionsFragmentView.findViewById(R.id.question);

        String key = topic.getAllQuestions().get(qNumber).getQuestionText(); // returns question


        List<String> answer = topic.getAllQuestions().get(qNumber).getAnswers();
        q.setText(key);
        correctAnswer = topic.getAllQuestions().get(qNumber).getCorrectAnswer();

        RadioButton a1 = (RadioButton) questionsFragmentView.findViewById(R.id.a);
        a1.setText(answer.get(0));
        RadioButton a2 = (RadioButton) questionsFragmentView.findViewById(R.id.b);
        a2.setText(answer.get(1));
        RadioButton a3 = (RadioButton) questionsFragmentView.findViewById(R.id.c);
        a3.setText(answer.get(2));
        RadioButton a4 = (RadioButton) questionsFragmentView.findViewById(R.id.d);
        a4.setText(answer.get(3));


        RadioGroup radioGroup = (RadioGroup) questionsFragmentView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                RadioButton rButton = (RadioButton) group.findViewById(checkedId);
                selected = group.indexOfChild(rButton);

                Button btn = (Button) questionsFragmentView.findViewById(R.id.submit);
                btn.setText("" + selected);
                btn.setVisibility(View.VISIBLE);

            }
        });

        btnOnClick(questionsFragmentView, topic);

        return questionsFragmentView;
    }

    public void btnOnClick(View v, final Topic topic) {
        Button btn = (Button) v.findViewById(R.id.submit);

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("topic", topic);
                bundle.putInt("score", score);
                bundle.putInt("qNumber", qNumber);
                bundle.putInt("selected", selected);
                bundle.putInt("correctAnswer", correctAnswer);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AnswersFragment answersFragment = new AnswersFragment();
                answersFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.allFragments, answersFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
