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
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8782807387589279675L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqUserRole;
	
	@Column(columnDefinition="VARCHAR(50)", nullable=false)
	protected String strAuth;
	
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user")
	protected User user;

	public int getSeqUserRole() {
		return seqUserRole;
	}

	public void setSeqUserRole(int seqUserRole) {
		this.seqUserRole = seqUserRole;
	}

	public String getStrAuth() {
		return strAuth;
	}

	public void setStrAuth(String strAuth) {
		this.strAuth = strAuth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
