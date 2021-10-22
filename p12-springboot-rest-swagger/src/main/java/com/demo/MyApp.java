package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyApp {
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}


	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.ant("/books/**"))
			// .paths(RequestHandlerSelectors.basePackage("com.demo"))
			.build()
			.apiInfo(metadata())
			;
	}

	private ApiInfo metadata(){
		return new ApiInfoBuilder()
			.title("This is my first swagger")
			.description("Demo desc")
			.version("1.2.9")
			.license("www.license.url")
			.contact(new Contact("arun", "arun.facebook.page", "arun@gmail.com"))
			.build();
	}

	
}
