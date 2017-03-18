package com.luizalabs.api.common;

import java.io.Serializable;

/**
 * Define the contract of a common bean
 * @author danielmenezes
 */
public interface CommonBean extends Serializable{
	
	/**
	 * Return the entity identification. 
	 * @return identification
	 */
	public Integer getId();
	
	/**
	 * Set the entity identification.
	 * @param id identification
	 */
	public void setId(Integer id);
	
}
