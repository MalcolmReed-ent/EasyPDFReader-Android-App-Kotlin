package com.easypdfreader

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easypdfreader.databinding.RowItemPdfBinding

class PdfListAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<PdfListAdapter.PdfViewHolder>() {

    private var pdfList: List<Pair<Uri, String>> = listOf()

    inner class PdfViewHolder(private val binding: RowItemPdfBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.card.setOnClickListener { clickListener.itemClicked(adapterPosition) }
        }

        fun bind(pdf: Pair<Uri, String>) {
            binding.tvPdfName.text = pdf.second
        }
    }

    fun setPdfsToList(pdfList: List<Pair<Uri, String>>) {
        this.pdfList = pdfList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
        val binding = RowItemPdfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PdfViewHolder(binding)
    }

    override fun getItemCount(): Int = pdfList.size

    override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
        holder.bind(pdfList[position])
    }

    fun getPdfAt(position: Int): Pair<Uri, String> = pdfList[position]

    interface ClickListener {
        fun itemClicked(position: Int)
    }
}
