package com.lightscout.radioreaction101

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class RedFragment : Fragment(R.layout.red_fragment_layout) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnTouchListener { view, motionEvent ->


            Log.d("TAG_J", "onViewCreated: ")

            val options = navOptions {
                anim {
                    enter = R.anim.appear
                    exit = R.anim.gone
                    popEnter = R.animator.nav_default_pop_enter_anim
                    popExit = R.animator.nav_default_pop_exit_anim
                }
            }
            Log.d("TAG_J", "RedF: pivot points of touch - pX = ${motionEvent.x} pY = ${motionEvent.y} ")
            val action = RedFragmentDirections.actionRedFragmentToGreenFragment(floatArrayOf(motionEvent.x, motionEvent.y))
            view.findNavController().navigate(action)
            false
        }
    }


//            getSpringAnimation(it, SpringAnimation.SCALE_Y, 0F).start()
//            getSpringAnimation(it, SpringAnimation.SCALE_X, 0F).start().also {
//
//
//
//            }

    }



    private fun getSpringAnimation(
        view: View,
        springAnimationType: FloatPropertyCompat<View>,
        finalPosition: Float
    ): SpringAnimation {
        return SpringAnimation(view, springAnimationType).setStartValue(1F).also {
            val spring = SpringForce()
            spring.finalPosition = finalPosition
            spring.stiffness = SpringForce.STIFFNESS_VERY_LOW // optional
            spring.dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY // optional
            it.spring = spring
        }


    }