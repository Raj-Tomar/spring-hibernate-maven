package com.raj.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="purchase_order")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class PurchaseOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;

	@Column(name="order_desc")
	private String orderDesc;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="client_id")
	private Client client;

	public int getOrderId() {
		return orderId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public Client getClient() {
		return client;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}