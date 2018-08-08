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
public class Board {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqBoard;
	
	@Column(columnDefinition="VARCHAR(255)", nullable=false)
	private String strTitle;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String strContents;
	
	@Column(columnDefinition="CHAR(1) default 'Y'", nullable=false)
	private String ynUse;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_user")
	private User user;

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

	public String getYnUse() {
		return ynUse;
	}

	public void setYnUse(String ynUse) {
		this.ynUse = ynUse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
}
