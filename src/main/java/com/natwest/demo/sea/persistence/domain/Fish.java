package com.natwest.demo.sea.persistence.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fish {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String colour;
	private double length;
	private double weight;
	
	public Fish() {
		super();
	}

	public Fish(Long id, String name, String colour, double length, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.length = length;
		this.weight = weight;
	}

	public Fish(String name, String colour, double length, double weight) {
		super();
		this.name = name;
		this.colour = colour;
		this.length = length;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", name=" + name + ", colour=" + colour + ", length=" + length + ", weight=" + weight
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, id, length, name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fish other = (Fish) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	
	
}
