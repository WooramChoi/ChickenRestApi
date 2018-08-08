package net.adonika.chicken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.adonika.chicken.api.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {
	
}
