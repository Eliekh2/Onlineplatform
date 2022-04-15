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


public class BackgroundTask extends AsyncTask<String,Void,String> {
   static AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://10.0.2.2/Projectdb/register.php";
        String login_url = "http://10.0.2.2/projectdb/Login.php";
        String FA_url = "http://10.0.2.2/projectdb/FinancialAidrequest.php";
        String method;
        method = params[0];
        if (method.equals("register")) {


            String student_id = params[1];
            String student_name = params[2];
            String student_pass = params[3];
            String email = params[4];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("student_id", "UTF-8") +"="+ URLEncoder.encode(student_id, "UTF-8") + "&" +
                        URLEncoder.encode("student_name", "UTF-8") +"="+ URLEncoder.encode(student_name, "UTF-8") + "&" +
                        URLEncoder.encode("student_pass", "UTF-8") +"="+ URLEncoder.encode(student_pass, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8")+"="+ URLEncoder.encode(email, "UTF-8");

                /* String data = URLEncoder.encode("id", "UTF-8") +"="+ URLEncoder.encode(student_id, "UTF-8") + "&" +
                    (    URLEncoder.encode("name", "UTF-8") +"="+ URLEncoder.encode(student_name, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") +"="+ URLEncoder.encode(student_pass, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") +"="+ URLEncoder.encode(email, "UTF-8");*/

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
                System.out.println("++++++++++++++++++++++Register:" + response);
                return "Registration success";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals("login")) {
            String student_id = params[1];
            String student_pass = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("student_id", "UTF-8") + "=" + URLEncoder.encode(student_id, "UTF-8") + "&" +
                        URLEncoder.encode("student_pass", "UTF-8") + "=" + URLEncoder.encode(student_pass, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = " ";
                String line = " ";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

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

        }
        if (method.equals("sendFA")) {

            String student_id = params[1];
            String fa_message = params[2];
            String approval = params[3];
            try {
                URL url = new URL(FA_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("student_id", "UTF-8") +"="+ URLEncoder.encode(student_id, "UTF-8") +"&"+
                        URLEncoder.encode("fa_message", "UTF-8") +"="+ URLEncoder.encode(fa_message, "UTF-8")+"&"+
                        URLEncoder.encode("approval", "UTF-8") +"="+ URLEncoder.encode(approval, "UTF-8");

                /* String data = URLEncoder.encode("id", "UTF-8") +"="+ URLEncoder.encode(student_id, "UTF-8") + "&" +
                        URLEncoder.encode("name", "UTF-8") +"="+ URLEncoder.encode(student_name, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") +"="+ URLEncoder.encode(student_pass, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") +"="+ URLEncoder.encode(email, "UTF-8");*/

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                System.out.println("++++++++++++++++++++++sendRequest:" + response);
                return "Request sent!";
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
        if (result.equals("Registration success")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Request sent!")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }

        else {

            alertDialog.setMessage(result);
            alertDialog.show();

        }
    }
}

