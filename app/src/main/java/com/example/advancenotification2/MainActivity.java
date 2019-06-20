package com.example.advancenotification2;



import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.NotificationManager ;


public class MainActivity extends AppCompatActivity {

    private EditText editText ;
    private EditText editText2 ;
    private Button buttonChannel1 ;
    private Button   buttonChannel2 ;

    private NotificationHelper mNotificationHelper ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText) findViewById(R.id.editText);
        editText2 =(EditText) findViewById(R.id.editText2);
        buttonChannel1 = (Button) findViewById(R.id.buttonChannel1);
        buttonChannel2 = (Button) findViewById(R.id.buttonChannel2);

        mNotificationHelper = new NotificationHelper(this);


        // this is set on click listener buttonchannel1
        buttonChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendOnChannel1(editText.getText().toString() , editText2.getText().toString());

            }
        });

        // this is st on click listener buttonchannel2
        buttonChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(editText.getText().toString() , editText2.getText().toString());
            }
        });

    }
    public void sendOnChannel1(String title , String message){

        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title  , message);
        mNotificationHelper.getManager().notify(1 , nb.build());

    }
    public void sendOnChannel2(String title , String message){
        NotificationCompat.Builder nb = mNotificationHelper.getChannel2Notification(title  , message);
        mNotificationHelper.getManager().notify(2 , nb.build());
    }
}
