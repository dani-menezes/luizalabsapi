package com.luizalabs.api.common;

import javax.ws.rs.core.Response;

/**
 * Define a contract of a common Facade
 * @author danielmenezes
 */
public interface CommonFacade<E extends CommonBean> {
	
	/**
	 * Save the actual state of the object
	 * @param entity E
	 */
	public Response save (E entity);
	
	/**
	 * Delete the object
	 * @param id Entity identification
	 */
	public Response delete (Integer id);
	
	/**
	 * Retrieve the object with id
	 * @param id Entity identification
	 * @return E
	 */
	public Response get (Integer id);
	
	/**
	 * Retrieve all objects
	 * @return List of E
	 */
	public Response getAll();
}
