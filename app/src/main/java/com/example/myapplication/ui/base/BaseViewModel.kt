package com.example.myapplication.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commom.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    private val events = SingleLiveEvent<Event>()
    val observableEvents: LiveData<Event> = events

    interface Event

    fun postEventToView(event: Event) {
        viewModelScope.launch(Dispatchers.Main) {
            events.value = event
        }
    }
}
