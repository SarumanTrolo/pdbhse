package com.example.aimanjamil.pdbhse;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import static android.support.v4.content.ContextCompat.startActivity;
import static java.lang.Integer.parseInt;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }


    protected String doInBackground(String... params) {
        String method=params[0];
        if(method.equals("bssubmitForm"))
        {
            //String reg_url="http://192.168.43.183/movies.php";
            String reg_url="https://pdb-hse.000webhostapp.com/bsinsert.php";
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data=URLEncoder.encode("0","UTF-8")+"="+URLEncoder.encode("0","UTF-8");
                for(int i = 1; i < MainActivity.e.length; i++){
                    data=data+"&"+URLEncoder.encode(String.valueOf(i),"UTF-8")+"="+URLEncoder.encode(MainActivity.e[i],"UTF-8");
                }
                for(int i = 1; i < MainActivity.s.length; i++){
                    data=data+"&"+URLEncoder.encode(String.valueOf(i+15),"UTF-8")+"="+URLEncoder.encode(MainActivity.s[i],"UTF-8");
                }
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Report Sent";




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
    super.onPreExecute();
}

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}