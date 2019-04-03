package org.dbhaskaran.jersey_rest_basics;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("contacts")
public class ContactResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Contact> getContact() {
		Contact c1 = new Contact(1, "Emily", "McDowell", "Italy");
		Contact c2 = new Contact(1, "Ron", "Simon", "France");
		ArrayList<Contact> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		return list;
	}

}
