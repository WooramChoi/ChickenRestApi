package net.adonika.chicken.api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.adonika.chicken.api.entity.Code;

@RepositoryRestResource
public interface CodeRepository extends JpaRepository<Code, Integer> {
	
	public Set<Code> findByStrGroup(@Param("strGroup") String strGroup);
	
	public Set<Code> findBySeqGroup(@Param("seqGroup") int seqGroup);
	
	public Code findByStrGroupAndStrKey(@Param("strGroup") String strGroup, @Param("strKey") String strKey);
	
}
