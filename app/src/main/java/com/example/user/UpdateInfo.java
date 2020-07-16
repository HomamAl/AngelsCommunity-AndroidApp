package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.test.SqlLiteUserService;
import com.example.user.test.UserDatabaseHelper;
import com.example.user.test.UserEntity;
import com.example.user.test.UserService;
import com.example.user.test.exceptions.UserDoesNotExistException;

public class UpdateInfo extends AppCompatActivity {

        UserDatabaseHelper myDb;
        EditText editEmail, editNumber, editName, editSurname;

        Button btnViewUpdate;
        Button btnSettings;
        Button btnViewChangePassword;

        UserService userService = new SqlLiteUserService(this);

        int USER_ID = 1;


        @Override
        protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_update_info);
                myDb = new UserDatabaseHelper(this);

                editEmail= findViewById(R.id.email);
                editNumber = findViewById(R.id.phone);
                editName = findViewById(R.id.name);
                editSurname= findViewById(R.id.surname);
                btnViewChangePassword = findViewById(R.id.btnViewChangePassword);
                btnSettings = findViewById(R.id.btnSettings);
                btnViewUpdate = findViewById(R.id.btnUpdateDetails);

                updateUserData();

                initListeners();
        }

        private void updateUserData() {
                UserEntity user = userService.getUserDetails(USER_ID);
                if (user != null) {
                        editNumber.setText(user.getNumber());
                        editEmail.setText(user.getEmail());
                        editName.setText(user.getName());
                        editSurname.setText(user.getSurname());
                }
        }

        private void initListeners() {
                btnViewUpdate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                try {
                                        userService.changeUserDetail(
                                                USER_ID,
                                                new UserEntity(
                                                        null,
                                                        editName.getText().toString(),
                                                        editSurname.getText().toString(),
                                                        editEmail.getText().toString(),
                                                        null,
                                                        null,
                                                        null,
                                                        null,
                                                        editNumber.getText().toString()
                                                )
                                        );
                                        Toast.makeText(UpdateInfo.this, "Information is updated", Toast.LENGTH_LONG).show();
                                        setResult(RESULT_OK);
                                        finish();
                                } catch (UserDoesNotExistException e) {
                                        Toast.makeText(UpdateInfo.this, "Information hasn't been changed", Toast.LENGTH_LONG).show();
                                        e.printStackTrace();
                                }

                        }


                });
        }



}


