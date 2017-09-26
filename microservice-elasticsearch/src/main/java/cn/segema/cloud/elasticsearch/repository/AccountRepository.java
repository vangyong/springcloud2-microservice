package cn.segema.cloud.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.elasticsearch.domain.Account;

@Repository
public interface AccountRepository extends ElasticsearchRepository<Account, String>{
	
	
	 Account findByAccountName(String accountName);
	 
	
}
