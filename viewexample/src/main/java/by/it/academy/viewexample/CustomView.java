package by.it.academy.viewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    interface OnCustomViewActionListener {
        void onActionDown(float x, float y);
    }

    private int centerX;
    private int centerY;

    private int rectLeft;
    private int rectRight;
    private int rectTop;
    private int rectBottom;

    private int sideSize;

    private OnCustomViewActionListener onCustomViewActionListener;

    private Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        try {
            TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.CustomView);
            sideSize = (int) typedArray.getDimension(R.styleable.CustomView_rectangleDefaultSize, .0f);
            paint.setColor(typedArray.getColor(R.styleable.CustomView_rectangleColor, Color.RED));
            typedArray.recycle();
        } catch (Exception e) {

        }

    }

    public void setOnCustomViewActionListener(OnCustomViewActionListener onCustomViewActionListener) {
        this.onCustomViewActionListener = onCustomViewActionListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            if (onCustomViewActionListener != null) {
                onCustomViewActionListener.onActionDown(x, y);
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        centerX = viewWidth / 2;
        centerY = viewHeight / 2;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        calculateCoords();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);
        super.onDraw(canvas);
    }

    public void updateViewRectangle(int sideSize) {
        this.sideSize = sideSize;
        calculateCoords();
        invalidate();
    }

    private void calculateCoords() {
        rectLeft = centerX - sideSize / 2;
        rectRight = centerX + sideSize / 2;
        rectTop = centerY - sideSize / 2;
        rectBottom = centerY + sideSize / 2;
    }
}
