package cn.segema.cloud.elasticsearch.domain;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "accountIndex",type = "account", shards = 1,replicas = 0, refreshInterval = "-1")
public class Account {
    private String id;
    private String accountName;
    private String nickName;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    
    
}
