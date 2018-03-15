package io.javabrains.springbootstarter.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Kusma Singh
 * @time 10:47:57 AM
 * @date 28-Feb-2018
 */
public class BaseDTO implements Serializable {


	private static final long serialVersionUID = 2517561974281512788L;

	/**
	 * Handles created current date
	 */
	private Date createdDate;

	/**
	 * Handles Modified time stamp
	 */
	private Date modifiedDate;

	/**
	 * created By null able true.
	 */
	private Long createdBy;

	/**
	 * Modified By null able true.
	 */
	private Long modifiedBy;

	/**
	 * Is deleted true or false. By default is false.
	 */
	private boolean isArchived;

	public BaseDTO() {

	}

	public BaseDTO(boolean isArchived, Date createdDate) {
		this.isArchived = isArchived;
		this.createdDate = createdDate;
	}
	/**
	 * @param createdDate
	 * @param createdBy
	 * @param isArchived
	 */
	public BaseDTO(Date createdDate, Long createdBy, boolean isArchived) {
		super();
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.isArchived = isArchived;
	}

	public BaseDTO(Date createdDate, Date modifiedDate, Long createdBy, Long modifiedBy, boolean isArchived) {
		super();
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.isArchived = isArchived;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
}
