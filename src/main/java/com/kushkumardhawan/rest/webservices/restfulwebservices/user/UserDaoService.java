package com.kushkumardhawan.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	private static int userCount = 9;
	
	static {
		users.add(new User(1, "Kush Dhawan", new Date()));
		users.add(new User(2, "Luv Dhawan", new Date()));
		users.add(new User(3, "Mayank Dhawan", new Date()));
		users.add(new User(4, "Tamana Dhawan", new Date()));
		users.add(new User(5, "Chanchal Dhawan", new Date()));
		users.add(new User(6, "Mother Dhawan", new Date()));
		users.add(new User(7, "Father Dhawan", new Date()));
		users.add(new User(8, "Grandpa Dhawan", new Date()));
		users.add(new User(9, "Grandma Dhawan", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if(user.getId() == id) return user;
		}
		return null;
	}
	
	public User deleteById(int id) {
	
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		
		
		return null;
	}
	

}
