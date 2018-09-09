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

@Entity
public class Board implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5912660747892331944L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqBoard;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false)
	protected String strTitle;
	
	@Column(columnDefinition="TEXT", nullable=false)
	protected String strContents;
	
	@Column(columnDefinition="TINYINT(1)", nullable=false)
	protected boolean isUse;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user")
	protected User user;

	public int getSeqBoard() {
		return seqBoard;
	}

	public void setSeqBoard(int seqBoard) {
		this.seqBoard = seqBoard;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String getStrContents() {
		return strContents;
	}

	public void setStrContents(String strContents) {
		this.strContents = strContents;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
