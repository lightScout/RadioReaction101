package com.lightscout.radioreaction101

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions

class GreenFragment : Fragment(R.layout.green_fragment_layout) {

    val args: GreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG_J", "GreenF: pivot points of touch - pX = ${args.pivotPoints[0]} pY = ${args.pivotPoints[1]} ")
        view.pivotX = args.pivotPoints[0]
        view.pivotY = args.pivotPoints[1]
        getSpringAnimation(view, SpringAnimation.SCALE_Y, 1F).start()
        getSpringAnimation(view, SpringAnimation.SCALE_X, 1F).start()

        view.setOnClickListener {
            val options = navOptions {
                anim {
                    enter = R.anim.appear
                    exit = R.anim.gone
                    popEnter = R.animator.nav_default_pop_enter_anim
                    popExit = R.animator.nav_default_pop_exit_anim
                }
            }
            view.findNavController().navigate(R.id.redFragment, null, options)
        }


    }

    private fun getSpringAnimation(
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