package net.adonika.chicken.api.entity;

import java.io.Serializable;
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
public class Hist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6716422164011942884L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	protected int seqHist;
	
	@Column(columnDefinition="VARCHAR(50)", nullable=false)
	protected String nmTable;
	
	@Column(columnDefinition="INT(10)", nullable=false)
	protected int seqData;
	
	@Column(columnDefinition="VARCHAR(50)")
	protected String nmField;
	
	@Column(columnDefinition="TEXT")
	protected String strFrom;
	
	@Column(columnDefinition="TEXT")
	protected String strTo;
	
	@Column(columnDefinition="DATETIME", nullable=false)
	protected Date dtInst;
	
	@JsonBackReference
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="seq_user")
	protected User user;

	public int getSeqHist() {
		return seqHist;
	}

	public void setSeqHist(int seqHist) {
		this.seqHist = seqHist;
	}

	public String getNmTable() {
		return nmTable;
	}

	public void setNmTable(String nmTable) {
		this.nmTable = nmTable;
	}

	public int getSeqData() {
		return seqData;
	}

	public void setSeqData(int seqData) {
		this.seqData = seqData;
	}

	public String getNmField() {
		return nmField;
	}

	public void setNmField(String nmField) {
		this.nmField = nmField;
	}

	public String getStrFrom() {
		return strFrom;
	}

	public void setStrFrom(String strFrom) {
		this.strFrom = strFrom;
	}

	public String getStrTo() {
		return strTo;
	}

	public void setStrTo(String strTo) {
		this.strTo = strTo;
	}

	public Date getDtInst() {
		return dtInst;
	}

	public void setDtInst(Date dtInst) {
		this.dtInst = dtInst;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
