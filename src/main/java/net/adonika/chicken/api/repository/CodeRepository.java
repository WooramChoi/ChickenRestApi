package net.adonika.chicken.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.adonika.chicken.api.entity.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
	
	public List<Code> findByStrGroup(@Param("strGroup") String strGroup);
	
	public List<Code> findBySeqGroup(@Param("seqGroup") int seqGroup);
	
	public Code findByStrGroupAndStrKey(@Param("strGroup") String strGroup, @Param("strKey") String strKey);
	
}
