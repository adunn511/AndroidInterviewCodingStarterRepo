package com.libertymutual.android.interview.ui.datelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.libertymutual.android.interview.data.DateItem
import com.libertymutual.android.interview.repository.EpicAPIImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DateListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UIState(dateItems = emptyList()))
    val uiState: StateFlow<UIState> =_uiState
    private val epicAPI = EpicAPIImpl()

    fun onViewCreated() {
        getDates()
    }

    private fun getDates() = viewModelScope.launch {
        val response = epicAPI.getAllDates()
        if (response.isSuccessful) {
            val data = response.body() ?: emptyArray()
            _uiState.update { it.copy(dateItems = data.map { rawDate -> DateItem(rawDate.date) }) }
        }
    }
}

data class UIState (
    val dateItems: List<DateItem>
)