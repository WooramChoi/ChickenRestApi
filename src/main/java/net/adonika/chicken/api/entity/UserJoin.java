package net.adonika.chicken.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserJoin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7067262567673793900L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqUserJoin;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	protected String cdStatusJoin;
	
	//TODO Set unique-index to seqUser-seqUserGroup
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user")
	protected User user;
	
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user_group")
	protected UserGroup userGroup;

	public int getSeqUserJoin() {
		return seqUserJoin;
	}

	public void setSeqUserJoin(int seqUserJoin) {
		this.seqUserJoin = seqUserJoin;
	}

	public String getCdStatusJoin() {
		return cdStatusJoin;
	}

	public void setCdStatusJoin(String cdStatusJoin) {
		this.cdStatusJoin = cdStatusJoin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
