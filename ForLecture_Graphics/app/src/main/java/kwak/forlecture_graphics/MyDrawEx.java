package kwak.forlecture_graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by KWAK on 2018-05-07.
 */

public class MyDrawEx extends View {

    public MyDrawEx(Context context){
        super(context);
    }

    public MyDrawEx(Context context, AttributeSet a){
        super(context, a);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Bitmap sm = BitmapFactory.decodeResource(getResources(), R.drawable.image02);

        Paint paint = new Paint();
        canvas.drawColor(Color.WHITE);

        // example 1.
//        Bitmap bitmap2 = Bitmap.createBitmap(sm, 0, 0, sm.getWidth()-100, sm.getHeight()-100);
//        canvas.drawBitmap(bitmap2,0,0,paint);

        // example 2.
        canvas.drawBitmap(sm, new Rect(100, 0, 500, 500), new Rect(0, 0, 400, 500), paint);
    }
}
