package com.example.nayan.databaseroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nayan on 9/1/18.
 */

@Entity(indices = {@Index(value = {"id"},
                   unique = true)
    })

public class User {

    @PrimaryKey
    public final int id;
    public String name;
    public int level;
    public long skillPonits;

    public User(int id, String name, long skillPonits) {
        this.id = id;
        this.name = name;
        this.skillPonits = skillPonits;
        this.level = 0;
    }
}
