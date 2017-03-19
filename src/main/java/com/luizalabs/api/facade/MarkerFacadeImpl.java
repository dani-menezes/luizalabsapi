package com.luizalabs.api.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.luizalabs.api.bean.Marker;
import com.luizalabs.api.dao.MarkerDAO;

/**
 * Expose the public methods of the services related to the Product bean
 * @author danielmenezes
 *
 */
@Path("/marker")
public class MarkerFacadeImpl implements MarkerFacade {
	
	/** Data Access Object. */
	@Inject
	private MarkerDAO markerDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path(value = "/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Integer id) {
		try {
			Marker marker =  this.markerDAO.find(id);
			// 200 -> success
			return Response.status(Status.OK).entity(marker).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			// 500 -> Internal error
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@GET
	@Path(value = "/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			List<Marker> imageList =  this.markerDAO.findAll();
			// 200 -> success
			return Response.status(Status.OK).entity(imageList).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			// 500 -> Internal error
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
    @DELETE
    @Path(value = "/delete/{id}")
    public Response delete(@PathParam("id") Integer id) {
    	try {
    		Marker marker = this.markerDAO.find(id);
    		this.markerDAO.delete(marker);
    		// 200 -> success
    		return Response.status(Status.OK).entity("Marker has been successfully deleted").type(MediaType.APPLICATION_JSON).build();
    	} catch (Exception e) {
    		e.printStackTrace();
    		// 500 -> Internal error
    		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	/**
	 * {@inheritDoc}
	 */
	@POST
	@Path(value = "/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Marker entity) {
		try {
			this.markerDAO.saveOrUpdate(entity);
			// 200 -> success
			return Response.status(Status.OK).entity("Marker has been successfully saved").build();
		} catch (Exception e) {
			e.printStackTrace();
			// 500 -> Internal error
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
