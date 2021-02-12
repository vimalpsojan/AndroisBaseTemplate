package com.vimal.sample.base

import android.content.Intent
import com.vimal.core.R
import com.vimal.core.constants.Actions
import com.vimal.core.models.Action
import com.vimal.core.models.Error
import com.vimal.core.models.MessageData
import com.vimal.core.viewmodel.BaseViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.addTo

/**
 * Project Specific base View Model
 */
abstract class SampleViewModel: BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.add(): Disposable = apply { addTo(compositeDisposable) }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun showNetworkError(
        positiveButton: Int = R.string.retry,
        negativeButton: Int? = null,
        canDismiss: Boolean = true,
        triggerActionOnDismiss: Boolean = true,
        negativeAction: (() -> Unit)? = null,
        retryAction: () -> Unit
    ) {
        hideLoading()
        val messageData = MessageData()
        messageData.titleRes = R.string.fail
        messageData.messageRes = R.string.net_work_error
        messageData.positiveButtonRes = positiveButton
        messageData.negativeButtonRes = negativeButton
        messageData.canDismiss = canDismiss
        messageData.triggerActionOnDismiss = triggerActionOnDismiss
        messageData.negativeAction = negativeAction
        messageData.positiveAction = retryAction
        showInfoMessage(messageData)
    }

    fun Error.showErrorDialogue(
        titleStr: String? = null,
        titleRes: Int? = null,
        positiveButton: String? = null,
        negativeButton: String? = null,
        negativeAction: (() -> Unit)? = null,
        showUnAuth: Boolean = true,
        canDismiss: Boolean = true,
        triggerActionOnDismiss: Boolean = true,
        positiveButtonRes: Int? = null,
        negativeButtonRes: Int? = null,
        positiveAction: () -> Unit = {}
    ) {
        if (this.errorCode == 403 && !showUnAuth) {
            return
        }
        if (this.errorCode == 403) {
            showSessionExpire()
            return
        }
        hideLoading()
        val messageData = MessageData()
        messageData.titleStr = titleStr
        messageData.titleRes = titleRes ?: R.string.error_title
        messageData.messageRes = R.string.net_work_error
        messageData.messageStr = message
        messageData.positiveButtonRes = positiveButtonRes ?: R.string.retry
        messageData.positiveButtonStr = positiveButton
        messageData.positiveAction = positiveAction
        messageData.negativeButtonStr = negativeButton
        messageData.negativeButtonRes = negativeButtonRes
        messageData.negativeAction = negativeAction
        messageData.canDismiss = canDismiss
        messageData.triggerActionOnDismiss = triggerActionOnDismiss
        showInfoMessage(messageData)
    }

    private fun Error.showSessionExpire() {
        val messageData = MessageData()
        messageData.titleRes = R.string.session_expired_title
        messageData.messageRes = R.string.session_expired
        messageData.messageStr = message
        messageData.triggerActionOnDismiss = true
        messageData.positiveButtonRes = R.string.ok
        messageData.positiveAction = {
            performAction(Action(Intent(Actions.ACTION_LOGOUT)))
        }
        showInfoMessage(messageData)
    }
}