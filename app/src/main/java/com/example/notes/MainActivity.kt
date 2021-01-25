package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InNoteRVAdapter {
    lateinit var viewModal: NoteViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter=NotesRVAdapter(this,this)
        recyclerView.adapter=adapter
        viewModal=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModal::class.java)
        viewModal.allNote.observe(this, Observer {List->
            List?.let {
                adapter.updateList(it)
            }

        })

    }

    override fun OnItemClicked(note: Note) {
viewModal.deletenote(note)
        Toast.makeText(this, "${note.text}is deleted", Toast.LENGTH_SHORT).show()
    }

    fun submitdata(view: View) {
        val noteText=input.text.toString()
        if(noteText.isEmpty()){
            viewModal.insertnote(Note(noteText))
            Toast.makeText(this, "$noteText is deleted", Toast.LENGTH_SHORT).show()

        }
    }
}