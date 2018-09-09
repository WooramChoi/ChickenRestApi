package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.adonika.chicken.api.entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByStrId(String strId);
	
}
