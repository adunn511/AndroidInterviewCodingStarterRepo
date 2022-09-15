package com.libertymutual.android.interview.ui.datelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.libertymutual.android.interview.data.DateItem
import com.libertymutual.android.interview.repository.EpicAPIImpl
import kotlinx.coroutines.launch

class DateListViewModel : ViewModel() {
    val dateItems = MutableLiveData<List<DateItem>>()
    private val epicAPI = EpicAPIImpl()

    fun onViewCreated() {
        getDates()
    }

    private fun getDates() = viewModelScope.launch {
        val response = epicAPI.getAllDates()
        if (response.isSuccessful) {
            val data = response.body()
            dateItems.value = data?.map { rawDate -> DateItem(rawDate.date) }
        }
    }
}