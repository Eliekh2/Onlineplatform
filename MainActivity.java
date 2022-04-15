package com.example.onlineplatform;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends Activity {
 RadioButton  RB_student,RB_teacher,RB_admin;
 EditText ET_id,ET_pass;
 Button loginBt;
    String login_studentID;
    String login_studentPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RB_admin=(RadioButton) findViewById(R.id.adminRadio);
        RB_student=(RadioButton) findViewById(R.id.studentRadio) ;
        RB_teacher =(RadioButton)  findViewById(R.id.teacherRadio);
    ET_id=(EditText) findViewById(R.id.student_id);
    ET_pass=(EditText) findViewById(R.id.student_password);
    loginBt =(Button) findViewById(R.id.loginBt);
    loginBt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (validateUsername() && validatePassword()){
                Studentlogin();
                startActivity(new Intent(MainActivity.this,StudentHomePage.class));

            }else {
                ET_id.setText("");
                ET_pass.setText("");
                Toast.makeText(MainActivity.this, "Try Again..", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    public void onRadioButtonClicked(View v)
    {


        boolean  checked = ((RadioButton) v).isChecked();

        switch(v.getId()){

            case R.id.adminRadio:
                if(checked)
                    startActivity(new Intent(MainActivity.this,AdminActivity2.class));
                break;

            case R.id.teacherRadio:
                if(checked)
                    startActivity(new Intent(MainActivity.this,TeacherMainActivity.class));
                break;
            case R.id.studentRadio :
                if (checked)
                    startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

    public Boolean validateUsername() {
        String val = ET_id.getText().toString();
        if (val.isEmpty()) {
            ET_id.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 5) {
            ET_id.setError("ID too long");
            return false;
        } else {
            ET_id.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = ET_pass.getText().toString();
        if (val.isEmpty()) {
            ET_pass.setError("Field cannot be empty");
            return false;
        }
        else if (val.length() < 4) {
            ET_pass.setError("Password too short");
            return false;
        } else {
            ET_pass.setError(null);
            return true;
        }

    }


    public void registerBt(View view){
        startActivity(new Intent(this,RegisterStudentActivity.class));
    }

    public void Studentlogin(){
         login_studentID = ET_id.getText().toString();
         login_studentPass = ET_pass.getText().toString();

        String method ="login";
        BackgroundTask backgroundTask=new BackgroundTask(this);
       backgroundTask.execute(method,login_studentID,login_studentPass);
        finish();




    }



}