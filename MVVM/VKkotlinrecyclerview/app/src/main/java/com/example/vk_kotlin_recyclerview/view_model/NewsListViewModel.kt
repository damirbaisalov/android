package com.example.vk_kotlin_recyclerview.view_model

import android.content.Context
import android.provider.ContactsContract
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vk_kotlin_recyclerview.model.Database
import com.example.vk_kotlin_recyclerview.model.News
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NewsListViewModel(private val context: Context
): ViewModel() , CoroutineScope {

    var dataNews: List<News>?=null

    private val job = Job()
     val liveData = MutableLiveData<State>()

     init {
         dataNews = Database.newsBIG
     }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun getNews(){
        launch {
            liveData.value = State.ShowLoading
            val list = withContext(Dispatchers.IO) {
                var response = emptyList<News>()
                if (response.isEmpty()){
                    response  = dataNews!!
                }
                response
            }
            liveData.value = State.HideLoading
            liveData.value = State.Result(list)
        }
    }

    sealed class State {
        object ShowLoading : State()
        object HideLoading : State()
        data class Result(val list: List<News>) : State()
    }

}