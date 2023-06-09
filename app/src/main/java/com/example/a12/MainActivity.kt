package com.example.a12

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.OnDoubleTapListener
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.TextView


class MainActivity : AppCompatActivity(),GestureDetector.OnGestureListener{

    lateinit var txv:TextView
    lateinit var gDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txv = findViewById(R.id.txv)
        txv.setTextColor(Color.parseColor("#eeee00"))
        txv.setBackgroundColor(Color.BLUE)
        txv.setTypeface(Typeface.createFromAsset(assets, "font/HanyiSentyBrushSong.ttf"))
        txv.getBackground().setAlpha(50) //0~255透明度值
        gDetector = GestureDetector(this,this)
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }
    override fun onDown(p0: MotionEvent): Boolean {
        txv.text = "按下"
        return true
    }
    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        txv.text = "短按"
        return true
    }
    override fun onLongPress(p0: MotionEvent?) {
        txv.text = "長按"
    }
    override fun onShowPress(p0: MotionEvent?) {
        txv.text = "按下後無後續動作"
    }
    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        txv.text = "拖曳"
        return true
    }

    override fun onLongPress(p0: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        txv.text = "快滑"
        return true
    }
    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        if (distanceY >= 0){
            txv.text = "向上拖曳"
        }
        else{
            txv.text = "向下拖曳"
        }
        return true
    }
    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x <= e2.x){
            txv.text = "往右快滑"
        }
        else{
            txv.text = "往左快滑"
        }
        return true
    }
}