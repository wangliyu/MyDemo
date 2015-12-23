package io.lxw.demo.service.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Customer
 * 
 * @author lxw
 *
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({ @NamedQuery(name = "Customer.getCustomerByName", query = "SELECT DISTINCT c FROM Customer c JOIN FETCH c.contacts t WHERE c.name = :name ORDER BY c.id") })
public class Customer implements Serializable {
	private static final long serialVersionUID = 5455029867011845612L;

	public enum CustomerType {
		BUSINESS, INDIVIDUAL
	}

	@Id
	@Column(name = "CUSTOMER_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TYPE", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private CustomerType type;

	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@OrderBy(value = "contactID asc")
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private List<Contact> contacts;

	/**
	 * Get the id
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the id
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the type
	 * 
	 * @return the type
	 */
	public CustomerType getType() {
		return this.type;
	}

	/**
	 * Set the type
	 * 
	 * @param type
	 *        the type to set
	 */
	public void setType(CustomerType type) {
		this.type = type;
	}

	/**
	 * Get the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name
	 * 
	 * @param name
	 *        the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the contacts
	 * 
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return this.contacts;
	}

	/**
	 * Set the contacts
	 * 
	 * @param contacts
	 *        the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
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
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [" + (this.id != null ? "id=" + this.id + ", " : "") + (this.type != null ? "type=" + this.type + ", " : "") + (this.name != null ? "name=" + this.name + ", " : "")
				+ (this.contacts != null ? "contacts=" + this.contacts : "") + "]";
	}

}
