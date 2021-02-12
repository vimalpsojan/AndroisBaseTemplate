package com.vimal.core.models

import android.content.Context
import androidx.annotation.StringRes

open class MessageData(var context: Context? = null) {

    var titleStr: String? = null
    var messageStr: String? = null
    var positiveButtonStr: String? = null
    var negativeButtonStr: String? = null
    var neutralButtonStr: String? = null

    @StringRes
    var titleRes: Int? = null

    @StringRes
    var messageRes: Int? = null

    @StringRes
    var positiveButtonRes: Int? = null

    @StringRes
    var negativeButtonRes: Int? = null

    @StringRes
    var neutralButtonRes: Int? = null

    var positiveAction: (() -> Unit)? = null
    var negativeAction: (() -> Unit)? = null
    var triggerActionOnDismiss: Boolean = false
    var canDismiss: Boolean = true

    fun getTitle(): String? {
        return if (titleStr == null) {
            getFromResource(titleRes)
        } else
            titleStr
    }

    fun getMessage(): String? {
        return if (messageStr == null) {
            getFromResource(messageRes)
        } else
            messageStr
    }

    fun getPositiveButton(): String? {
        return if (positiveButtonStr == null) {
            getFromResource(positiveButtonRes)
        } else
            positiveButtonStr
    }

    fun getNegativeButton(): String? {
        return if (negativeButtonStr == null) {
            getFromResource(negativeButtonRes)
        } else
            negativeButtonStr
    }

    fun getNeutralButton(): String? {
        return if (neutralButtonStr == null) {
            getFromResource(neutralButtonRes)
        } else
            neutralButtonStr
    }

    private fun getFromResource(@StringRes res: Int?): String? {
        if (res == null)
            return null
        return context?.getString(res)
    }
}