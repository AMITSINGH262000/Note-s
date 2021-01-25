package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application) : AndroidViewModel(application) {

      val repository: NoteRepository
      val allNote:LiveData<List<Note>>
    init {
        val dao=NoteDatabase.getDatabase(application).getNoteDao()
         repository= NoteRepository(dao)
        allNote=repository.allNotes
    }
    fun deletenote(note: Note)= viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)

    }
     fun insertnote(note: Note)=viewModelScope.launch ( Dispatchers.IO ){
         repository.insert(note)
     }
}
