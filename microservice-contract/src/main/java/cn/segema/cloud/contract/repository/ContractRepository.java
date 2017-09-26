package cn.segema.cloud.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.contract.domain.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
	
}
