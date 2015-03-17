package jkluu1.washington.edu.quizdroid4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by JenniferLuu on 2/27/15.
 */

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("test", "received");

        String url = intent.getStringExtra("url");
        // String mins = intent.getStringExtra("mins");

        String text = url;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}