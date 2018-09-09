package net.adonika.chicken.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Acnt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4865521517013993346L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqAcnt;
	
	@Column(columnDefinition="CHAR(4)", nullable=false)
	protected String cdBank;
	
	@Column(columnDefinition="VARCHAR(15)", nullable=false)
	protected String strAcnt;
	
	@JsonManagedReference
	@OneToMany(mappedBy="acnt")
	protected Set<Trade> trades;
	
	@JsonManagedReference
	@OneToMany(mappedBy="acnt")
	protected Set<UserGroup> userGroups;

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

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
}
