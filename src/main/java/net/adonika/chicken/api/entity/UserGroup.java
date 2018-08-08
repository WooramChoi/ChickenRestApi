package net.adonika.chicken.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class UserGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqUserGroup;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String strName;
	
	@Column(columnDefinition="CHAR(4) default '0000'")
	private String cdTypePeriod;
	
	@Column(columnDefinition="TINYINT(2) default '0'")
	private int numDayPeriod;
	
	@Column(columnDefinition="TINYINT(2) default '0'")
	private int numCntPeriod;
	
	@Column(columnDefinition="CHAR(4) default '0010'")
	private String cdStatusGroup;
	
	@Column(columnDefinition="VARCHAR(255)")
	private String strInfo;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_acnt")
	private Acnt acnt;

	public int getSeqUserGroup() {
		return seqUserGroup;
	}

	public void setSeqUserGroup(int seqUserGroup) {
		this.seqUserGroup = seqUserGroup;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getCdTypePeriod() {
		return cdTypePeriod;
	}

	public void setCdTypePeriod(String cdTypePeriod) {
		this.cdTypePeriod = cdTypePeriod;
	}

	public int getNumDayPeriod() {
		return numDayPeriod;
	}

	public void setNumDayPeriod(int numDayPeriod) {
		this.numDayPeriod = numDayPeriod;
	}

	public int getNumCntPeriod() {
		return numCntPeriod;
	}

	public void setNumCntPeriod(int numCntPeriod) {
		this.numCntPeriod = numCntPeriod;
	}

	public String getCdStatusGroup() {
		return cdStatusGroup;
	}

	public void setCdStatusGroup(String cdStatusGroup) {
		this.cdStatusGroup = cdStatusGroup;
	}

	public String getStrInfo() {
		return strInfo;
	}

	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public Acnt getAcnt() {
		return acnt;
	}

	public void setAcnt(Acnt acnt) {
		this.acnt = acnt;
	}
	
	public int getSeqAcnt() {
		if ( this.acnt == null ) {
			this.acnt = new Acnt();
		}
		return this.acnt.getSeqAcnt();
	}
	
	public void setSeqAcnt(int seqAcnt) {
		if ( this.acnt == null ) {
			this.acnt = new Acnt();
		}
		this.acnt.setSeqAcnt(seqAcnt);
	}
}
