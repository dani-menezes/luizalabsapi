package com.avenuecode.api.facade;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.inject.Singleton;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.luizalabs.api.bean.Marker;
import com.luizalabs.api.dao.MarkerDAO;
import com.luizalabs.api.dao.MarkerDAOImpl;
import com.luizalabs.api.facade.MarkerFacade;
import com.luizalabs.api.facade.MarkerFacadeImpl;

/**
 * Test methods of {@link MarkerFacade} service.
 * @author danielmenezes
 */
public class MarkerFacadeTest extends JerseyTest {
	
	@Mock
	private MarkerFacade markerFacade;

	@Override
	public Application configure() {
		MockitoAnnotations.initMocks(this);
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		ResourceConfig config = new ResourceConfig(MarkerFacadeImpl.class);
		config.register(new InjectableProvider());
		return config;
	}
	
	@Test
    public void methodSaveTest() {
		Entity<Marker> product = Entity.entity(getMockMarker(), MediaType.APPLICATION_JSON_TYPE);
        Response output = target("/marker/save").request().post(product);
        assertEquals("should return status 200", 200, output.getStatus());
    }
	
	@Test
	public void methodGetTest() {
		Response output = target("/marker/get/1").request().get();
		assertEquals("should return status 200", 200, output.getStatus());
		assertNotNull("Should return Product", output.getEntity());
	}
	
	@Test
	public void methodGetAllTest() {
		Response output = target("/marker/getAll").request().get();
		assertEquals("should return status 200", 200, output.getStatus());
		assertNotNull("Should return the Product List", output.getEntity());
	}
	
	@Test
	public void methodDeleteTest() {
		Response output = target("/marker/delete/1").request().delete();
		assertEquals("should return status 200", 200, output.getStatus());
	}
	
	/**
	 * Mock object that will be returned
	 * @return the product object
	 */
	private Marker getMockMarker() {
		Marker product = new Marker();
		product.setId(1);
		product.setLabel("Luizalabs Franca");
		product.setLat(-20.57D);
		product.setLng(-47.48D);
		return product;
	}

	
	/**
	 * Create an Injectable Provider that with bind this factory to the marker facade.
	 * When the provide is invoked a mock service object will be returned.
	 * When dispose is invoked the mock service object will be assigned null.
	 */
	class InjectableProvider extends AbstractBinder implements Factory<MarkerFacade> {
		
		@Override
		protected void configure() {
			bind(MarkerDAOImpl.class).to(MarkerDAO.class).in(Singleton.class);
			bindFactory(this).to(MarkerFacade.class).in(Singleton.class);
		}

		public MarkerFacade provide() {
			return markerFacade;
		}

		public void dispose(MarkerFacade facade) {
			markerFacade = null;
		}
	}
}
