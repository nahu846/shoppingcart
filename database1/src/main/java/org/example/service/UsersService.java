package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    int createUser(User user) throws OrderException;

    User getUser(Integer id);

    void deleteUser(Integer id);

    boolean updateUser(User user);
}

