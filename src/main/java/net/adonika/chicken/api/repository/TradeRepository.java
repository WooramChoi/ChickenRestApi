package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.adonika.chicken.api.entity.Trade;

@RepositoryRestResource
public interface TradeRepository extends JpaRepository<Trade, Integer> {
	
}
