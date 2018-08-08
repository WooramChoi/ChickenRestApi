package net.adonika.chicken.api.entity;

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
public class Hist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="INT(10)")
	private int seqHist;
	
	@Column(columnDefinition="VARCHAR(50)", nullable=false)
	private String nmTable;
	
	@Column(columnDefinition="INT(10)", nullable=false)
	private int seqData;
	
	@Column(columnDefinition="VARCHAR(50)")
	private String nmField;
	
	@Column(columnDefinition="TEXT")
	private String strFrom;
	
	@Column(columnDefinition="TEXT")
	private String strTo;
	
	@Column(columnDefinition="DATETIME", nullable=false)
	private Date dtInst;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="seq_user")
	private User user;

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
