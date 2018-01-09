package com.example.nayan.databaseroom;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(getApplicationContext());

        database.userDao().removeAllUsers();

        List<User> users = database.userDao().getAllUser();

        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Test 1", 1));
            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            Trophy trophy = new Trophy(user.id, "Learned to use 3");
            database.trophyDao().addTrophy(trophy);
            database.userDao().addUser(new User(2, "Test 2", 2));
            database.userDao().addUser(new User(3, "Test 3", 3));
        }

        updateFirstUserData();
    }


    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<Trophy> trophiesForUser = database.trophyDao().findTrophiesForUser(user.get(0).id);
        TextView textView = findViewById(R.id.result);
        Toast.makeText(this, trophiesForUser.toString(), Toast.LENGTH_SHORT).show();
        if (user.size()>0){
            String data = user.get(0).name + " Skill points " + user.get(0).skillPonits + " Trophys " + trophiesForUser.size();
            textView.setText(data);
        }
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

}
