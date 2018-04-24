package com.jackpot.forlecture_event;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import  java.util.Date;

// Spinner view example
/*
public class MainActivity extends AppCompatActivity {

    TextView textView;
    String[] items = {"Mike", "Angel", "Crow", "John", "Ginnie", "Sally", "Rice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });
    }
}
*/

// List view example (My adapter & adpaterArray)
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
       // MyAdapter adapter = new MyAdapter(this);
       // listView.setAdapter(adapter);
         String[] names = {"Lee", "Choi", "Kim", "Kwak", "Jeong"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }
}
*/

// Widget Example w menu
/*
public class MainActivity extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView)findViewById(R.id.webKit);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("http://www.ebay.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String option = item.getTitle().toString();

        if(option.equals(("Forward Page")))
            browser.goForward();
        if(option.equals("Back Page"))
            browser.goBack();

        return true;
    }
}
*/

// Fragment second example
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
*/

// Fragment first example
/*
public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index){
        if(index == 0)
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
    }
}
*/

// Check box & Radio button widtet 예제 + Menu
/*
public class MainActivity extends AppCompatActivity {

   Button btnPay;
   CheckBox chkSugar;
   CheckBox chkCream;
   RadioGroup radCoffeeType;
   RadioButton radDecaf;
   RadioButton radEspresso;
   RadioButton radColombian;
   ToggleButton toggleButton;
   Switch switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPay = findViewById(R.id.btnPay);
        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        radCoffeeType = (RadioGroup)findViewById(R.id.radGroupCoffeeType);
        radDecaf = (RadioButton)findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id.radExpresso);
        radColombian = findViewById(R.id.radColombian);
        toggleButton = findViewById(R.id.toggleBtn);
        switchButton = findViewById(R.id.switchBtn);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplication(), "Toggle button is checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplication(), "Toggle button isn't checked", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked())
                    Toast.makeText(getApplication(), "에에ㅔㅇ에?", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplication(), "뭐지>?", Toast.LENGTH_SHORT).show();
            }
    });
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Coffee ";
                if(chkCream.isChecked())
                    msg += " & Cream ";
                if(chkSugar.isChecked())
                    msg += " & Sugar ";

                int radioId = radCoffeeType.getCheckedRadioButtonId();

                if(radDecaf.getId() == radioId)
                    msg = "Decaf " +msg;
                if(radEspresso.getId() == radioId)
                    msg = "Espresso " +msg;
                if(radColombian.getId() == radioId)
                    msg = "Colombian " +msg;

                if(switchButton.isChecked())
                    msg += "with Delivery";

                Toast.makeText(getApplication(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "설정 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
*/

// EditText widget 예제
/*
public class MainActivity extends AppCompatActivity {

    TextView labelUserName;
    Button button;
    EditText textUserName;

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        labelUserName = (TextView)findViewById(R.id.textView);
        textUserName = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = textUserName.getText().toString();
                if (userName.compareTo("David Kwak") == 0) {
                    labelUserName.setText("OK, Please wait...");
                    Toast.makeText(context, "Hi, Prof." + userName, duration).show();
                } else {
                    Toast.makeText(context, userName + "is not a valid USER", duration).show();
                }
            }
        });
    }
}
*/

// Widget 이용 예제
/*
public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateTime();
            }
        });
    }
      private void updateTime(){
        button.setText(new Date().toString());
    }
}
*/

// Lab 3 - 1
/*
public class MainActivity extends AppCompatActivity {

    Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = (Button)findViewById(R.id.btnChange);
        registerForContextMenu(btnChange);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0,1,0,"Red");
        menu.add(0,2,0,"Green");
        menu.add(0,3,0,"Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int idx = item.getItemId();
        switch (idx){
            case 1:
                btnChange.setTextColor(Color.RED);
                break;
            case 2:
                btnChange.setTextColor(Color.GREEN);
                break;
            case 3:
                btnChange.setTextColor(Color.BLUE);
                break;
            default: break;
        }
        return super.onContextItemSelected(item);
    }
}
*/

// Lab 3 - 2
/*
public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioButton chkMan,chkWoman;
    CheckBox chkSms;
    CheckBox chkEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        chkMan = findViewById(R.id.chkMan);
        chkWoman = findViewById(R.id.chkWoman);
        chkSms = findViewById(R.id.chkSms);
        chkEmail = findViewById(R.id.chkEmail);
        button = findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Name", editText.getText().toString());      // Store the name which was written on edit text

                if(chkEmail.isChecked())                    // Compare which one did user check.
                    intent.putExtra("Receive", chkEmail.getText().toString());       // Store receive option which user checked.
                if(chkSms.isChecked())
                    intent.putExtra("Receive", chkSms.getText().toString());

                if(chkMan.isChecked())       // Compare which one did user check.
                    intent.putExtra("Gender", chkMan.getText().toString());              // Store gender which user checked.
                if(chkWoman.isChecked())
                    intent.putExtra("Gender", chkWoman.getText().toString());

                startActivity(intent);
                finish();
            }
        });
    }
}
*/

// Lab 3 - 3

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    FragmentManager fragmentManager;
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment1).commit();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment1).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment2).commit();
            }
        });
    }
}