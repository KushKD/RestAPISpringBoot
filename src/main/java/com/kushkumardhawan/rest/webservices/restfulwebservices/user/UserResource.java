package com.kushkumardhawan.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired 
	private UserDaoService service;
	
	@Autowired
	private MessageSource messageSource;
	
	
	
	public UserDaoService getService() {
		return service;
	}
	
	



	public void setService(UserDaoService service) {
		this.service = service;
	}

	//retrieveAllUsers
	@RequestMapping(method=RequestMethod.GET, path="/users")
	public List<User> retrieveAllUsers(){
		List<User> getAllUser = service.findAll();
		return getAllUser;
	}
	
			//retrieveUser(int id)
		@RequestMapping(method=RequestMethod.GET, path="/users/{id}")
		public User retrieveUser(@PathVariable int id){
			User getUser = service.findOne(id);
			if(getUser == null) 
				throw new UserNotFoundException("ID:- "+ id);
			
			//"all-users", SERVER_PATH + "/users"
			// retrieveUser
//			Resource<User> resource = new Resource<User>(getUser);
//			ControllerLinkBuilder  linkTo =	linkTo(methodOn(this.getClass()).retrieveAllUser); 
//			resource.add(linkTo.withRel("all-users"));
			return getUser;
		}
		
		//Detils of the USer is te Input
		// URI of the User is the Output
		@RequestMapping(method=RequestMethod.POST, path="/users")
		public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
			User savedUser = service.saveUser(user);
			
			//Created
			// /user/10
			
			URI locarion = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(savedUser.getId()).toUri();
			return ResponseEntity.created(locarion).build();
		}
		
		//deleteUser(int id)
		@RequestMapping(method=RequestMethod.DELETE, path="/users/{id}")
		public User deleteUser(@PathVariable int id){
			User getUser = service.deleteById(id);
			if(getUser == null) {
				throw new UserNotFoundException("ID:- "+ id);
			}
			return getUser;
		}
		
		
		//GET
		//URI  /hello-world
		//Create a Method to Return HelloWorld String
		@RequestMapping(method = RequestMethod.GET,path="/hello-world-inter")
		public String helloWorld(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
			return messageSource.getMessage("good.morning.message", null ,locale);
			
			//LocaleContextHolder.getLocale(); instead of @RequestHeader
		}
		
		

}
