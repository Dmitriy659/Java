package org.dmitriy.prack15.repositories;

import org.dmitriy.prack15.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
