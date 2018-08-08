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
public class UserJoin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqUserJoin;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	private String cdStatusJoin;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_user")
	private User user;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_user_group")
	private UserGroup userGroup;
	
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
	
	public int getSeqUser() {
		if ( this.user == null ) {
			this.user = new User();
		}
		return this.user.getSeqUser();
	}
	
	public void setSeqUser(int seqUser) {
		if ( this.user == null ) {
			this.user = new User();
		}
		this.user.setSeqUser(seqUser);
	}
	
	public int getSeqUserGroup() {
		if ( this.userGroup == null ) {
			this.userGroup = new UserGroup();
		}
		return this.userGroup.getSeqUserGroup();
	}
	
	public void setSeqUserGroup(int seqUserGroup) {
		if ( this.userGroup == null ) {
			this.userGroup = new UserGroup();
		}
		this.userGroup.setSeqUserGroup(seqUserGroup);
	}
}
