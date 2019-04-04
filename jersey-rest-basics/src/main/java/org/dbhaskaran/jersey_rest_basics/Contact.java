package org.dbhaskaran.jersey_rest_basics;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	private int person_id;
	private String first_name;
	private String last_name;
	private String country;

	public Contact(int person_id, String first_name, String last_name, String country) {
		this.person_id = person_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
	}

	@Override
	public String toString() {
		String myCon = "ID: " + this.person_id + "\nName: " + this.first_name + " " + this.last_name + "\nCountry: "
				+ this.country;
		return myCon;
	}

}
