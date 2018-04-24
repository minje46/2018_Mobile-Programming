 package com.example.kwak.forlecture_activity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Bundle 예제

 public class MainActivity extends AppCompatActivity {

     EditText editText;
     Button button;
     String str;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         editText = findViewById(R.id.editText);
         button = findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                 Bundle bundle = new Bundle();
                 str = editText.getText().toString();
                 bundle.putString("Name",str);
                 intent.putExtras(bundle);
                 startActivityForResult(intent, 1);
             }
         });
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         String str = data.getStringExtra("Return");
         Toast.makeText(getApplicationContext(),"Return : " +str, Toast.LENGTH_SHORT).show();
     }
 }




// Lab 2 - 2
 /*
 public class MainActivity extends AppCompatActivity {

     EditText url;
     Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = (EditText)findViewById(R.id.editUrl);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myurl = url.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("url", myurl);
                startActivity(intent);
            }
        });
    }
}
*/
// Lab 2 - 1
 /*
 public class MainActivity extends AppCompatActivity {
     EditText Name;
     EditText Age;
     Button button;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Name = (EditText)findViewById(R.id.editName);
         Age = (EditText)findViewById(R.id.editAge);
         button = (Button)findViewById(R.id.btnAdd);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name = Name.getText().toString();
                 String age = Age.getText().toString();
                 Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                 intent.putExtra("Name", name);
                 intent.putExtra("Age", age);
                 startActivity(intent);
             }
         });
     }
 }
*/

 // Service start 예제
/*
 public class MainActivity extends AppCompatActivity {

   @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         Button btnStart = (Button)findViewById(R.id.btnStartService);
         Button btnStop = (Button)findViewById(R.id.btnStopService);

         btnStart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startService(new Intent(getApplicationContext(), MyService.class));
             }
         });

         btnStop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 stopService(new Intent(getApplicationContext(), MyService.class));
             }
         });
     }
 }
 */

// Life Cycle 확인을 위한 Override and log.
/*
 public class MainActivity extends AppCompatActivity {

     String tag = "LifeCycle";

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Log.d(tag, "In the onCreate() Event");
     }
         @Override
         protected void onStart () {
             super.onStart();
             Log.d(tag, "In the onStart() Event");
         }

         @Override
         protected void onRestart () {
             super.onRestart();
             Log.d(tag, "In the onRestart() Event");
         }

         @Override
         protected void onResume () {
             super.onResume();
             Log.d(tag, "In the onResume() Event");
         }

         @Override
         protected void onPause () {
             super.onPause();
             Log.d(tag, "In the onPause() Event");
         }
         @Override
         protected void onStop () {
             super.onStop();
             Log.d(tag, "In the onStop() Event");
         }

         @Override
         protected void onDestroy () {
             super.onDestroy();
             Log.d(tag, "In the onDestroy() Event");
         }
 }
*/

// 화면전환 예제.
/*
 public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         Button button1 = (Button) findViewById(R.id.button1);

         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                 startActivityForResult(intent, 1);
             }
         });
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         String outName = data.getStringExtra("name");
         Toast.makeText(getApplicationContext(), "Result value : " + outName, Toast.LENGTH_LONG).show();
     }

 }
*/

// Implicit Intent
/*
 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01011112222"));
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-777-7777"));
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/pictures/*");
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String myData = "content://contacts/people";
                Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(myActivity2);
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String myData="content://contacts/people/3";
                Intent myActivity2=new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(myActivity2);
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String myData="content://contacts/people/3";
                Intent myActivity2=new Intent(Intent.ACTION_EDIT, Uri.parse(myData));
                startActivity(myActivity2);
            }
        });

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01011112222"));
                intent.putExtra("sms body","are we playing golf next Saturday?");
                startActivity(intent);
            }
        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
             Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
             intent.putExtra(SearchManager.QUERY,"foods you should eat");
                startActivity(intent);
            }
        });
    }
}
*/