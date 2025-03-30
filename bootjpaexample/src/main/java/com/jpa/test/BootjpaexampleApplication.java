package com.jpa.test;

import java.awt.desktop.UserSessionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

import jakarta.persistence.Entity;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository= context.getBean(UserRepository.class);
		
//		//Creating the User Object
//		User user=new User();
//		user.setName("Pawan Sanat Pandey");
//		user.setCity("Nagpur");
//		user.setStatus("I am a SpringBoot developer");
//		
//		User user1 = userRepository.save(user);
//
//		
//		System.out.println(user1);
		
//		//Creating the user object
//		User user1=new User();
//		user1.setName("Sujal Pandey");
//		user1.setCity("Nagpur");
//		user1.setStatus("I am a Python developer");
//		
//		User user2=new User();
//		user2.setName("Satyam Shukla");
//		user2.setCity("Rewa");
//		user2.setStatus("I am a Web Developer");
//		
//		//Saving the user data
//		//Save is used to save the data and return it 
//		
//	    //User resultUser=userRepository.save(user2); Used to save the single user at a time
//	    
//		//For Saving Multiple instance or the user at the same time we use
//		//It uses the collection interface and we can create any thing like array,list and store multiple instance at the same time and return them
//		
//		//Creating the List
//		List<User>users= List.of(user1,user2);
//		Iterable<User>result=  userRepository.saveAll(users);
//		
//		//Traversing the List created
//		//Lambda function is used 
//		result.forEach(user->{
//			System.out.println(user);
//		});
		
//		System.out.println("Saved user"+resultUser);
//	    System.out.println("Done");
		
		
		//Updating the user 
//		Optional<User>optional= userRepository.findById(2);
//		
//		User user= optional.get();
//		
//		user.setName("Abhi Mishra");
//		User result= userRepository.save(user);
//		 
//		System.out.println(result);
		
		//How to get the data
		//findById(id)-Return optional containing the data
		
		Iterable<User>itr=userRepository.findAll();
		//Method 1
//		Iterator<User> iterator=itr.iterator();
		//It is an old method calling function and using it to iterate
//		while(iterator.hasNext()) {
//			User user=iterator.next();
//			System.out.println(user);
//		}
		
		//Method 2
		//We can use for each function directly
//		itr.forEach(new Consumer<User>() {
//
//			@Override
//			public void accept(User t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}
//			
//		});
		
		//Method 3
		//Using the lambda function
//		itr.forEach(user->{System.out.println(user);});
		
		
		//Deleting the user element 
		
		//Method1 one by one base on there id
//		userRepository.deleteById(53);
//		System.out.println("Deleted");
		
		//Method2 Deleting multiple user from the table / all the users
//		Iterable<User> allUsers = userRepository.findAll();
//		allUsers.forEach(user->{System.out.println(user);});
//		userRepository.deleteAll(allUsers);	
		
//		List<User>users= userRepository.findByName("Abhi Mishra");
//		
//		users.forEach(e->{System.out.println(e);});
		
//		List<User>users=userRepository.findByNameAndCity("Abhi Mishra", "Rewa");
//		users.forEach(e->{System.out.println(e);});
		
		List<User>allUser= userRepository.getAllUser();
		allUser.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("_____________________________________");
		
		List<User>userByName=userRepository.getUserByName("Sujal Pandey");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("_____________________________________");
		
		userRepository.getUsers().forEach(e->System.out.println(e));		
	}

}
