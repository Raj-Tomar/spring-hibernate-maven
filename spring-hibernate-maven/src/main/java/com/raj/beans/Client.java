package com.raj.beans;
 
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
 
 
@Entity
@Table(name="client")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private int clientId;

	@Column(name="client_name")
	private String clientName;

	//------------------------------------
	// Caution: need to cache collections
	//------------------------------------
	@OneToMany(mappedBy="client",cascade=CascadeType.PERSIST)
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	private Set<PurchaseOrder> orders = new HashSet<PurchaseOrder>();


	public int getClientId() {
		return clientId;
	}
	public String getClientName() {
		return clientName;
	}

	public Set<PurchaseOrder> getPurchaseOrders() {
		return orders;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public void setPurchaseOrders(Set<PurchaseOrder> orders) {
		this.orders = orders;
	}
}