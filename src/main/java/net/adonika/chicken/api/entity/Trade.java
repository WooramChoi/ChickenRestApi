package net.adonika.chicken.api.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Trade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5163012216637545872L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqTrade;
	
	@Column(columnDefinition="DATETIME", nullable=false)
	protected Date dtTrade;
	
	@Column(columnDefinition="DECIMAL(10,2)", nullable=false)
	protected BigDecimal numTrade;
	
	@Column(columnDefinition="CHAR(4) default '0010'", nullable=false)
	protected String cdTypeTrade;
	
	@Column(columnDefinition="VARCHAR(255)")
	protected String strInfo;
	
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user")
	protected User user;
	
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_acnt")
	protected Acnt acnt;

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
}
