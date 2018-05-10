package kwak.forlecture_graphics;

import android.content.Context;
import android.content.res.Resources;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KWAK on 2018-05-07.
 */

public class MyDrawRotate extends View {
    private Paint mPaint;
    private Bitmap mAndroidGreen;
    private Bitmap mAndroidRed;
    private int nangle = 0;

    public void init(){
        mPaint = new Paint();

        Resources res = getResources();
        mAndroidGreen = BitmapFactory.decodeResource(res, R.drawable.android_green);
        mAndroidRed = BitmapFactory.decodeResource(res, R.drawable.android_red);
    }

    public MyDrawRotate(Context context){
        super(context);
        init();
    }

    public MyDrawRotate(Context context, AttributeSet a){
        super(context, a);
        init();
    }

    public boolean onTouchEvent(MotionEvent event){

        //if it's an up ("release") action.
        if(event.getAction() == MotionEvent.ACTION_UP){
            nangle += 5;
            invalidate();
        }

        // indicates that the event was handled.
        return  true;
    }   // end of onTouchEvent.

    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(mAndroidGreen, 0, 0, mPaint);
        canvas.save();

        canvas.rotate(nangle);
        canvas.drawBitmap(mAndroidRed, 0, 0, mPaint);
    }
}
