package com.luizalabs.api.common;

import java.io.Serializable;
import java.util.List;

/**
 * Define the contract of a common DAO [Data Access Object]
 * @author danielmenezes
 *
 * @param <E>
 */
public interface CommonDAO <E extends CommonBean> extends Serializable{
	
	/**
	 * Save the actual state of the object
	 * @param E entity
	 */
	public E saveOrUpdate (E entity);
	
	/**
	 * Delete the object
	 * @param E Entity
	 */
	public void delete (E entity);
	
	/**
	 * Retrieve the object with id
	 * @param id Entity identification
	 * @return E
	 */
	public E find (Integer id);
	
	/**
	 * Retrieve all objects
	 * @return List of E
	 */
	public List<E> findAll();
	
}
