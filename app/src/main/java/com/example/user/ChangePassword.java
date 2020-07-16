package com.example.user;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.user.test.SqlLiteUserService;
import com.example.user.test.UserDatabaseHelper;
import com.example.user.test.UserEntity;
import com.example.user.test.UserService;
import com.example.user.test.exceptions.IncorrectPasswordException;
import com.example.user.test.exceptions.PasswordConstraintException;
import com.example.user.test.exceptions.UserDoesNotExistException;

public class ChangePassword extends AppCompatActivity {
    UserDatabaseHelper myDb;
    UserService userService = new SqlLiteUserService(this);
    EditText editPassword, editNewPassword, editNewPassword2;

    Button btnViewChangePassword;
    Button btnSettings;

    private int USER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        myDb = new UserDatabaseHelper(this);

        // In db there is user Julia Dlugosz with id = 1 and password = 123456;


        editPassword = findViewById(R.id.password);
        editNewPassword = findViewById(R.id.newPassword);
        editNewPassword2 = findViewById(R.id.newPassword2);

        btnSettings = findViewById(R.id.btnSettings);
        btnViewChangePassword = findViewById(R.id.btnViewChangePassword);

        initListener();
    }


    private void initListener() {
        btnViewChangePassword.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!checkPasswordsEqual()) {
                            Toast.makeText(ChangePassword.this, "Passwords are not the same", Toast.LENGTH_LONG).show();
                            return;
                        }
                        try {
                            userService.changePassword(
                                    USER_ID,
                                    editPassword.getText().toString(),
                                    editNewPassword.getText().toString()
                            );
                            passwordChanged();
                            finish();
                        } catch (IncorrectPasswordException e) {
                            Toast.makeText(ChangePassword.this, "Incorrect password", Toast.LENGTH_LONG).show();
                        } catch (PasswordConstraintException e) {
                            Toast.makeText(ChangePassword.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } catch (UserDoesNotExistException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    private void passwordChanged() {
        Toast.makeText(ChangePassword.this, "Password changed", Toast.LENGTH_LONG).show();
        editPassword.getText().clear();
        editNewPassword.getText().clear();
        editNewPassword2.getText().clear();
    }

    private boolean checkPasswordsEqual() {
        return editNewPassword2.getText().toString().equals(
                editNewPassword.getText().toString()
        );
    }
}
