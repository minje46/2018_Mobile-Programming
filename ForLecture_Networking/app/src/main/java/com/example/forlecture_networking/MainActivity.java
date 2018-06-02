package com.example.forlecture_networking;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

// Lab 6 - 3
/**/
public class MainActivity extends AppCompatActivity {
    private EditText inNum, inName;
    private Button btnAdd, btnDelete;
    private String num, name;
    private ListView listView;
    private String[] listData;

    SQLiteDatabase database;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(MainActivity.this, "Lab_6.db", null, 1);

        listView = (ListView)findViewById(R.id.listView);
        inNum = (EditText) findViewById(R.id.inNum);
        inName = (EditText) findViewById(R.id.inName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inName.getText().toString();
                num = inNum.getText().toString();

                if(name.equals("") || num.equals(""))
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();
                else{
                    database = helper.getWritableDatabase();
                    ContentValues values = new ContentValues();

                    values.put("Name", name);
                    values.put("Num", Integer.parseInt(num));
                    database.insert("stu", null, values);

                    invalidate();
                }
            }
        });

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = inName.getText().toString();

                if(name.equals("") || num.equals(""))
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
                else {
                    database = helper.getWritableDatabase();
                    database.delete("stu", "name=?", new String[]{name});

                    invalidate();
                }
            }
        });
    }

    public void select() {
        database = helper.getReadableDatabase();
        Cursor cursor = database.query("stu", null, null, null, null, null, null);

        listData = new String[cursor.getCount()];
        int count = 0;


        while(cursor.moveToNext()) {
            listData[count] = cursor.getString(cursor.getColumnIndex("Name")) + " " + cursor.getString(cursor.getColumnIndex("Num"));
            count++;
        }
        cursor.close();
    }

    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
    }
}


// Lab 6 - 2
/*
public class MainActivity extends AppCompatActivity {

    private EditText inNum, inName;
    private Button btnLoad, btnSave, btnClear;
    private String Num, Name;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inNum = (EditText)findViewById(R.id.inNum);
        inName = (EditText)findViewById(R.id.inName);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = inName.getText().toString();
                Num = inNum.getText().toString();

                sh_Pref = getSharedPreferences("Lab", MODE_PRIVATE);
                toEdit = sh_Pref.edit();
                toEdit.putString("Number", Num);
                toEdit.putString("Name", Name);
                toEdit.commit();
            }
        });

        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh_Pref = getSharedPreferences("Lab", MODE_PRIVATE);
                if (sh_Pref != null && sh_Pref.contains("Name")) {
                    String Name = sh_Pref.getString("Name", "noname");
                    String Num = sh_Pref.getString("Number","noNumber");
                    inNum.setText(Num);
                    inName.setText(Name);
                }
            }
        });

        btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inNum.setText("");
                inName.setText("");
            }
        });
    }
}
*/

// Lab 6 - 1
/*
public class MainActivity extends AppCompatActivity {

    private EditText txtData;
    private Button btnWrite, btnRead, btnClear, btnFinish;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File directory = new File(text+"/");
        directory.mkdirs();

        txtData = (EditText)findViewById(R.id.txtData);
        txtData.setHint("Enter Some lines of data here...");

        btnWrite = (Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = new File(directory, "SDtestFile.txt");
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                    outputStreamWriter.append(txtData.getText());
                    outputStreamWriter.close();
                    Toast.makeText(getApplicationContext(), "Success writing 'SDtestFile.txt'", Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRead = (Button)findViewById(R.id.btnRead);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(directory, "SDtestFile.txt"))));
                    String dataRow = "";
                    String buffer = "";

                    while ((dataRow = bufferedReader.readLine()) != null) {
                        buffer += dataRow + "\n";
                    }
                    txtData.setText(buffer);
                    bufferedReader.close();
                    Toast.makeText(getApplicationContext(), "Success reading 'SDtestFile.txt'", Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtData.setText("");
            }
        });

        btnFinish = (Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
*/

// Video View example.
/*
public class MainActivity extends AppCompatActivity {

    static final String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse(VIDEO_URL));

        Button btnStart = (Button)findViewById(R.id.btnStart);
        Button btnVolume = (Button)findViewById(R.id.btnVolume);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(0);
                videoView.start();
            }
        });

        btnVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioManager audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
                int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI);
            }
        });
    }
}
*/

