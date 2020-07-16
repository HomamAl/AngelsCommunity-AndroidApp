package com.example.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.test.SqlLiteUserService;
import com.example.user.test.UserDatabaseHelper;
import com.example.user.test.UserEntity;
import com.example.user.test.UserService;

public class ProfilePage extends AppCompatActivity {

    UserService userService = new SqlLiteUserService(this);
    int USER_ID = 1;
    UserDatabaseHelper myDb;

    TextView levelTextView;
    TextView pointsTextView;
    TextView badgesTextView;
    TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        myDb = new UserDatabaseHelper(this);

        bindView();

        updateData();
    }

    private void bindView() {
        nameTextView = findViewById(R.id.namePP);
        badgesTextView = findViewById(R.id.badgesPP);
        pointsTextView = findViewById(R.id.pointsPP);
        levelTextView = findViewById(R.id.levelPP);
    }

    public void on_edit_click (View view) {
        Intent intent = new Intent(this, UpdateInfo.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
            updateData();
        //you should use observable
    }

    public void on_help_click (View view) {
        Intent intent = new Intent(this, AddCard.class);
        startActivity(intent);
    }
    public void on_password_click (View view) {
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
    }

    public void updateData() {
        UserEntity user = userService.getUserDetails(USER_ID);
        if (user != null) {
            nameTextView.setText(
                    user.getName() + " " + user.getSurname() + " - ID: " + user.getId()
            );
            levelTextView.setText(user.getLevel().toString());
            pointsTextView.setText(user.getPoints().toString());
            badgesTextView.setText(user.getBadges().toString());
        } else {
            System.out.println("User with id: " + USER_ID + " didn't find in a DB");
        }
    }

}

