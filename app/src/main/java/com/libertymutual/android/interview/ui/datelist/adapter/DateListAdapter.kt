package com.libertymutual.android.interview.ui.datelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libertymutual.android.interview.data.DateItem
import com.libertymutual.android.interview.databinding.ListItemDateBinding

class DateListAdapter :
    ListAdapter<DateItem, DateListViewHolder>(DateListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder =
        DateListViewHolder.from(parent)

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {
        val dateItem = getItem(position)
        holder.bind(dateItem)
    }

    override fun getItemCount(): Int = currentList.size
}

class DateListViewHolder(private val binding: ListItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dateItem: DateItem) {
        binding.dateItem = dateItem
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): DateListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemDateBinding.inflate(layoutInflater, parent, false)
            return DateListViewHolder(binding)
        }
    }

}

private class DateListDiffCallback : DiffUtil.ItemCallback<DateItem>() {
    override fun areContentsTheSame(oldItem: DateItem, newItem: DateItem): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: DateItem, newItem: DateItem): Boolean =
        oldItem.stringDate == newItem.stringDate

}