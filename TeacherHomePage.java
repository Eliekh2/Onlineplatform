package com.example.onlineplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacherhomepage);

        ImageView pic = findViewById(R.id.uploadcourse);
        pic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchCourseUpload();
            }
        });

        ImageView pic1 = findViewById(R.id.mycourses);
        pic1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchMyCourses();
            }
        });

        ImageView pic2 = findViewById(R.id.payrollpic);
        pic2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                launchPayRoll();
            }

        });

    }

    public void launchCourseUpload(){
        Intent intent = new Intent(this, UploadCourse.class);
        startActivity(intent);
    }

    public void launchMyCourses(){
        Intent intent = new Intent(this, MyCoursesTeacher.class);
        startActivity(intent);
    }

    public void launchPayRoll(){
        Intent intent = new Intent(this, PayrollTeacher.class);
        startActivity(intent);
    }

}


