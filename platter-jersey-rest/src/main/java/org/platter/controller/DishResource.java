package org.platter.controller;

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

import org.platter.dao.DishDAO;
import org.platter.dto.DishDTO;

@Path("dishes")
public class DishResource {

	private DishDAO c1 = new DishDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DishDTO> getDishes() {
		return c1.findAll();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public DishDTO getDishById(@PathParam("id") String id) {
		return c1.findById(id);
	}

	@GET
	@Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DishDTO> findByName(@PathParam("query") String query) {
		return c1.findByName(query);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DishDTO create(DishDTO dish) {
		System.out.println("Creating Dish");
		return c1.create(dish);
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DishDTO update(DishDTO dish) {
		System.out.println("Updating Dish: " + dish.getName());
		c1.update(dish);
		return dish;
	}

	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id) {
		c1.remove(id);
	}

}
