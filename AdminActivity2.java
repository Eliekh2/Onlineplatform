package com.example.onlineplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdminActivity2 extends Activity {
RadioButton Rb_teacher,Rb_admin,Rb_student;
EditText ET_id,ET_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity2);
        ET_id =(EditText) findViewById(R.id.admin_id) ;
        ET_pass =(EditText) findViewById(R.id.admin_pass);
        Rb_admin=(RadioButton) findViewById(R.id.adminradio);
        Rb_student=(RadioButton) findViewById(R.id.studentradio) ;
        Rb_teacher =(RadioButton)  findViewById(R.id.teacherradio);
    }
    public void onRadioButtonClicked(View v)
    {


        boolean  checked = ((RadioButton) v).isChecked();

        switch(v.getId()){

            case R.id.adminradio:
                if(checked)
                    startActivity(new Intent(this,AdminActivity2.class));
                break;

            case R.id.teacherradio:
                if(checked)
                    startActivity(new Intent(this,TeacherMainActivity.class));
                break;

            case R.id.studentradio:
                if(checked)
                    startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
    public void admin_login(View view) {
        String enteredId,enteredpass;
        enteredId=ET_id.getText().toString();
        enteredpass =ET_pass.getText().toString();
        String password="admin";
        String Elie_id = "57834";
        String Joe_id="57969";
        while (enteredId.equals(Elie_id) || enteredId.equals(Joe_id)){
            if (enteredpass.equals(password)){
                startActivity(new Intent(this,AdminHomePage.class));
            }
           else Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show();
        }
        ET_id.setText("");
        ET_pass.setText("");
        Toast.makeText(this, "Not an Admin", Toast.LENGTH_LONG).show();

    }

}