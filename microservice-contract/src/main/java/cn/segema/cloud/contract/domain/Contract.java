package cn.segema.cloud.contract.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CON_CONTRACT")
@Entity
public class Contract {
	@Id
	@Column(name="CONTRACTID")
	private String contractId;
	@Column(name="CONTRACTNAME")
	private String contractName;
	@Column(name="TOTALMONEY")
	private BigDecimal totalMoney;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

}
