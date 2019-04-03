package org.dbhaskaran.jersey_rest_basics;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {

	private int person_id;
	private String first_name;
	private String last_name;
	private String country;

	public Contact() {

	}

	public Contact(int person_id, String first_name, String last_name, String country) {
		this.person_id = person_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		String myCon = "ID: " + this.person_id + "\nName: " + this.first_name + " " + this.last_name + "\nCountry: "
				+ this.country;
		return myCon;
	}

}
