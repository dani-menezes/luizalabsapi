package com.luizalabs.api.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Register the DAOs and Facades used on project
 * @author danielmenezes
 *
 */
public class ApplicationConfig extends ResourceConfig {

	/**
	 * Method used to register the services.
	 */
    public ApplicationConfig() {
    	register(new ApplicationBinder());
        packages(true, "com.luizalabs.api.facade");
    }
}