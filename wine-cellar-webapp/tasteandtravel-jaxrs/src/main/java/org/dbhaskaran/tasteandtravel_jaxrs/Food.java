package org.dbhaskaran.tasteandtravel_jaxrs;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Deepak Bhaskaran
 */
@XmlRootElement
public class Food {

	private int id;

	private String name;

	private String category;

	private String country;

	private float rating;

	private String description;

	private String picture;

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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
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

}
