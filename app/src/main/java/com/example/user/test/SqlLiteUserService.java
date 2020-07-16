package com.example.user.test;
import android.content.ContentValues;
import android.content.Context;

import com.example.user.test.exceptions.IncorrectPasswordException;
import com.example.user.test.exceptions.PasswordConstraintException;
import com.example.user.test.exceptions.UserDoesNotExistException;

import java.util.Map;

public class SqlLiteUserService implements UserService {

    private UserDatabaseHelper db;
    public SqlLiteUserService(Context context) {
        db = new UserDatabaseHelper(context);
    }

    @Override
    public void changePassword(int userId, String oldPassword, String newPassword) throws
            IncorrectPasswordException,
            PasswordConstraintException,
            UserDoesNotExistException {
        Map<String, String> user = db.getDataById(userId);
        if (user != null) {
            if (!user.get("PASSWORD").equals(oldPassword))
                throw new IncorrectPasswordException();
            if (!checkPasswordComplexity(newPassword))
                throw new PasswordConstraintException("Password too short");
            ContentValues contentValues = new ContentValues();
            contentValues.put(db.COL_5, newPassword);
            db.updateData(userId, contentValues);
//            db.changePassword(userId, oldPassword, newPassword);
        } else
            throw new UserDoesNotExistException();
    }

    private boolean checkPasswordComplexity(String newPassword) {
        return newPassword.length() > 5;
    }

    @Override
    public UserEntity getUserDetails(int userId) {
        Map<String, String> userMap = db.getDataById(userId);
        if (userMap != null) {
            UserEntity user = new UserEntity(
                    Integer.valueOf(userMap.get(db.COL_1)),
                    userMap.get(db.COL_2),
                    userMap.get(db.COL_3),
                    userMap.get(db.COL_4),
                    userMap.get(db.COL_5),
                    Integer.valueOf(userMap.get(db.COL_6)),
                    Integer.valueOf(userMap.get(db.COL_7)),
                    Integer.valueOf(userMap.get(db.COL_8)),
                    userMap.get(db.COL_9)
            );
            return user;
        }
        return null;
    }

    @Override
    public void changeUserDetail(int userId, UserEntity user) throws UserDoesNotExistException {
        ContentValues values = new ContentValues();
        values.put(db.COL_2, user.getName());
        values.put(db.COL_3, user.getSurname());
        values.put(db.COL_4, user.getEmail());
        values.put(db.COL_9, user.getNumber());
        int res = db.updateData(userId, values);
        if (res < 1)
            throw new UserDoesNotExistException();
    }
}
