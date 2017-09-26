package cn.segema.cloud.elasticsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.elasticsearch.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	
	 
	 @Query("select r from Role r where r.roleName = ?1") 
	 public List<Role> findByRoleName(String roleName); 
	 
	 
}
