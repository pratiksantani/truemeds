package com.truemeds.datacleaner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class InputDetails {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "input_string")
	private String inputString;

	public InputDetails() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	@Override
	public String toString() {
		return "InputDetails [id=" + id + ", inputString=" + inputString + "]";
	}
}
