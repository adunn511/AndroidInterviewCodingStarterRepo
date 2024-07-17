package com.libertymutual.android.interview.ui.datelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.libertymutual.android.interview.data.DateItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DateListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UIState(dateItems = emptyList()))
    val uiState: StateFlow<UIState> =_uiState

    fun onViewCreated() {
        setupMockDataForList()
    }

    private fun setupMockDataForList() {
        val mockDates = listOf("1/1/2022", "1/2/2022", "1/3/2022", "1/4/2022")
        val mockDateItems = mockDates.map { date -> DateItem(date) }
        _uiState.update { it.copy(dateItems = mockDateItems) }
    }
}

data class UIState (
    val dateItems: List<DateItem>
)