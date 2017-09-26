package cn.segema.cloud.filecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.filecenter.domain.Filecenter;

@Repository
public interface FilecenterRepository extends JpaRepository<Filecenter, String> {
	
}
