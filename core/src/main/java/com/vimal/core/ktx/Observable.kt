package com.vimal.core.ktx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

object Observable {
    fun <T> Observable<T>.applyNetworkSchedulers(): Observable<T> {
        return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> Single<T>.applyNetworkSchedulers(): Single<T> {
        return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> Observable<T>.applyRoomSchedulers(): Observable<T> {
        return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> Single<T>.applyRoomSchedulers(): Single<T> {
        return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> Flowable<T>.applyRoomSchedulers(): Flowable<T> {
        return observeOn(AndroidSchedulers.mainThread())
    }
}