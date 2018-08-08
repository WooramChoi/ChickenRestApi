package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.adonika.chicken.api.entity.Hist;

@Repository
public interface HistRepository extends JpaRepository<Hist, Integer> {

}
