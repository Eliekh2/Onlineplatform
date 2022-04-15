package com.example.onlineplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StudentHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);
        ImageView pic = findViewById(R.id.FA_pic);
        pic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchFinancialAid();
            }
        });

        ImageView pic1 = findViewById(R.id.category);
        pic1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchCategory();
            }
        });

        ImageView pic2 = findViewById(R.id.dashboard);
        pic2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchDashboard();
            }

        });

    }

    public void launchCategory(){
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

    public void launchFinancialAid(){
        Intent intent = new Intent(this,FinancialAidForm.class);
        startActivity(intent);
    }

    public void launchDashboard(){
        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }

}


