package com.lightscout.radioreaction101

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Explode
import android.util.Log
import android.view.*
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import kotlin.math.hypot

class RedFragment : Fragment(R.layout.red_fragment_layout) {

    val args: RedFragmentArgs by navArgs()

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
//
            val action = RedFragmentDirections.actionRedFragmentToGreenFragment().setPivotPoints(
                floatArrayOf(
                    motionEvent.x,
                    motionEvent.y
                )
            )
            if (view.findNavController().currentDestination?.id == R.id.redFragment) {
                view.findNavController().navigate(action, options)
            }

//            Log.d("TAG_J", "nav_controller id : ${} / ${}")
            false
        }
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