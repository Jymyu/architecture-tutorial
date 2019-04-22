package com.parreira.myarchitecturetutorial.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.AndroidException;

import com.parreira.myarchitecturetutorial.activity.Note;
import com.parreira.myarchitecturetutorial.repository.NoteRepository;

import java.util.List;

/**
 * Created by João Parreira on 4/18/2019.
 * <p>
 * ITSector ITSector
 * joao.parreira@itsector.pt
 * <p>
 * Copyright (c) ITSector Software. All rights reserved.
 * <p>
 * ITSector Software Confidential and Proprietary information. It is strictly forbidden for 3rd
 * parties to modify, decompile, disassemble, defeat, disable or circumvent any protection
 * mechanism; to sell, license, lease, rent, redistribute or make accessible to any third party,
 * whether for profit or without charge.
 */
public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete (Note note){
        repository.delete(note);
    }

    public void deleteAllNotes (){
        repository.deleteAll();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
