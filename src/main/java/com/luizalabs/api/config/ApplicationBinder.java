package com.luizalabs.api.config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.luizalabs.api.dao.MarkerDAO;
import com.luizalabs.api.dao.MarkerDAOImpl;
import com.luizalabs.api.facade.MarkerFacade;
import com.luizalabs.api.facade.MarkerFacadeImpl;

/**
 * Bind the Services to CDI can inject.
 * @author danielmenezes
 */
public class ApplicationBinder extends AbstractBinder {

	/**
	 * {@inheritDoc}
	 */
    @Override
    protected void configure() {
    	// facade
        bind(MarkerFacadeImpl.class).to(MarkerFacade.class).in(Singleton.class);
        // dao
        bind(MarkerDAOImpl.class).to(MarkerDAO.class).in(Singleton.class);
    }
}