package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class NotesRVAdapter(private val context:Context, private val listener:InNoteRVAdapter):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
     val allNote=ArrayList<Note>()
    inner  class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView =itemView.findViewById<TextView>(R.id.text)
        val deleteButton=itemView.findViewById<TextView>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      val viewHolder= NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
viewHolder.deleteButton.setOnClickListener{
    listener.OnItemClicked((allNote[viewHolder.adapterPosition]))

}
        return viewHolder
    }

    override fun getItemCount(): Int {
        return  allNote.size
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNote[position]
        holder.textView.text=currentNote.text

    }
     fun updateList(newList: List<Note>)
     {
         allNote.clear()
         allNote.addAll(newList)
         notifyDataSetChanged()
     }


}
interface InNoteRVAdapter{
    fun OnItemClicked(note: Note)
}