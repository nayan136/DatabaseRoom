package com.example.nayan.databaseroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nayan on 9/1/18.
 */

@Entity(tableName = "trophy",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)


public class Trophy {

    @PrimaryKey(autoGenerate = true)
    long id;

    public int userId;
    String description;

    public Trophy(int userId, String description) {
        this.userId = userId;
        this.description = description;
    }


}
