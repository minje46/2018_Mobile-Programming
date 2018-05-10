package kwak.forlecture_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by KWAK on 2018-04-30.
 */

public class MyDraw extends View{
    public MyDraw(Context c){
        super(c);
    }
    public MyDraw(Context c, AttributeSet a){
        super(c, a);
    }

    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawColor(Color.WHITE);
        for(int x= 0; x < 200; x+=5)
            canvas.drawLine(x,0,200-x,100, paint);
    }
}
