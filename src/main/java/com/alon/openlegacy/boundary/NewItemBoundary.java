package com.alon.openlegacy.boundary;

public class NewItemBoundary {
	// Variables
	private String name;
	private int amount;
	private int code;
	
	// Constructors
	public NewItemBoundary() {
	}

	public NewItemBoundary(String name, int amount, int code) {
		super();
		this.name = name;
		this.amount = amount;
		this.code = code;
	}

	// Getters and setters
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
