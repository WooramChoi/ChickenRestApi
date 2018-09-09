package net.adonika.chicken.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UserGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1898393003267855925L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqUserGroup;
	
	@Column(columnDefinition="VARCHAR(50)")
	protected String strName;
	
	@Column(columnDefinition="CHAR(4) default '0000'")
	protected String cdTypePeriod;
	
	@Column(columnDefinition="TINYINT(2) default '0'")
	protected int numDayPeriod;
	
	@Column(columnDefinition="TINYINT(2) default '0'")
	protected int numCntPeriod;
	
	@Column(columnDefinition="CHAR(4) default '0010'")
	protected String cdStatusGroup;
	
	@Column(columnDefinition="VARCHAR(255)")
	protected String strInfo;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_acnt")
	protected Acnt acnt;
	
	@JsonManagedReference
	@OneToMany(mappedBy="userGroup")
	protected Set<UserJoin> userJoins;

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

	public Set<UserJoin> getUserJoins() {
		return userJoins;
	}

	public void setUserJoins(Set<UserJoin> userJoins) {
		this.userJoins = userJoins;
	}
}
