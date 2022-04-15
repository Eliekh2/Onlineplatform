package com.example.onlineplatform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CybersecuirtyCategory extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cybersecuritycat);

        Button networkingcourse = findViewById(R.id.Networking1);;

        networkingcourse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                networkingmoreinfo();
            }

        });

    }

    public void networkingmoreinfo(){
        Intent intent = new Intent(this, NetworkingCourseInfo.class);
        startActivity(intent);
    }

}
