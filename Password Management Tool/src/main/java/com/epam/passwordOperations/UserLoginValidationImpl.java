package com.epam.passwordOperations;

import com.epam.dao.MasterUsersOperationsDao;
import com.epam.exceptions.UserException;
import com.epam.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class UserLoginValidationImpl implements UserLoginValidation
{
    private static final Logger LOGGER = LogManager.getLogger(UserLoginValidationImpl.class);
    Scanner input = new Scanner(System.in);
    @Autowired
    private PasswordOperations passwordOperations;

    @Autowired
    private MasterUsersOperationsDao masterUsersOperationsDao;

    @Override
    public Optional<User> validateMaster(String userName, String password) throws UserException
    {
        Optional<User> user = Optional.empty();
        if (validateUserName(userName))
        {
            user = masterUsersOperationsDao.getUser(userName);
        }
        if (user.isPresent())
        {
            if (validatePassword(user.get(), password))
            {
                LOGGER.info("\nLogging you in");
            } else
            {
                user = Optional.empty();
            }
        }
        return user;
    }

    @Override
    public boolean validateUserName(String userName) throws UserException
    {
        boolean isUserName = false;
        if (masterUsersOperationsDao.isMasterPresent(userName))
        {
            isUserName = true;
        } else
        {
            throw new UserException("User not present in Database");
        }
        return isUserName;
    }

    @Override
    public boolean validatePassword(User user, String password) throws UserException
    {
        if (password.equals(null) || password.equals(""))
        {
            throw new UserException("Invalid password provided!!!");
        }
        boolean isPassword = passwordOperations.encryptPassword(password).equals(user.getPassword());

        if (!isPassword)
        {
            throw new UserException("Incorrect Password!!!");
        }

        return isPassword;
    }
}
