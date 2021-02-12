package com.vimal.sample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException

@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        setupRx()
    }

    /**
     * to avoid errors due to dispose call
     */
    private fun setupRx() {
        RxJavaPlugins.setErrorHandler {
            val e = if (it is UndeliverableException) {
                it.cause
            } else it

            when (e) {
                is IOException, is SocketException -> {
                    // fine, irrelevant network problem or API that throws on cancellation
                }
                is InterruptedException -> {
                    // fine, some blocking code was interrupted by a dispose call
                }
                is NullPointerException, is IllegalArgumentException -> {
                    // that's likely a bug in the application
                    Thread.currentThread().uncaughtExceptionHandler?.uncaughtException(
                        Thread.currentThread(),
                        e
                    )
                }
                is IllegalStateException -> {
                    // that's a bug in RxJava or in a custom operator
                    Thread.currentThread().uncaughtExceptionHandler?.uncaughtException(
                        Thread.currentThread(),
                        e
                    )
                }
            }
        }
    }
}