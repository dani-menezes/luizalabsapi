package com.luizalabs.api.dao;

import javax.inject.Singleton;

import com.luizalabs.api.bean.Marker;
import com.luizalabs.api.common.CommonDAO;

/**
 * Data Access Object contract of {@link Marker}
 * @author danielmenezes
 */
@Singleton
public interface MarkerDAO extends CommonDAO<Marker> {
		
	// use only the default methods
	
}
