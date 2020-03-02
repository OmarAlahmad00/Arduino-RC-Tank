package com.example.tankcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;


import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity{

    String ip;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button = findViewById(R.id.forward);
        final Button backwards = findViewById(R.id.backward);
        final Button left = findViewById(R.id.left);
        final Button right = findViewById(R.id.right);
        final Button stop = findViewById(R.id.stop);

        final TextView text = findViewById(R.id.nicetext);
        final EditText ips = findViewById(R.id.ipText);



        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    ip = ips.getText().toString();
                    new Forward().execute();
                    button.setText("Button Worked");
                } catch (Exception e) {

                    button.setText("No Worked");
                    text.setText(e.toString());

                }
            }


        });

        backwards.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    new Backward().execute();
                    button.setText("Button Worked");
                } catch (Exception e) {

                    button.setText("No Worked");
                    text.setText(e.toString());

                }
            }


        });

        left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    new Left().execute();
                    button.setText("Button Worked");
                } catch (Exception e) {

                    button.setText("No Worked");
                    text.setText(e.toString());

                }
            }


        });

        right.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    new Right().execute();
                    button.setText("Button Worked");
                } catch (Exception e) {

                    button.setText("No Worked");
                    text.setText(e.toString());

                }
            }


        });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                try {

                    new Stop().execute();
                    button.setText("Button Worked");
                } catch (Exception e) {

                    button.setText("No Worked");
                    text.setText(e.toString());

                }
            }


        });

    }



    private class Forward extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {

                url = new URL("http://" + ip + "/FORWARD");

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return "Hello";
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
        }
    }

    private class Backward extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("http://192.168.137.91/BACKWARD");

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return "Hello";
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
        }
    }

    private class Left extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("http://192.168.137.91/LEFT");

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return "Hello";
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
        }
    }

    private class Right extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("http://192.168.137.91/RIGHT");

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return "Hello";
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
        }
    }

    private class Stop extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("http://192.168.137.91/STOP");

                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    char current = (char) data;
                    data = isw.read();
                    System.out.print(current);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return "Hello";
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
        }
    }



}