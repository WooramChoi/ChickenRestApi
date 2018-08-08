package net.adonika.chicken.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqUser;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String strId;
	
	@Column(columnDefinition="VARCHAR(50)", nullable=false)
	@JsonProperty(access=Access.WRITE_ONLY)
	private String strPass;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String strName;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	private String cdStatusUser;

	public int getSeqUser() {
		return seqUser;
	}

	public void setSeqUser(int seqUser) {
		this.seqUser = seqUser;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getStrPass() {
		return strPass;
	}

	public void setStrPass(String strPass) {
		this.strPass = strPass;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getCdStatusUser() {
		return cdStatusUser;
	}

	public void setCdStatusUser(String cdStatusUser) {
		this.cdStatusUser = cdStatusUser;
	}
}
