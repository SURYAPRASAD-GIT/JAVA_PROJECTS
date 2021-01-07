package com.snp.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snp.spring.exceptions.ResourceNotFoundException;
import com.snp.spring.model.Users;
import com.snp.spring.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class UsersController {

	@Autowired
	private UserRepository userRepository;
	
	//get all Users
     @GetMapping("/users")
     public List<Users> getAllUsers(){
    	 return userRepository.findAll();
     }
     
     //register User 
     @PostMapping("/register_user")
     public Users insertUser(@RequestBody Users user) {
    	 return userRepository.save(user);
     }
     
     // get User by Id
     @GetMapping("/user/{id}")
     public ResponseEntity<Users> getUserById(@PathVariable Long id) {
    	 Users user= userRepository.findById(id)
    	.orElseThrow(() -> new ResourceNotFoundException("User not exits with ID : "+id));
    	 return ResponseEntity.ok(user);
     }
     
     // update User
     @PutMapping("/update_user/{id}")
     public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users userDetails){
    	 Users user= userRepository.findById(id)
    		    	.orElseThrow(() -> new ResourceNotFoundException("User not exits with ID : "+id));
    		    	
    	 user.setFirstName(userDetails.getFirstName());
    	 user.setLastName(userDetails.getLastName());
    	 user.setEmailId(userDetails.getEmailId());
    	 
    	 Users updatedUser = userRepository.save(user);
    	 return ResponseEntity.ok(updatedUser);
    	 
     }
     
     //delete User by ID
     @DeleteMapping("/delete_user/{id}")
     public ResponseEntity<Map<String,Long>> deleteUser(@PathVariable Long id){
    	 Users user= userRepository.findById(id)
 		    	.orElseThrow(() -> new ResourceNotFoundException("User not exits with ID : "+id));

    	 userRepository.delete(user);
    	 Map<String, Long> response=new HashMap<String, Long>();
    	 response.put("Deleted user With ID: ", id);
         return ResponseEntity.ok(response);
     }
     
}
