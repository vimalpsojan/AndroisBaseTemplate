package com.vimal.core.ktx

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.vimal.core.utils.FragmentViewBindingDelegate

object FragmentKtx {

    //Fragment Binging
    fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) = FragmentViewBindingDelegate(this, viewBindingFactory)
}