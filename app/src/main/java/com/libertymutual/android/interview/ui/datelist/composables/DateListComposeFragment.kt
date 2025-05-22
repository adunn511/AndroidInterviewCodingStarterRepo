package com.libertymutual.android.interview.ui.datelist.composables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.libertymutual.android.interview.data.DateItem
import com.libertymutual.android.interview.ui.datelist.DateListViewModel
import com.libertymutual.android.interview.ui.datelist.UIState

class DateListComposeFragment: Fragment() {
    companion object {
        fun newInstance() = DateListComposeFragment()
    }

    private lateinit var viewModel: DateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                DateListScreen(uiState)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DateListViewModel::class.java]
        viewModel.onViewCreated()
    }
}

@Composable
private fun DateListScreen(uiState: UIState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // .verticalScroll(rememberScrollState())
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(uiState.dateItems.size) { index ->
                DateListItem(dateItem = uiState.dateItems[index], onClick = { })
            }
        }
    }
}

@Composable
fun DateListItem(dateItem: DateItem, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = dateItem.stringDate,
            modifier = Modifier
                .align(androidx.compose.ui.Alignment.CenterStart)
                .padding(start = 16.dp)
        )
        Divider(
            color = androidx.compose.ui.graphics.Color.Black,
            modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter)
        )
    }
}
