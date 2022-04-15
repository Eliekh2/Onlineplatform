package com.example.onlineplatform;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;

public class RegisterStudentActivity extends Activity {
    EditText ET_EMAIL,ET_STUDENT_NAME,ET_STUDENT_PASS,ET_STUDENT_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ET_EMAIL = (EditText) findViewById(R.id.email);
        ET_STUDENT_NAME = (EditText) findViewById(R.id.student_name);
        ET_STUDENT_PASS = (EditText) findViewById(R.id.student_pass);
        ET_STUDENT_ID =(EditText) findViewById(R.id.student_id);


   // BT_register.setOnClickListener(new View.OnClickListener() {
     //   @Override




    }
    public Boolean validateUsername() {
        String val = ET_STUDENT_ID.getText().toString();
        if (val.isEmpty()) {
            ET_STUDENT_ID.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 12) {
            ET_STUDENT_ID.setError("ID too long");
            return false;
        } else {
            ET_STUDENT_ID.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = ET_STUDENT_PASS.getText().toString();
        if (val.isEmpty()) {
            ET_STUDENT_PASS.setError("Field cannot be empty");
            return false;
        } else if (val.length() < 4) {
            ET_STUDENT_PASS.setError("Password too short");
            return false;
        } else {
            ET_STUDENT_PASS.setError(null);
            return true;
        }

    }

    public void register(View view) {

        String student_name = ET_STUDENT_NAME.getText().toString();
        String student_id = ET_STUDENT_ID.getText().toString();
        String student_pass = ET_STUDENT_PASS.getText().toString();
        String email = ET_EMAIL.getText().toString();
        validateUsername();
        validatePassword();

        String method="register";
        BackgroundTask backgroundTask=new BackgroundTask(RegisterStudentActivity.this);
        backgroundTask.execute(method,student_id,student_name,student_pass,email);
        System.out.println("================================");
        ET_STUDENT_ID.setText("");
        ET_STUDENT_NAME.setText("");
        ET_STUDENT_PASS.setText("");
        ET_EMAIL.setText("");
        Toast.makeText(this, "User successfully registered!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}