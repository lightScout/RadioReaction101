package com.lightscout.radioreaction101

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import kotlin.math.hypot

class GreenFragment : Fragment(R.layout.green_fragment_layout) {

    val args: GreenFragmentArgs by navArgs()

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d("TAG_J", "GreenF: pivot points of touch - pX = ${args.pivotPoints[0]} pY = ${args.pivotPoints[1]} ")
//        view.pivotX = args.pivotPoints[0]
//        view.pivotY = args.pivotPoints[1]
//        getSpringAnimation(view, SpringAnimation.SCALE_Y, 1F).start()
//        getSpringAnimation(view, SpringAnimation.SCALE_X, 1F).start()


        val cx = args.pivotPoints?.get(0)
        val cy = args.pivotPoints?.get(1)
        if (cx != null && cy != null) {
            createCircularRevealAnim(view, cx, cy, 0f)
        }
        view.setOnTouchListener { view, motionEvent ->
            val options = navOptions {
                anim {
                    exit = R.anim.gone
                }
            }
            view.findNavController().navigate(
                GreenFragmentDirections.actionGreenFragmentToRedFragment2()
                    .setPivotPoints(floatArrayOf(motionEvent.x, motionEvent.y)), options
            )

            false
        }

    }

    fun createCircularRevealAnim(view: View, cx: Float, cy: Float, startRadius: Float) {

        // get the final radius of the clipping circle
        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

        // create the animator for this view (the start radius is zero)
        val anim = ViewAnimationUtils.createCircularReveal(
            view,
            cx.toInt(),
            cy.toInt(),
            startRadius,
            finalRadius
        )
//        view.visibility = View.VISIBLE
//        Log.d("TAG_J", "on click: ${ view.visibility } ")

        anim.start()

    }
}