package jkluu1.washington.edu.quizdroid4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JenniferLuu on 3/2/15.
 */
public class OverviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View overviewFragmentView = inflater.inflate(R.layout.fragment_overview, container, false);

        Bundle bundle = this.getArguments();
        final Topic topic = (Topic) bundle.getSerializable("topic");
        TextView title = (TextView) overviewFragmentView.findViewById(R.id.title);
        title.setTextSize(40);
        title.setText(topic.getTitle());

        TextView description = (TextView) overviewFragmentView.findViewById(R.id.longDescription);
        description.setText(topic.getLongDescription());

        TextView totalQs = (TextView) overviewFragmentView.findViewById(R.id.numOfQuestions);
        totalQs.setText("There will be " + topic.getAllQuestions().size() + " question(s)");

        Button button = (Button) overviewFragmentView.findViewById(R.id.submit);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int score = 0;
                int qNumber = 0;
                Bundle bundle = new Bundle();
                bundle.putInt("score", score);
                bundle.putInt("qNumber", qNumber);
                bundle.putSerializable("topic", topic);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                QuestionsFragment questionsFragment = new QuestionsFragment();
                questionsFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.allFragments, questionsFragment);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return overviewFragmentView;

    }
}
