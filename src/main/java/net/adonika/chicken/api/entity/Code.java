package net.adonika.chicken.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Code implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510688790053765401L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqCode;
	
	@Column(columnDefinition="INT(10) default '0'", nullable=false)
	protected int seqGroup;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false, insertable=true)
	protected String strGroup;
	
	@Column(columnDefinition="CHAR(4) default '0000'", nullable=false, insertable=true)
	protected String strKey;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false)
	protected String strValue;
	
	@Column(columnDefinition="INT(10) default '0'", nullable=false)
	protected int seqOrder;
	
	@Column(columnDefinition="TINYINT(1)", nullable=false)
	protected boolean isUse;

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

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
}
