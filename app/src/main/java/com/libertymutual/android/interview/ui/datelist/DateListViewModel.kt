package com.libertymutual.android.interview.ui.datelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.libertymutual.android.interview.data.DateItem

class DateListViewModel : ViewModel() {
    val dateItems = MutableLiveData<List<DateItem>>()

    fun onViewCreated() {
        setupMockDataForList()
    }

    private fun setupMockDataForList() {
        val mockDates = listOf("1/1/2022", "1/2/2022", "1/3/2022", "1/4/2022")
        val mockDateItems = mockDates.map { date -> DateItem(date) }
        dateItems.value = mockDateItems
    }
}