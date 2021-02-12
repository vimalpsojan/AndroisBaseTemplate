package com.vimal.sample.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.vimal.core.ktx.FragmentKtx.viewBinding
import com.vimal.core.ui.BaseFragment
import com.vimal.core.ui.ToolbarProvider
import com.vimal.sample.R
import com.vimal.sample.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}