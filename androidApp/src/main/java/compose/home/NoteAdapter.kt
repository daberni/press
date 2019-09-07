package compose.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import io.reactivex.Observable
import me.saket.compose.shared.home.HomeUiModel
import javax.inject.Inject

class NoteAdapter @Inject constructor() : ListAdapter<HomeUiModel.Note, NoteVH>(NoteDiffer()) {

  override fun getItemId(position: Int) =
    getItem(position).adapterId

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    NoteVH(NoteRowView(parent.context))

  override fun onBindViewHolder(holder: NoteVH, position: Int) {
    holder.view.render(getItem(position))
  }
}

class NoteDiffer: DiffUtil.ItemCallback<HomeUiModel.Note>() {
  override fun areItemsTheSame(oldItem: HomeUiModel.Note, newItem: HomeUiModel.Note)
      = oldItem.adapterId == newItem.adapterId
  override fun areContentsTheSame(oldItem: HomeUiModel.Note, newItem: HomeUiModel.Note)
      = oldItem == newItem
}

class NoteVH(val view: NoteRowView) : ViewHolder(view)