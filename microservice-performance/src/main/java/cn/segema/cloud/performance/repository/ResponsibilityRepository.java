package cn.segema.cloud.performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.performance.domain.Responsibility;

@Repository
public interface ResponsibilityRepository extends JpaRepository<Responsibility, String> {
	
}
