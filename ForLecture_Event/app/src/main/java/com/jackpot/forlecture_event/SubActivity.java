package com.jackpot.forlecture_event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

// Lab 3 - 2
public class SubActivity extends AppCompatActivity {

    TextView textName;
    TextView textGender;
    TextView textReceive;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textName = findViewById(R.id.textName);
        textGender = findViewById(R.id.textGender);
        textReceive = findViewById(R.id.textReceive);
        button = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        textName.setText(intent.getStringExtra("Name"));
        textGender.setText(intent.getStringExtra("Gender"));
        textReceive.setText(intent.getStringExtra("Receive"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}