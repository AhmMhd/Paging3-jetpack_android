package e.com.paging3.util

import androidx.recyclerview.widget.DiffUtil
import e.com.paging3.model.Hit

class DiffUtilCallBack : DiffUtil.ItemCallback<Hit>() {
    override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
        return oldItem.objectID.equals(newItem.objectID)
    }

    override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
       return oldItem.story_title.equals(newItem.story_title)
    }

}