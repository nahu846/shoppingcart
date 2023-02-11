package org.example.service;

import org.example.entity.Repo;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private Repo repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User getSinge(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
