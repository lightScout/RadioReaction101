package com.lightscout.radioreaction101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.google.android.material.button.MaterialButton
import java.time.Duration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var infoCardView = findViewById<CardView>(R.id.info_cardView).also {
            it.alpha = 0F
            it.visibility = View.VISIBLE
        }

        findViewById<MaterialButton>(R.id.ripple_button).setOnClickListener {
            animateView(infoCardView)
        }


    }

    private fun animateView(view: View) {

        view.animate()
            .alpha(1f)
            .setDuration(235)
            .setListener(null)

        view.pivotX = 0F
        view.pivotY = 0F
        getSpringAnimation(view, SpringAnimation.SCALE_X, 1F).start()
        getSpringAnimation(view, SpringAnimation.SCALE_Y, 1F).start()


    }

    fun getSpringAnimation(
        view: View,
        springAnimationType: FloatPropertyCompat<View>,
        finalPosition: Float
    ): SpringAnimation {
        return SpringAnimation(view, springAnimationType).setStartValue(0F).also {
            val spring = SpringForce()
            spring.finalPosition = finalPosition
            spring.stiffness = SpringForce.STIFFNESS_LOW // optional
            spring.dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY // optional
            it.spring = spring

        }


    }

}