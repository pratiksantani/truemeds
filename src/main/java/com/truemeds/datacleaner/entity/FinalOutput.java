package com.truemeds.datacleaner.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pratik_santani_java_output_updated")
public class FinalOutput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "original_string")
	private String originalString;

	@Column(name = "cleaned_string")
	private String cleanedString;

	@Column(name = "number_of_steps")
	private int numberOfSteps;

	@Column(name = "created")
	private Timestamp created;

	public FinalOutput() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public String getCleanedString() {
		return cleanedString;
	}

	public void setCleanedString(String cleanedString) {
		this.cleanedString = cleanedString;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "FinalOutput [id=" + id + ", originalString=" + originalString + ", cleanedString=" + cleanedString
				+ ", numberOfSteps=" + numberOfSteps + ", created=" + created + "]";
	}
}
