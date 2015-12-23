package io.lxw.demo.service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Contact
 * 
 * @author lwang
 *
 */
@Entity
@Table(name = "CONTACT")
@IdClass(io.lxw.demo.service.domain.Contact.ContactID.class)
public class Contact implements Serializable {
	private static final long serialVersionUID = 3168951747588371837L;

	public static final class ContactID implements Serializable {
		private static final long serialVersionUID = 3882857994911640740L;
		private long customerID = 0;
		private long contactID = 0;

		/**
		 * Get the customerID
		 * 
		 * @return the customerID
		 */
		public long getCustomerID() {
			return this.customerID;
		}

		/**
		 * Set the customerID
		 * 
		 * @param customerID
		 *        the customerID to set
		 */
		public void setCustomerID(long customerID) {
			this.customerID = customerID;
		}

		/**
		 * Get the contactID
		 * 
		 * @return the contactID
		 */
		public long getContactID() {
			return this.contactID;
		}

		/**
		 * Set the contactID
		 * 
		 * @param contactID
		 *        the contactID to set
		 */
		public void setContactID(long contactID) {
			this.contactID = contactID;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (this.contactID ^ (this.contactID >>> 32));
			result = prime * result + (int) (this.customerID ^ (this.customerID >>> 32));
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof ContactID))
				return false;
			ContactID other = (ContactID) obj;
			if (this.contactID != other.contactID)
				return false;
			if (this.customerID != other.customerID)
				return false;
			return true;
		}

	}

	@Id
	@Column(name = "CUSTOMER_ID", nullable = false, unique = true, updatable = false, insertable = false)
	private Long customerID;
	@Id
	@Column(name = "CONTACT_ID", nullable = false, unique = true, updatable = false, insertable = false)
	private Long contactID;
	@Id
	@Column(name = "DETAIL", nullable = false)
	private String detail;

	/**
	 * Get the customerID
	 * 
	 * @return the customerID
	 */
	public Long getCustomerID() {
		return this.customerID;
	}

	/**
	 * Set the customerID
	 * 
	 * @param customerID
	 *        the customerID to set
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	/**
	 * Get the contactID
	 * 
	 * @return the contactID
	 */
	public Long getContactID() {
		return this.contactID;
	}

	/**
	 * Set the contactID
	 * 
	 * @param contactID
	 *        the contactID to set
	 */
	public void setContactID(Long contactID) {
		this.contactID = contactID;
	}

	/**
	 * Get the detail
	 * 
	 * @return the detail
	 */
	public String getDetail() {
		return this.detail;
	}

	/**
	 * Set the detail
	 * 
	 * @param detail
	 *        the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.contactID == null) ? 0 : this.contactID.hashCode());
		result = prime * result + ((this.customerID == null) ? 0 : this.customerID.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Contact))
			return false;
		Contact other = (Contact) obj;
		if (this.contactID == null) {
			if (other.contactID != null)
				return false;
		} else if (!this.contactID.equals(other.contactID))
			return false;
		if (this.customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!this.customerID.equals(other.customerID))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [" + (this.customerID != null ? "customerID=" + this.customerID + ", " : "") + (this.contactID != null ? "contactID=" + this.contactID + ", " : "")
				+ (this.detail != null ? "detail=" + this.detail : "") + "]";
	}

}
