package com.myapp.ws.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestWsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWsDemoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.myapp.ws.rest.endpoint")).paths(PathSelectors.any())
				.build().enable(true).apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		StringVendorExtension vendorExtension = new StringVendorExtension("", "");
		Collection<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendorExtension);

		Contact contactInfo = new Contact("Pradeep", "itc", "pradeepmurthy@gmail.com");

		return new ApiInfo("SpringBoot-Swagger2-JaxRS",
				" spring boot " + "web app using jaxrs with swagger and springfox.", "1.0", "Orders Demo", contactInfo,
				"Apache 2.0", "www.apache.org", vendorExtensions);
	}

}