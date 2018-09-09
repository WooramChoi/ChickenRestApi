package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.adonika.chicken.api.entity.UserGroup;

@RepositoryRestResource
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {

}
