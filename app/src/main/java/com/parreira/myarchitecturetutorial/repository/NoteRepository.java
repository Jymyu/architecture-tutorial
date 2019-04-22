package com.parreira.myarchitecturetutorial.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import com.parreira.myarchitecturetutorial.activity.Note;
import com.parreira.myarchitecturetutorial.activity.NoteDao;
import com.parreira.myarchitecturetutorial.activity.NoteDatabase;

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
public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public void deleteAll() {
        new DeleteAllNoteAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private InsertNoteAsyncTask(NoteDao noteDao) {

            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.insertNote(notes[0]);
            return null;
        }
    }


    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.updateNote(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private DeleteNoteAsyncTask(NoteDao noteDao) {

            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.deleteNote(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {

        private NoteDao notedao;

        private DeleteAllNoteAsyncTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            notedao.deleteAll();
            return null;
        }
    }


}
