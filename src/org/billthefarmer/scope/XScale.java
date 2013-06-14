package org.billthefarmer.scope;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;

public class XScale extends View
{
	private static final int SIZE = 20;

    private int width;
    private int height;

    private Paint paint;

	public XScale(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub

		paint = new Paint();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int w = MeasureSpec.getSize(widthMeasureSpec);

		setMeasuredDimension(w, w / 32);
	}

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
	super.onSizeChanged(w, h, oldw, oldh);

	width = w;
	height = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
    	paint.setStrokeWidth(2);

    	for (int i = 0; i < width; i += SIZE)
    		canvas.drawLine(i, 0, i, height / 4, paint);

    	for (int i = 0; i < width; i += SIZE * 5)
    		canvas.drawLine(i, 0, i, height / 2, paint);

    	paint.setAntiAlias(true);
    	paint.setTextSize(height / 2);
    	paint.setTextAlign(Align.CENTER);
    	canvas.drawText("ms", 0, height - (height / 8), paint);
    }

}
