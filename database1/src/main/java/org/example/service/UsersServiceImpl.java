package org.example.service;

import org.example.exceptions.IdExistsException;
import org.example.exceptions.OrderException;
import org.example.models.UsersRepository;
import org.example.models.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public int createUser(User user) throws OrderException {
        if (usersRepository.existsById(user.getId())) {
            throw new OrderException("Id already exists");
        }
        return usersRepository.save(user).getId();
    }

    @Override
    public User getUser(Integer id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);

    }

    @Override
    public boolean updateUser(User user) {
        if (!usersRepository.existsById(user.getId())) {
            throw new ObjectNotFoundException(user, user.getName());
        }
        usersRepository.save(user);
        return true;
    }
}
