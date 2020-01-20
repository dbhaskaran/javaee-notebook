package org.dbhaskaran.tasteandtravel_jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/food")
public class FoodResource {

	FoodDAO dao = new FoodDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Food> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}

	@GET
	@Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Food> findByName(@PathParam("query") String query) {
		System.out.println("findByName: " + query);
		return dao.findByName(query);
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Food findById(@PathParam("id") String id) {
		System.out.println("findById " + id);
		return dao.findById(Integer.parseInt(id));
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Food create(Food wine) {
		System.out.println("creating wine");
		return dao.create(wine);
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Food update(Food wine) {
		System.out.println("Updating wine: " + wine.getName());
		dao.update(wine);
		return wine;
	}

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id) {
		dao.remove(id);
	}

}
