package com.example.user.test;

import com.example.user.test.exceptions.IncorrectPasswordException;
import com.example.user.test.exceptions.PasswordConstraintException;
import com.example.user.test.exceptions.UserDoesNotExistException;

public interface UserService {

    void changePassword(int userId, String oldPassword, String newPassword) throws
            IncorrectPasswordException,
            PasswordConstraintException,
            UserDoesNotExistException;
    UserEntity getUserDetails(int userId);
    void changeUserDetail(int userId, UserEntity user) throws UserDoesNotExistException;

}
