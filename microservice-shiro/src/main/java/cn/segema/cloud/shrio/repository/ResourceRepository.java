package cn.segema.cloud.shrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.shrio.domain.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, String> {
	
	 
	 @Query("select r from Resource r where r.resourceName = ?1") 
	 List<Resource> findResourceByUserName(String userName); 
	 
	 @Query("select r from Resource r where r.resourceName = ?1") 
	 List<Resource> findResourceByUserId(String userId); 
	 
}
