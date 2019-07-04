package com.myapp.ws.rest.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.myapp.ws.rest.endpoint.OrdersRestEndpoint;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

@Configuration

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		BeanConfig swaggerConfig = new BeanConfig();
		swaggerConfig.setBasePath("/api");
		SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

		packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());

		register(OrdersRestEndpoint.class);

	}

}