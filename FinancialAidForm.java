package com.example.onlineplatform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class FinancialAidForm extends Activity {

    EditText ET_student_id,ET_FA_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financialaidform);
        ET_student_id=(EditText) findViewById(R.id.fa_student_id);
        ET_FA_message = (EditText) findViewById(R.id.fa_message);

    }


    public void SendMessage(View view){
        String student_id=ET_student_id.getText().toString();
        String fa_message=ET_FA_message.getText().toString();
        String approval= "null";
        String method="sendFA";
        BackgroundTask backgroundTask=new BackgroundTask(FinancialAidForm.this);
        backgroundTask.execute(method,student_id,fa_message,approval);
        System.out.println("================================");
        ET_student_id.setText("");
        ET_FA_message.setText("");

        Toast.makeText(this, "Request sent!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, StudentHomePage.class);
        startActivity(intent);

    }


    public void backhome(){
        Intent intent = new Intent(FinancialAidForm.this,StudentHomePage.class);
        startActivity(intent);

    }

}
