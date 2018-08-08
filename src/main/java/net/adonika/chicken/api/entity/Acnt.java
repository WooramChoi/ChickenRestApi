package net.adonika.chicken.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acnt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqAcnt;
	
	@Column(columnDefinition="CHAR(4)", nullable=false)
	private String cdBank;
	
	@Column(columnDefinition="VARCHAR(15)", nullable=false)
	private String strAcnt;

	public int getSeqAcnt() {
		return seqAcnt;
	}

	public void setSeqAcnt(int seqAcnt) {
		this.seqAcnt = seqAcnt;
	}

	public String getCdBank() {
		return cdBank;
	}

	public void setCdBank(String cdBank) {
		this.cdBank = cdBank;
	}

	public String getStrAcnt() {
		return strAcnt;
	}

	public void setStrAcnt(String strAcnt) {
		this.strAcnt = strAcnt;
	}
}
