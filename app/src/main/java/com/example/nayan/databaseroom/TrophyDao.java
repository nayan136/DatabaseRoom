package com.example.nayan.databaseroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by nayan on 9/1/18.
 */

@Dao
public interface TrophyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrophy(Trophy trophy);

    @Query("select * from trophy where userId = :userId")
    List<Trophy> findTrophiesForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void onUpdateTrophhy(Trophy trophy);

    @Query("delete from trophy where id = :id")
    void delete(long id);
}
