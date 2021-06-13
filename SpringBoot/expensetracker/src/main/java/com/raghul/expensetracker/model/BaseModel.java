package com.raghul.expensetracker.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class BaseModel {
	
	@Column(name="created_on")
	private Date createdOn;
	@Column(name="updated_on")
	private Date updatedOn;
	@Column(name="is_active")
	private Boolean isActive;
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@PrePersist
	public void prePersist() {
		if(this.getCreatedOn() == null) {
			this.setCreatedOn(new Date());
		}
		if(this.getIsActive() == null) {
			this.setIsActive(true);
		}
		if(this.getUpdatedOn() == null) {
			this.setUpdatedOn(new Date());
		}
	}
	
	

}
