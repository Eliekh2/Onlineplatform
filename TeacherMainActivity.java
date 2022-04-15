package com.example.onlineplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class TeacherMainActivity extends Activity {
    RadioButton RB_Admin,RB_Student,RB_Teacher;
    EditText ET_Tid,ET_Tpass;
   Button logintBt;
    String teacher_id;
    String teacher_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_main2);
        RB_Admin=(RadioButton) findViewById(R.id.AdminRadio);
        RB_Student=(RadioButton) findViewById(R.id.StudentRadio) ;
        RB_Teacher =(RadioButton)  findViewById(R.id.TeacherRadio);
        ET_Tid=(EditText) findViewById(R.id.teacher_id);
        ET_Tpass=(EditText) findViewById(R.id.teacher_pass);
        logintBt =(Button) findViewById(R.id.loginteacher);
    logintBt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(validateUsername() && validatePassword()){
                teacher_login();
                startActivity(new Intent(TeacherMainActivity.this,TeacherHomePage.class));
            }else {
                ET_Tid.setText("");
                ET_Tpass.setText("");
                Toast.makeText(TeacherMainActivity.this, "Try Again..", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    public void onRadioButtonClicked(View v)
    {


        boolean  checked = ((RadioButton) v).isChecked();

        switch(v.getId()){

            case R.id.AdminRadio:
                if(checked)
                    startActivity(new Intent(this,AdminActivity2.class));
                break;
            case R.id.TeacherRadio :
                if(checked)
                    startActivity(new Intent(this,TeacherMainActivity.class));
                break;
            case R.id.StudentRadio:
                if(checked)
                    startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

    public Boolean validateUsername() {
        String val = ET_Tid.getText().toString();
        if (val.isEmpty()) {
            ET_Tid.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 5) {
            ET_Tid.setError("ID too long");
            return false;
        } else {
            ET_Tid.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = ET_Tpass.getText().toString();
        if (val.isEmpty()) {
            ET_Tpass.setError("Field cannot be empty");
            return false;
        } else if (val.length() < 4) {
            ET_Tpass.setError("Password too short");
            return false;
        } else {
            ET_Tpass.setError(null);
            return true;
        }

    }


    public void teacher_login()
    {
         teacher_id = ET_Tid.getText().toString();
         teacher_pass = ET_Tpass.getText().toString();

        String method="loginTeacher";
        BTask_Teacher bTask_Teacher=new BTask_Teacher(this);
        bTask_Teacher.execute(method,teacher_id,teacher_pass);
        finish();



    }

      public void teacher_register(View view)
    {
        startActivity(new Intent(TeacherMainActivity.this,RegisterTeacherActivity.class));
    }



}