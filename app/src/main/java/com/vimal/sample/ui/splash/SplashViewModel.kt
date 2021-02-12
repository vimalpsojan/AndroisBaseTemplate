package com.vimal.sample.ui.splash

import com.vimal.sample.R
import com.vimal.sample.base.SampleViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashViewModel : SampleViewModel(){

    init {
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                gotoNextScreen()
            }
    }

    private fun gotoNextScreen() {
//        navigate(R.id.action_splashFragment_to_dashBoardFragment)
    }

}