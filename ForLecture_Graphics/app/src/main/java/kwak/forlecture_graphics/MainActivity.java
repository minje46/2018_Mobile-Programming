package kwak.forlecture_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;









// Lab 4 - 1
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyCanvas myView = new MyCanvas(this);
        setContentView(myView);
    }
}

class MyCanvas extends View{

    Paint paint = new Paint();
    Path path = new Path();

    public MyCanvas(Context context){
        super(context);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(final Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE :
                path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP :
                break;
        }
        invalidate();
        return true;
    }
}
*/

// Lab 4 - 2
/**/
public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout, slideLayout;
    Button btnOpen, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = findViewById(R.id.baseLayout);
        slideLayout = findViewById(R.id.slideLayout);
        btnOpen = findViewById(R.id.btnOpen);
        btnClose = findViewById(R.id.btnClose);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                slideLayout.startAnimation(anim);
                slideLayout.setVisibility(View.VISIBLE);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);
                slideLayout.startAnimation(anim);
                slideLayout.setVisibility(View.INVISIBLE);
            }
        });
    }
}









// Animation example.
/*
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editText;
    Button btnTranslation;
    Button btnScale;
    Button btnRotate;
    Button btnTransparate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView1);
        editText = (EditText)findViewById(R.id.editText);
        btnTranslation = (Button)findViewById(R.id.btnTranslation);
        btnTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Translation animation 이용.
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                imageView.startAnimation(anim);
                editText.append("Translate animation is started. \n");
            }
        });

        btnScale = (Button)findViewById(R.id.btnScale);
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Scale animation 이용.
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                imageView.startAnimation(anim);
                editText.append("Scale Animation is started. \n");
            }
        });

        btnRotate = (Button)findViewById(R.id.btnRotate);
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rotation animation 이용.
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                imageView.startAnimation(anim);
                editText.append("Rotate Animation is started. \n");
            }
        });

        btnTransparate = (Button)findViewById(R.id.btnTransparent);
        btnTransparate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tranparent animation 이용.
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.transparent);
                imageView.startAnimation(anim);
                editText.append("Transparent Animation is started. \n");
            }
        });
    }
}
*/

// Draw Rotate example.
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // java class 를 xml 에 구현

 //       MyDrawRotate mdr = new MyDrawRotate(getApplicationContext());
  //      setContentView(mdr);
    }
}
*/

// bitmap 부분 자르기 example
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // java class 를 xml 에 구현
        MyDrawEx mvx = new MyDrawEx(getApplicationContext());
        setContentView(mvx);

    }
}
*/

// Layer & Transition & State List example.
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton)findViewById(R.id.btnTransition);
        TransitionDrawable drawable = (TransitionDrawable)button.getDrawable();
        drawable.startTransition(5000);
    }
}
*/


// bitmap example
/*
public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLinearLayout = new LinearLayout(this);

        ImageView img = new ImageView(this);
        Drawable myImage = getResources().getDrawable(R.drawable.android_blue);
        img.setImageDrawable(myImage);

        img.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT));

        mLinearLayout.addView(img);
        setContentView(mLinearLayout);
    }
}
*/


/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // Java class 내부에서 custom view 작성
//        MyView vw = new MyView(this);
//        setContentView(vw);

        // java class 를 xml 에 구현
//        MyDraw mv = new MyDraw(getApplicationContext());
//        setContentView(mv);

    }

    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }*/
        // Circle, Rectangle example
        /*
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);
            canvas.drawColor(Color.RED);
//            canvas.drawCircle(200,700,150, pnt);
            canvas.drawRect(100,100,200,200,pnt);
        }*/
        // Fill & Circle example
        /*
        @Override
        protected void onDraw(Canvas canvas){
            Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

            pnt.setStrokeWidth(8);
            pnt.setColor(Color.RED);

            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,50,40,pnt);

            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,50,40,pnt);

            pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250,50,40,pnt);

            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,150,40, pnt);
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50,150,40,pnt);

            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,150,40, pnt);
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150,150,40,pnt);
        }*/

        // Cap, Join Example
        /*
        @Override
        protected void onDraw(Canvas canvas) {
            Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(16);

            canvas.drawLine(50,30,240,30, pnt);
            pnt.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50,60,240,60, pnt);
            pnt.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50,90,240,90,pnt);

            pnt.setColor(Color.BLACK);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);
            pnt.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50,150,90,200, pnt);
            pnt.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120,150,160,200, pnt);
            pnt.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190,150,230,200, pnt);
        }*/

        // Path example
        /*
        @Override
        protected void onDraw(Canvas canvas) {
            Path path = new Path();
            canvas.drawColor(Color.WHITE);
            Paint pnt = new Paint();
            pnt.setStrokeWidth(5);
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);

            path.addRect(100, 00, 150, 90, Path.Direction.CW);
            path.addCircle(50, 50, 40, Path.Direction.CW);
            canvas.drawPath(path, pnt);

            path.reset();
            path.moveTo(10, 110);
            path.lineTo(50, 150);
            path.lineTo(400, 10);
            pnt.setStrokeWidth(3);
            pnt.setColor(Color.BLUE);
            canvas.drawPath(path, pnt);

            pnt.setTextSize(20);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text on Path.", path, 0, 0, pnt);
        }*/
//    }
//}