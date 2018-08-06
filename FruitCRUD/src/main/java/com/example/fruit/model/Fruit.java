package com.example.fruit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String shape;
	private String season;
	private String color;
	private String taste;
	
	public Fruit() {
		
	}
	
	public Fruit(Integer id,String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", shape=" + shape + ", season=" + season + ", color=" + color
				+ ", taste=" + taste + ", getId()=" + getId() + ", getName()=" + getName() + ", getShape()="
				+ getShape() + ", getSeason()=" + getSeason() + ", getColor()=" + getColor() + ", getTaste()="
				+ getTaste() + ", toString()=" + super.toString() + "]";
	}
	
	
}
