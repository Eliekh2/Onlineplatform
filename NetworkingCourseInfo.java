package com.example.onlineplatform;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NetworkingCourseInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.networkingcourse);

        Button enroll = findViewById(R.id.enroll);

        enroll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showLink();
            }

        });

    }

    public void showLink(){
        TextView link = findViewById(R.id.link);
        link.setVisibility(View.VISIBLE);
    }

}
