package com.example.vidhi.ui.memeList

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vidhi.R
import com.example.vidhi.databinding.MemesitemBinding
import com.example.vidhi.network.response.Meme
import com.squareup.picasso.Picasso

/**
 * Meme list adapter
 *
 * @author Vidhi Dave
 */
class MemeListAdapter(
    private val memes: MutableList<Meme> = mutableListOf(),
    private val context: Context,
    var onMemeClick: (meme: Meme) -> Unit = {},
    var pos: Int = -1
) : RecyclerView.Adapter<MemeListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return memes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MemesitemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(memes[position])
    }

    inner class ViewHolder(private val itemBinding: MemesitemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        internal fun render(meme: Meme) {
            Picasso.get().load(meme.url).into(itemBinding.memeBanner)

            if (pos == adapterPosition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    itemView.setBackgroundColor(context.getColor(R.color.black))
                }
            }

            itemView.setOnClickListener {
                onMemeClick(meme)
            }
        }

    }

    fun addItems(list: List<Meme>) {
        this.memes.clear()
        this.memes.addAll(list)
    }
}