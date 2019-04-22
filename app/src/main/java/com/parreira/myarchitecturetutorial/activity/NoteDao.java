package com.parreira.myarchitecturetutorial.activity;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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
@Dao
public interface NoteDao {

    @Insert
    void insertNote (Note note);

    @Query("DELETE FROM note_table")
    void deleteAll ();

    @Delete
    void deleteNote (Note note);

    @Update
     void updateNote(Note note);

    @Query("SELECT * FROM note_table ORDER BY priority")
    LiveData<List<Note>> getAllNotes();

}
