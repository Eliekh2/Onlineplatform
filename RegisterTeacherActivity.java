package com.example.onlineplatform;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterTeacherActivity extends Activity {
EditText ET_TEACHER_NAME,ET_TEACHER_PASS,ET_TEACHER_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_teacher);
        ET_TEACHER_ID =(EditText) findViewById(R.id.new_teacher_id);
        ET_TEACHER_NAME = (EditText) findViewById(R.id.new_teacher_name);
        ET_TEACHER_PASS = (EditText) findViewById(R.id.new_teacher_pass);
        validateUsername();
        validatePassword();


        // BT_register.setOnClickListener(new View.OnClickListener() {
        //   @Override




    }
    public Boolean validateUsername() {
        String val = ET_TEACHER_ID.getText().toString();
        if (val.isEmpty()) {
            ET_TEACHER_ID.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 12) {
            ET_TEACHER_ID.setError("ID too long");
            return false;
        } else {
            ET_TEACHER_ID.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = ET_TEACHER_PASS.getText().toString();
        if (val.isEmpty()) {
            ET_TEACHER_PASS.setError("Field cannot be empty");
            return false;
        } else if (val.length() < 5) {
            ET_TEACHER_PASS.setError("Password too short");
            return false;
        } else {
            ET_TEACHER_PASS.setError(null);
            return true;
        }

    }
    public void register_teacher(View view) {

        String teacher_name = ET_TEACHER_NAME.getText().toString();
        String teacher_id = ET_TEACHER_ID.getText().toString();
        String teacher_pass = ET_TEACHER_PASS.getText().toString();
        validateUsername();
        validatePassword();
        String method="registerTeacher";
        BTask_Teacher bTask_teacher=new BTask_Teacher(RegisterTeacherActivity.this);
        bTask_teacher.execute(method,teacher_id,teacher_name,teacher_pass);
        System.out.println("================================");
        ET_TEACHER_ID.setText("");
        ET_TEACHER_NAME.setText("");
        ET_TEACHER_PASS.setText("");
        Intent intent = new Intent(this, TeacherMainActivity.class);
        startActivity(intent);

    }

}