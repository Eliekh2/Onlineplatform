package com.example.onlineplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CategoriesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        ImageView pic = findViewById(R.id.cyberpic);
        pic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(CategoriesActivity.this,"Cybersecurity Category",Toast.LENGTH_LONG).show();
            }

        });

        ImageView pic1 = findViewById(R.id.datasciencepic);
        pic1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(CategoriesActivity.this,"DataScience Category",Toast.LENGTH_LONG).show();
            }

        });

        ImageView pic2 = findViewById(R.id.itpic);
        pic2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(CategoriesActivity.this,"IT Category",Toast.LENGTH_LONG).show();
            }

        });

        ImageView pic3 = findViewById(R.id.softwareengpic);
        pic3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(CategoriesActivity.this,"Software Engineering Category",Toast.LENGTH_LONG).show();
            }

        });


    }

    public void BackHome(View view){

        Intent intent = new Intent(this, StudentHomePage.class);
        startActivity(intent);

    }

}


