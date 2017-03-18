package com.luizalabs.api.facade;

import javax.ws.rs.Path;

import com.luizalabs.api.bean.Marker;
import com.luizalabs.api.common.CommonFacade;

/**
 * Expose the public methods of the services related to the {@link Marker} bean
 * @author danielmenezes
 *
 */
@Path("/marker")
public interface MarkerFacade extends CommonFacade<Marker> {
	// Use only the default methods
}
