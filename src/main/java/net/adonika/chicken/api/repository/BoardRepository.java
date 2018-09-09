package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.adonika.chicken.api.entity.Board;

@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
