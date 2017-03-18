package com.luizalabs.api.dao;

import javax.inject.Singleton;

import com.luizalabs.api.bean.Marker;
import com.luizalabs.api.common.AbstractDAO;

/**
 * Data Access Object implementation of {@link Marker}
 * @author danielmenezes
 */
@Singleton
public class MarkerDAOImpl extends AbstractDAO<Marker> implements MarkerDAO {
	
	/**Generated Serial UID Version. */
	private static final long serialVersionUID = -1219571376212363898L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<Marker> getEntityClass() {
		return Marker.class;
	}
	
}
