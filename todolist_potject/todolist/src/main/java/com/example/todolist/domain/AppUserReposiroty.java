package com.example.todolist.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserReposiroty extends JpaRepository<AppUser, Long> {
}
