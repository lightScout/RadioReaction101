package com.lightscout.radioreaction101

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import kotlin.random.Random


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<FrameLayout>(R.id.nav_host_fragment).also {
            it.setOnTouchListener(object : OnTouchListener {
                override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
                    if (event?.action == MotionEvent.ACTION_DOWN) {
                        Toast.makeText(
                            this@MainActivity,
                            "Touch coordinates : " + event.x.toString() + "x" + event.y.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        animateView(it, event.x, event.y)

//                        p0?.background?.setHotspot(event.x, event.y);
                    }
                    return false
                }

            })
        }


    }

    private fun animateView(view: View, pivotX: Float, pivotY: Float) {

        view.animate()
            .alpha(1f)
            .setDuration(235)
            .setListener(null)

//        view.pivotX = pivotX
//        view.pivotY = pivotY
//        getSpringAnimation(view, SpringAnimation.SCALE_X, 1F).start()
//        getSpringAnimation(view, SpringAnimation.SCALE_Y, 1F).start()

//        Random.nextInt(0, 3).also {
//            when(it){
//                0 -> {
//                    val blueFragment = BlueFragment()
//                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(
//                            android.R.anim.fade_in,
//                            android.R.anim.fade_out,
//                            android.R.anim.fade_in,
//                            android.R.anim.fade_out
//                        ).add(R.id.main_frame, blueFragment)
//                        .addToBackStack(blueFragment.tag)
//                        .commit()
//                }
//               1 -> {
//                   val greenFragment = GreenFragment()
//                   supportFragmentManager.beginTransaction()
//                       .setCustomAnimations(
//                           android.R.anim.fade_in,
//                           android.R.anim.fade_out,
//                           android.R.anim.fade_in,
//                           android.R.anim.fade_out
//                       ).replace(R.id.main_frame, greenFragment)
//                       .addToBackStack(greenFragment.tag)
//                       .commit()
//               }
//                2 -> {
//                    val redFragment = RedFragment()
//                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(
//                            android.R.anim.fade_in,
//                            android.R.anim.fade_out,
//                            android.R.anim.fade_in,
//                            android.R.anim.fade_out
//                        ).replace(R.id.main_frame, redFragment)
//                        .addToBackStack(redFragment.tag)
//                        .commit()
//                }
//            }
//        }


//        view.visibility = View.GONE

//        val from = ContextCompat.getColor(this, R.color.black);
//        val  to   = ContextCompat.getColor(this, R.color.white);
//        val anim = ValueAnimator()
//        anim.setIntValues(from, to)
//        anim.setEvaluator(ArgbEvaluator())
//        anim.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
//            override fun onAnimationUpdate(p0: ValueAnimator?) {
//                Log.d("TAG_J", "onAnimationUpdate: ${p0?.animatedValue}")
//                view.background.setTint(resources.getColor(R.color.purple_700))
//            }
//        })
//        anim.duration = 1000
//        anim.start()


    }

    fun getSpringAnimation(
        view: View,
        springAnimationType: FloatPropertyCompat<View>,
        finalPosition: Float
    ): SpringAnimation {
        return SpringAnimation(view, springAnimationType).setStartValue(0F).also {
            val spring = SpringForce()
            spring.finalPosition = finalPosition
            spring.stiffness = SpringForce.STIFFNESS_VERY_LOW // optional
            spring.dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY // optional
            it.spring = spring
        }


    }

}