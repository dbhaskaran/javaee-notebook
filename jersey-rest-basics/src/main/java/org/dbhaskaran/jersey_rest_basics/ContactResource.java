package org.dbhaskaran.jersey_rest_basics;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("contacts")
public class ContactResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Contact getContact() {
		System.out.println("Inside Contacts...");
		Contact c1 = new Contact(1, "Emily", "McDowell", "Italy");
		return c1;
	}

}
