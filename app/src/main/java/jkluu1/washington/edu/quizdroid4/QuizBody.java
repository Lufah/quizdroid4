package jkluu1.washington.edu.quizdroid4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JenniferLuu on 3/2/15.
 */
public class QuizBody extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizbody);

        Intent intent = getIntent();
        Topic topic = (Topic) intent.getSerializableExtra("topic");

        Bundle bundle = new Bundle();
        bundle.putSerializable("topic", topic);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OverviewFragment overviewFragment = new OverviewFragment();
        overviewFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.allFragments, overviewFragment);
        fragmentTransaction.commit();

    }
}