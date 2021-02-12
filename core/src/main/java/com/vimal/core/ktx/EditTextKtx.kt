package com.vimal.core.ktx

import android.widget.EditText
import androidx.databinding.BindingAdapter

object EditTextKtx {
    @BindingAdapter("errorText")
    @JvmStatic
    fun setError(view: EditText, errorMessage: String?) {
        view.error = errorMessage
    }
}