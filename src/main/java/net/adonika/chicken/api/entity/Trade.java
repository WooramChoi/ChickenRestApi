package net.adonika.chicken.api.entity;

import java.math.BigDecimal;
import java.util.Date;

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
public class Trade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqTrade;
	
	@Column(columnDefinition="DATETIME", nullable=false)
	private Date dtTrade;
	
	@Column(columnDefinition="DECIMAL(10,2)", nullable=false)
	private BigDecimal numTrade;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	private String cdTypeTrade;
	
	@Column(columnDefinition="VARCHAR(255)")
	private String strInfo;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_user")
	private User user;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_acnt")
	private Acnt acnt;

	public int getSeqTrade() {
		return seqTrade;
	}

	public void setSeqTrade(int seqTrade) {
		this.seqTrade = seqTrade;
	}

	public Date getDtTrade() {
		return dtTrade;
	}

	public void setDtTrade(Date dtTrade) {
		this.dtTrade = dtTrade;
	}

	public BigDecimal getNumTrade() {
		return numTrade;
	}

	public void setNumTrade(BigDecimal numTrade) {
		this.numTrade = numTrade;
	}

	public String getCdTypeTrade() {
		return cdTypeTrade;
	}

	public void setCdTypeTrade(String cdTypeTrade) {
		this.cdTypeTrade = cdTypeTrade;
	}

	public String getStrInfo() {
		return strInfo;
	}

	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Acnt getAcnt() {
		return acnt;
	}

	public void setAcnt(Acnt acnt) {
		this.acnt = acnt;
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
