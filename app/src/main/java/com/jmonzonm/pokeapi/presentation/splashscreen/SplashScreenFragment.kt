package com.jmonzonm.pokeapi.presentation.splashscreen

import android.animation.Animator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jmonzonm.pokeapi.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            animationSplash
            animationSplash.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    Handler().postDelayed({
                        navigateToHome()
                    }, 2000)
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }
            })
        }
    }

    fun navigateToHome() {
        findNavController().navigate(
            SplashScreenFragmentDirections.actionFromSplashscreenToHomefragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}