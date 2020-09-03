package com.alon.openlegacy.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class ItemEntity {
	// Variables
	private String id;
	private String name;
	private int amount;
	private int code;
	
	// Constructors
	public ItemEntity() {
	}

	public ItemEntity(String id, String name, int amount, int code) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.code = code;
	}

	// Getters and setters
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
