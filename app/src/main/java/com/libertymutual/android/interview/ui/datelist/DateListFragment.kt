package com.libertymutual.android.interview.ui.datelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.libertymutual.android.interview.R
import com.libertymutual.android.interview.databinding.FragmentDateListBinding
import com.libertymutual.android.interview.ui.datelist.adapter.DateListAdapter
import kotlinx.coroutines.launch

class DateListFragment : Fragment() {

    companion object {
        fun newInstance() = DateListFragment()
    }

    private var _binding: FragmentDateListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DateListViewModel

    private val dateListAdapter = DateListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding =  FragmentDateListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DateListViewModel::class.java]
        configureRecyclerView()
        viewModel.onViewCreated()
    }

    private fun configureRecyclerView() {
        binding.dateListRecyclerView.apply {
            adapter = dateListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        lifecycleScope.launch {
            viewModel.uiState.collect {
                dateListAdapter.submitList(it.dateItems)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}