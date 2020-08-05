package e.com.paging3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import e.com.paging3.R
import e.com.paging3.model.Hit
import e.com.paging3.util.DiffUtilCallBack
import kotlinx.android.synthetic.main.list_item.view.*

class PaginatedAdapter : PagingDataAdapter<Hit, PaginatedAdapter.ViewHolder>(DiffUtilCallBack()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv.text = getItem(position)?.story_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = position
}