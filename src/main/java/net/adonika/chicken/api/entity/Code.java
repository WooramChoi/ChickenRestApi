package net.adonika.chicken.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Code {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqCode;
	
	@Column(columnDefinition="INT(10) default '0'", nullable=false)
	private int seqGroup;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false, insertable=true)
	private String strGroup;
	
	@Column(columnDefinition="CHAR(4) default '0000'", nullable=false, insertable=true)
	private String strKey;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false)
	private String strValue;
	
	@Column(columnDefinition="INT(10) default '0'", nullable=false)
	private int seqOrder;
	
	@Column(columnDefinition="CHAR(1) default 'Y'", nullable=false)
	private String ynUse;

	public int getSeqCode() {
		return seqCode;
	}

	public void setSeqCode(int seqCode) {
		this.seqCode = seqCode;
	}

	public int getSeqGroup() {
		return seqGroup;
	}

	public void setSeqGroup(int seqGroup) {
		this.seqGroup = seqGroup;
	}

	public String getStrGroup() {
		return strGroup;
	}

	public void setStrGroup(String strGroup) {
		this.strGroup = strGroup;
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}

	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	public int getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(int seqOrder) {
		this.seqOrder = seqOrder;
	}

	public String getYnUse() {
		return ynUse;
	}

	public void setYnUse(String ynUse) {
		this.ynUse = ynUse;
	}
}
