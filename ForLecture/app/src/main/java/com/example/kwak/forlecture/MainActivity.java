package com.example.kwak.forlecture;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//Lab 1 - 1(2)
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                  // Do layout inflation from XML.
        imageView = (ImageView)findViewById(R.id.imageView);      //Do reference view objects.
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }
    // When Change button is clicked, it will operate and change the image.
    public void onButton1Clicked(View v){
        changeImage();
    }

    // Using image Index 0 and 1, make blue image to red image.
    private void changeImage(){
        if(imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }
        else if(imageIndex == 1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex=0;
        }
    }
}

// Lab 1-2
/*
public class MainActivity extends AppCompatActivity {
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);             // Do layout inflation from XML.
        init();                                             // For referencing view objects.
    }
    public void init(){                                     // Do reference view objects.
    edit_name = (EditText)findViewById(R.id.editText);      // findViewById method can find and
    btn_clear = (Button)findViewById(R.id.clear_btn);       // reference Id of objects from XML.
    btn_print = (Button)findViewById(R.id.print_btn);
    view_print = (TextView)findViewById(R.id.outcome);
    }
    // When Print clear is clicked, it will be operate.
    public void clearClicked(View v){                       // Do clear space of text view and edit text.
        edit_name.setText(" ");                             // using setText method.
        view_print.setText(" ");
    }
    // When Print button is clicked, it will be operate.
    public void printClicked(View v){                       // Do print strings from edit text.
        String text = "";
        text = edit_name.getText().toString();              // getText method gets strings from edit text.
        view_print.setText(text);                           // and toString method makes data string type.
    }
}
*/