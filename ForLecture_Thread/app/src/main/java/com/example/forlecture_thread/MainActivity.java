package com.example.forlecture_thread;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import com.example.forlecture_thread.R;

import java.util.ArrayList;

// Lab 5 - 2.

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    EditText input;
    Button btnCalc;
    int result = 1;
    String sentence = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        input = findViewById(R.id.input);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FactorialTask().execute();      // Starts the CountDownTask.
            }
        });
    }

    public class FactorialTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute(){
            textResult.setText("START");
        }

        @Override
        protected Void doInBackground(Void... voids) {
           int n = Integer.parseInt(input.getText().toString());

           for(int i = n; i >= 0; i--){
               try{
                   Thread.sleep(500);
                   publishProgress(i);
               }catch (Exception e){}

               if(i != 0)
                   result = result * i;
           }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer...values){
            textResult.setText(sentence +Integer.toString(values[0].intValue()));

            if(!Integer.toString(values[0].intValue()).equals("0"))
                sentence = sentence + " " + String.valueOf(Integer.toString(values[0].intValue())) + " ";
        }

        @Override
        protected void onPostExecute(Void aVoid){
            textResult.setText(sentence + "=" +String.valueOf(result));
        }
    }
}








// Lab 5 - 1.
/*
public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    EditText editText;
    Button btnChange;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText);
        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeThread thread1 = new ChangeThread(0);
                thread1.start();

                ChangeThread thread2 = new ChangeThread(1);
                thread2.start();
            }
        });
    }

    class ChangeThread extends Thread{
        int dogIndex, stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public ChangeThread(int index){
            dogIndex = index;
            images.add(R.drawable.dog_1);
            images.add(R.drawable.dog_2);
            images.add(R.drawable.dog_3);
        }

        public void run(){
            stateIndex = 0;
            for(int i = 0; i < 9; i++){
                final String message = "dog #" +dogIndex + "state " + stateIndex;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        editText.append(message + "\n");

                        if(dogIndex == 0)
                            imageView1.setImageResource(images.get(stateIndex));
                        else if(dogIndex == 1)
                            imageView2.setImageResource(images.get(stateIndex));
                    }
                });
                try{
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                stateIndex++;
                if(stateIndex >= images.size())
                    stateIndex = 0;
            }
        }
    }

    public int getRandomTime(int min, int max){
        return min + (int)(Math.random() * (max-min));
    }
}
*/


// Asynch example.
/*
public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        new CountDownTask().execute();      // Starts the CountDownTask.
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute(){
            textView.setText("START");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = 15; i >= 0; i--){
                try{
                    Thread.sleep(1000);
                    publishProgress(i);
                }catch (Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer...values){
            textView.setText(Integer.toString(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void aVoid){
            textView.setText("DONE");
        }
    }
}
*/


// Thread & Handler example.
/*
public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;
    boolean isRunning = false;
// Example 1.
//    ProgressHandler handler;

// Example 2.
    Handler handler;
    ProgressRunnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // Example 1.
//        handler = new ProgressHandler();

        // Example 2.
        handler = new Handler();
        runnable = new ProgressRunnable();
    }

    @Override
    protected void onStart(){
        super.onStart();
        progressBar.setProgress(0);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i = 0; i < 20 && isRunning; i++){
                        Thread.sleep(1000);

                        // Example 1.
//                        Message msg = handler.obtainMessage();
//                        handler.sendMessage(msg);

                        // Example 2.
                            handler.post(runnable);
                    }
                }catch(Exception e){
                    Log.e("MainActivity", "Exception in processing message.", e);
                }
            }
        });
        isRunning = true;
        thread1.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        isRunning= false;
    }

    // Example 1.
//    public class ProgressHandler extends Handler{
//        public void handleMessage(Message msg){

    // Example 2.
    public class ProgressRunnable implements Runnable{
        @Override
        public void run() {
// 여기까지 example 2.
            progressBar.incrementProgressBy(5);

            if(progressBar.getProgress() == progressBar.getMax()){
                textView.setText("Done");
            }
            else{
                textView.setText("Working..." + progressBar.getProgress());
            }
        }
    }
}
*/

// Thread example 1.
/*
public class MainActivity extends AppCompatActivity {

    private boolean running;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("The value form thread : "+value);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        running = true;
        Thread thread1 = new BackGroundThread();
        thread1.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        running = false;
        value = 0;
    }

    class BackGroundThread extends Thread {
        public void run() {
            while (running) {
                try {
                    Thread.sleep(1000);
                    value++;
                } catch (Exception ex) {
                }
            }
        }
    }
}
*/
