package com.jnetai.phdresearch.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnetai.phdresearch.databinding.ItemMainBinding
import com.jnetai.phdresearch.model.Paper

class PaperAdapter(private val onClick: (Paper) -> Unit) : RecyclerView.Adapter<PaperAdapter.VH>() {
    var items: List<Paper> = emptyList()
    inner class VH(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = items[pos]
        h.binding.titleText.text = item.title
        h.binding.subtitleText.text = item.authors.ifEmpty { "No authors" } + " · " + item.status
        h.binding.root.setOnClickListener { onClick(item) }
    }
}