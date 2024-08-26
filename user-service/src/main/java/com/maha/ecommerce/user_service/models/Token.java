package com.maha.ecommerce.user_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Token extends BaseModel {
	private String value;
	@ManyToOne
	private User user;
	private String expiryAt;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getExpiryAt() {
		return expiryAt;
	}

	public void setExpiryAt(String expiryAt) {
		this.expiryAt = expiryAt;
	}

}
