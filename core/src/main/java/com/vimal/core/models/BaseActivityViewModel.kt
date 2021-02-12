package com.vimal.core.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vimal.core.viewmodel.BaseViewModel

class BaseActivityViewModel : BaseViewModel() {

    private val actionPerformedLiveData = MutableLiveData<Event<Action>>()
    val actionPerformed: LiveData<Event<Action>> = actionPerformedLiveData

    fun actionPerformed(actions: Action) {
        actionPerformedLiveData.value = Event(actions)
    }
}