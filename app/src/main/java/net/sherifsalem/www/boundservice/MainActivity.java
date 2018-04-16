package net.sherifsalem.www.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LocalService mService;
    boolean mBound = false;
    private Button btn;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    btn = findViewById(R.id.button);
    textView = findViewById(R.id.text);


    }


    /**
     * on start we bind the service to our activity
     */
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,LocalService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * on stop method we unbind our local service
     */
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
        mBound =false;
    }



    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /**
             * on service connected
             * initialize our local binder class from ou service
             * connect it to our local service instance
             * set the boolean mBound to true
             */

            LocalService.LocalBinder binder = (LocalService.LocalBinder) service ;
            mService = binder.getService();
            mBound = true;
        }

        /**
         * on service disconnected we set the boolean mBound to false
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
        mBound = false;
        }
    };


    }
}
