package com.kushkumardhawan.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kushkumardhawan.rest.webservices.restfulwebservices.Beans.HelloWorldBean;

//Controller
@RestController
public class HelloWorldController {
	
	
	
	//GET
	//URI  /hello-world
	//Create a Method to Return HelloWorld String
	@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//GET
	//URI  /hello-world-bean
	//Create a Method to Return HelloWorld String
	@RequestMapping(method = RequestMethod.GET,path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
		
	//GET
	//URI  /hello-world/path-variable/{name}
	//Create a Method to Return HelloWorld String
	@RequestMapping(method = RequestMethod.GET,path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s",name));
	}
			
		
		

}
