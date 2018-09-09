package net.adonika.chicken.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9016026941714083753L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqUser;
	
	@Column(columnDefinition="VARCHAR(50)")
	protected String strId;
	
	@Column(columnDefinition="VARCHAR(4000)", nullable=false)
	@JsonProperty(access=Access.WRITE_ONLY)
	protected String strPass;
	
	@Column(columnDefinition="VARCHAR(50)")
	protected String strName;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	protected String cdStatusUser;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	protected Set<Board> boards;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	protected Set<Hist> hists;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	protected Set<Trade> trades;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	protected Set<UserJoin> userJoins;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	protected Set<UserRole> userRoles;

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

	public Set<Board> getBoards() {
		return boards;
	}

	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}

	public Set<Hist> getHists() {
		return hists;
	}

	public void setHists(Set<Hist> hists) {
		this.hists = hists;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public Set<UserJoin> getUserJoins() {
		return userJoins;
	}

	public void setUserJoins(Set<UserJoin> userJoins) {
		this.userJoins = userJoins;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
