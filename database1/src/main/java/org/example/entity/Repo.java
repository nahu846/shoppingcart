package org.example.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<User, Integer> {
}