// Audio Player example.
/*
public class MainActivity extends AppCompatActivity {

    static final String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    private MediaPlayer mediaPlayer;
    private int playbackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnPause = (Button)findViewById(R.id.btnPause);
        Button btnRestart = (Button)findViewById(R.id.btnRestart);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    playAudio(AUDIO_URL);
                    Toast.makeText(getApplicationContext(), "음악 파일 재생 시작됨", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null){
                    playbackPosition = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(), "음악 파일 재생 중지됨", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    mediaPlayer.seekTo(playbackPosition);
                    Toast.makeText(getApplicationContext(), "음악 파일 재생 재시작됨", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void playAudio(String url)throws Exception{
        killMediaPlayer();

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    protected void onDestroy(){
        super.onDestroy();
        killMediaPlayer();
    }

    private void killMediaPlayer(){
        if(mediaPlayer != null){
            try{
                mediaPlayer.release();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
*/

// SQLite database example.
/*
public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);

        insert("User1", 18, "곽민제");
        insert("User2", 22, "이윤호");
        insert("User3", 25, "옥광진");

        update("User1", 52);
        delete("User2");
        select();
    }

    public void insert(String name, int age, String address){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("age",age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void update(String name, int age){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", age);
        db.update("student", values, "name=?", new String[]{name});
    }

    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("db1", name + "정상적으로 삭제되었습니다.");
    }

    public void select(){
        db = helper.getWritableDatabase();
        Cursor cursor = db.query("student", null, null, null, null, null, null);

        while(cursor.moveToNext()){
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            String address = cursor.getString(cursor.getColumnIndex("address"));

            Log.i("db1", "id : "+_id +"\nname : " +name +"\nAge : "+age +"\nAddress : "+address);
        }
    }
}
*/

// Networking example. (Using HTTP request)
/*
public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView txtResponse;
    Handler handler = new Handler();
    public static String defaultUrl = "http://m.naver.com";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        input.setText(defaultUrl);
        txtResponse = (TextView)findViewById(R.id.txtResponse);

        Button btnRequest = (Button)findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUrl = input.getText().toString();

                ConnectThread thread = new ConnectThread(strUrl);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread{
        String strUrl;

        public ConnectThread(String strIn){
            strUrl = strIn;
        }

        public void run(){
            try{
                final String output = request(strUrl);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtResponse.setText(output);
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        }


        private String request(String strUrl){
            StringBuilder output = new StringBuilder();
            try{
                URL url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    int responseCode = conn.getResponseCode();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;

                    while(true){
                        line = reader.readLine();

                        if(line == null)
                            break;

                        output.append(line + "\n");
                    }

                    reader.close();
                    conn.disconnect();
                }
            } catch (Exception e){
                Log.e("Sample HTTP", "Exception in porcessing response.",e);
                e.printStackTrace();
            }
            return output.toString();
        }
    }
}
*/

// Internal storage example.
/*
public class MainActivity extends AppCompatActivity {
    private final static String Notes = "notes.txt";
    private EditText textUIdata;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUIdata = (EditText)findViewById(R.id.textUIdata);
        Button btnClose = (Button)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(Notes,0));
            out.write(textUIdata.getText().toString());
            out.close();
        } catch (Throwable t){
            Toast.makeText(this, "Exception : "+t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            InputStream in = openFileInput(Notes);
            if(in != null){
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";
                StringBuffer buf = new StringBuffer();

                while((str = reader.readLine()) != null)
                    buf.append(str + "\n");

                in.close();
                textUIdata.setText(buf.toString());
            }
        } catch (java.io.FileNotFoundException e){
        } catch (Throwable t){
            Toast.makeText(this, "Exception : " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
*/

// Preference example.
/*
public class MainActivity extends AppCompatActivity {

    Button btnSubmit, btnExit;
    String username, password;
    EditText userInput, passInput;
    SharedPreferences sh_pref;
    SharedPreferences.Editor sh_editor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnExit = findViewById(R.id.btnExit);
        userInput = findViewById(R.id.userInput);
        passInput = findViewById(R.id.passInput);

        btnSubmit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                username = userInput.getText().toString();
                password = passInput.getText().toString();
                sharedPreference();
                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        applySharedPreference();
    }

    public void sharedPreference(){
        sh_pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        sh_editor = sh_pref.edit();
        sh_editor.putString("Username", username);
        sh_editor.putString("Password", password);
        sh_editor.commit();
    }

    public void applySharedPreference(){
        sh_pref = getSharedPreferences("Login Credentials",MODE_PRIVATE);
        if(sh_pref != null && sh_pref.contains("Username")){
            String name = sh_pref.getString("Username","noname");
            userInput.setText(name);
        }
    }
}
*/