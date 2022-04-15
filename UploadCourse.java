package com.example.onlineplatform;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadCourse extends Activity implements AdapterView.OnItemSelectedListener{
EditText ET_teacher_id,ET_course_id,ET_course_name,ET_course_duration,ET_course_price,ET_prereq,ET_Materials;
Spinner ET_category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_course);
        ET_teacher_id = (EditText) findViewById(R.id.teacher_id);
        ET_course_id = (EditText) findViewById(R.id.course_id);
        ET_course_name = (EditText) findViewById(R.id.course_name);
        ET_course_duration = (EditText) findViewById(R.id.course_duration);
        ET_course_price = (EditText) findViewById(R.id.course_price);
        ET_prereq = (EditText) findViewById(R.id.course_prereq);
        ET_category = (Spinner) findViewById(R.id.categoryspinner);
        ET_Materials = (EditText) findViewById(R.id.materials);


        Spinner catSpinner = findViewById(R.id.categoryspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSpinner.setAdapter(adapter);
        catSpinner.setOnItemSelectedListener(this);
    }
    public void uploadCourse(View view) {


        String teacher_id = ET_teacher_id.getText().toString();
        String course_id = ET_course_id.getText().toString();
        String course_name = ET_course_name.getText().toString();
        String course_duration = ET_course_duration.getText().toString();
        String course_price = ET_course_price.getText().toString();
        String prerequisites = ET_prereq.getText().toString();
        String category = ET_category.getContext().toString();
        String materials = ET_Materials.getText().toString();

        String method="uploadCourse";
        BTask_Teacher bTask_teacher=new BTask_Teacher(UploadCourse.this);
        bTask_teacher.execute(method,teacher_id,course_id,course_name,course_duration,course_price,prerequisites,category,materials);
        System.out.println("================================");
        ET_teacher_id.setText("");
        ET_course_id.setText("");
        ET_course_name.setText("");
        ET_course_duration.setText("");
        ET_course_price.setText("");
        ET_prereq.setText("");
        ET_Materials.setText("");
        startActivity(new Intent(this,TeacherHomePage.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text =parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}