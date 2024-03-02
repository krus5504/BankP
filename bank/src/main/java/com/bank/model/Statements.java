package com.bank.model;





import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Statements {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		Integer srNo;
		private String date;
		private String transId;
		private String descr;
		private Double withd;
		private Double Depos;
		private Long ref;
		private Long selfNo;
		
		
		
		public Integer getSrNo() {
			return srNo;
		}
		public void setSrNo(Integer srNo) {
			this.srNo = srNo;
		}
		public Long getSelfNo() {
			return selfNo;
		}
		public void setSelfNo(Long selfNo) {
			this.selfNo = selfNo;
		}
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
		public Long getRef() {
			return ref;
		}
		public void setRef(Long ref) {
			this.ref = ref;
		}
		
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTransId() {
			return transId;
		}
		public void setTransId(String transId) {
			
			
			this.transId = transId;
		}
		
		public Double getWithd() {
			return withd;
		}
		public void setWithd(Double withd) {
			
			this.withd = withd;
		}
		public Double getDepos() {
			return Depos;
		}
		public void setDepos(Double depos) {
			Depos = depos;
		}
		
		
		
		@Override
		public String toString() {
			return "\nStatements [srNo=" + srNo + ", date=" + date + ", transId=" + transId + ", desc=" + descr
					+ ", withd=" + withd + ", Depos=" + Depos + "]";
		}
		
		
		
		
}
