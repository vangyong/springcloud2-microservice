package cn.segema.cloud.filecenter.domain;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "FILE_FILECENTER")
@Entity
public class Filecenter {
	@Id
	@Column(name="FILEID")
	private String fileId;
	
	@Column(name="FILENAME")
	private String fileName;
	
	@Column(name="BUSINESSID")
	private String businessId;
	
	@Column(name="ABSOLUTEPATH")
	private String absolutePath;
	
	@Column(name="RELATIVEPATH")
	private String relativePath;
	
	@Column(name="SUFFIX")
	private String suffix;
	
	@Column(name="FIILETYPE")
	private String fileType;
	
	@Column(name="TOTALSIZE")
	private BigDecimal totalSize;
	
	@Column(name="FIILECONTENT")
	private byte[] fileContent;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public BigDecimal getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(BigDecimal totalSize) {
		this.totalSize = totalSize;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	

}
