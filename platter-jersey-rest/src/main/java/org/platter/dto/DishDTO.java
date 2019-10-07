package org.platter.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DishDTO {

	private int id;
	private String name;
	private String category;
	private String country;
	private String region;
	private String description;
	private String picture;

	public DishDTO() {

	}

	public DishDTO(int id, String name, String category, String country, String region, String description,
			String picture) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.country = country;
		this.region = region;
		this.description = description;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		String myDish = "ID: " + this.id + "\nName: " + this.name + " " + "\nCountry: " + this.country;
		return myDish;
	}

}
