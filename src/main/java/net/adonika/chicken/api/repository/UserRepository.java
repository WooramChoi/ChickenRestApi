package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.adonika.chicken.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
