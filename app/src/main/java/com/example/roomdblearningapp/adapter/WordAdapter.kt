package com.example.roomdblearningapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdblearningapp.R
import com.example.roomdblearningapp.data.Word

class WordAdapter: ListAdapter<Word, WordAdapter.WordViewHolder>(WordsComparator()) {

    class WordViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val wordItemView : TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup) : WordViewHolder {
                val view : View = LayoutInflater.from(parent.context).inflate(
                    R.layout.recyclerview_item ,parent, false
                )
                return WordViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
      return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    class WordsComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }
    }


}