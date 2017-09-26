package cn.segema.cloud.flowable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.segema.cloud.flowable.domain.ApplySimple;


public interface ApplySimpleRepository extends JpaRepository<ApplySimple, Long>{

	@Query(value="update ApplySimple a set a.state = :state where a.id = :id",nativeQuery=true)
	void updateState(Long id,Integer state);
}
