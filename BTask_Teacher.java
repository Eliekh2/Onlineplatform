package com.example.onlineplatform;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BTask_Teacher extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;

    Context ctx;

    BTask_Teacher(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
    alertDialog=new AlertDialog.Builder(ctx).create();
    alertDialog.setTitle("Login Information...");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.2.2/Projectdb/register_teacher.php";
        String loginteacher_url ="http://10.0.2.2/projectdb/login_teacher.php";
        String uploadCourse_url = "http://10.0.2.2/projectdb/uploadCourse.php";
        String method;
        method = params[0];
        if (method.equals("registerTeacher")) {
          String teacher_id = params[1];
            String teacher_name = params[2];
            String teacher_pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") +"="+ URLEncoder.encode(teacher_id, "UTF-8") +"&"+
                        URLEncoder.encode("teacher_name", "UTF-8") +"="+ URLEncoder.encode(teacher_name, "UTF-8") +"&"+
                        URLEncoder.encode("teacher_pass", "UTF-8") +"="+ URLEncoder.encode(teacher_pass, "UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "ISO-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                System.out.println("++++++++++++++++++++++RegisterTeacher:" + response);
                return "Registration success";
         //

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        else if(method.equals("loginTeacher"))
        {
            String teacher_id=params[1];
            String teacher_pass=params[2];
            try{
            URL url = new URL(loginteacher_url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String data = URLEncoder.encode("teacher_id", "UTF-8")+"="+URLEncoder.encode(teacher_id, "UTF-8") +"&"+
                    URLEncoder.encode("teacher_pass", "UTF-8")+"="+URLEncoder.encode(teacher_pass, "UTF-8");
       bufferedWriter.write(data);
       bufferedWriter.flush();
       bufferedWriter.close();
       outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                System.out.println("Success!");
                return response;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }//else if end
        if (method.equals("uploadCourse")) {

            String teacher_id = params[1];
            String course_id = params[2];
            String course_name = params[3];
            String course_duration = params[4];
            String course_price = params[5];
            String prerequisites = params[6];
            String category = params[7];
            String materials = params[8];
            try {
                URL url = new URL(uploadCourse_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("teacher_id", "UTF-8") +"="+ URLEncoder.encode(teacher_id, "UTF-8") +"&"+
                        URLEncoder.encode("course_id", "UTF-8") +"="+ URLEncoder.encode(course_id, "UTF-8") +"&"+
                        URLEncoder.encode(" course_name", "UTF-8") +"="+ URLEncoder.encode( course_name, "UTF-8") +"&"+
                        URLEncoder.encode("course_duration", "UTF-8") +"="+ URLEncoder.encode(course_duration, "UTF-8") +"&"+
                        URLEncoder.encode("course_price", "UTF-8") +"="+ URLEncoder.encode(course_price, "UTF-8") +"&"+
                        URLEncoder.encode("prerequisites", "UTF-8") +"="+ URLEncoder.encode(prerequisites, "UTF-8") +"&"+
                        URLEncoder.encode("category", "UTF-8") +"="+ URLEncoder.encode(category, "UTF-8") +"&"+
                        URLEncoder.encode("materials", "UTF-8") +"="+ URLEncoder.encode(materials, "UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "ISO-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return "Upload successful";
               //   System.out.println("++++++++++++++++++++++Register:" + response);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration success")){
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show(); }
    else if(result.equals("Upload successful")){
            Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        }
        else {
        alertDialog.setMessage(result);
        alertDialog.show();

    }
    }

}