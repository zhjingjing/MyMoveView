package com.mymoveview;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * view的移动
 * */
public class MainActivity extends Activity implements View.OnTouchListener {

    private RelativeLayout activityMain;
    private LinearLayout moveview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        activityMain.setOnTouchListener(this);
    }

    private void initView() {
        activityMain = (RelativeLayout) findViewById(R.id.activity_main);
        moveview = (LinearLayout) findViewById(R.id.moveview);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:

            break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:
                moveViewByLayout(moveview,(int)motionEvent.getRawX(),(int)motionEvent.getRawY());
                break;

        }
        return true;
    }

    /**
     * 通过layout方法，移动view
     * 优点：对view所在的布局，要求不苛刻，不要是RelativeLayout，而且可以修改view的大小
     *
     * @param view
     * @param rawX
     * @param rawY
     */
    private void moveViewByLayout(View view, int rawX, int rawY) {
//        int left = rawX - moveview.getWidth() / 2;
//        int width = left + view.getWidth();
        int top = rawY - moveview.getHeight() / 2;
        int height = top + view.getHeight();

        //限定移动的范围
        if (top<500){
            top=500;
            height=500+view.getHeight();
        }
        view.layout(0, top, view.getWidth(), height);
    }

}
