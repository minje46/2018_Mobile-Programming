package com.example.kwak.forlecture_activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

// Lab 2 - 2 <new activity>

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button btnGo;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView)findViewById(R.id.textPrint);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnBack = (Button)findViewById(R.id.btnBack);

        final Intent passedIntent = getIntent();
        final String passedUrl = (passedIntent.getStringExtra("url"));
        textView.setText(passedUrl);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplication(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

// Lab 2 - 1 <new activity>
/*
public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button button = (Button)findViewById(R.id.btnClose);
        Intent passedIntent = getIntent();

        if(passedIntent != null){
            String loginName = passedIntent.getStringExtra("Name");
            String loginAge = passedIntent.getStringExtra("Age");
            Toast.makeText(this, "Student Info : " +loginName+","+loginAge,Toast.LENGTH_LONG).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
*/

// Implicit Intent or 화면 전환 예제
/*
public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplication(), "GO back button was pushed", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
*/