package com.example.demo.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CUSTOMER")
public class CustomerDTO {
	
		@Id
		@GeneratedValue
		@Column(name="Id", nullable=false)
		private Long id;
		
		@Column(name="Full_Name", length=64, nullable=false)
		private String fullName;
		
		@Temporal(TemporalType.DATE)
		@Column(name="Date_Of_Birth", nullable=false)
		private Date dateOfBirth;
		
		
		@Temporal(TemporalType.DATE)
		@Column(name="Creation_Date", nullable=false)
		private Date creationDate;
		
		@Temporal(TemporalType.DATE)
		@Column(name="Updated_Date", nullable=false)
		private Date updatedDate;
		

		public Long getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth +", creationDate=" + creationDate +",  updatedDate=" + updatedDate + "]";
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}		
		
	}

