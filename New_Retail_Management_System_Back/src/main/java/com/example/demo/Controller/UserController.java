package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import com.example.demo.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/User")
public class UserController {

	
	@Autowired
	UserService useservice ;
	List<User> list;

	
	@PostMapping("/adduser")
	public String addUser (@RequestBody User user)
	{
		boolean b =useservice.isAddNewUser(user);
		if(b)
		{
			return "user Added";
		}
		
		return "User Not added";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
	    String username = user.getUserName();
	    String password = user.getPassword();
	    
	    User loggedInUser = useservice.login(username, password);

	    if (loggedInUser != null) {
	        int roleId = loggedInUser.getRoleId();
	        if (roleId == 1) return "redirect:/admin/dashboard";
	        else if (roleId == 2) return "redirect:/manager/dashboard";
	        else if (roleId == 3) return "redirect:/cashier/dashboard";
	        else return "redirect:/login?error=unknownrole";
	    } else {
	        return "redirect:/login?error=invalid";
	    }
		
	}
	
	  


	 @GetMapping("/viewAllUsers")
	    public List<User> getAllUsers() {
	        List<User> list = useservice.getAllUser();
	        if (list.size() != 0) {
	            return list;
	        } else {
	            throw new UserNotFoundException("There is no user data in the database table.");
	        }
	 }
	

	

    @GetMapping("/searchuser/{id}")
    public User searchUserById(@PathVariable int id) {
        User user = useservice.searchUserById(id);

        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public User deleteUserById(@PathVariable int id) {
        User user = useservice.deletehUserById(id);

        if (user != null) {
            return user ;
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
    }

    @PutMapping("/updateuser/{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User updatedUser) {
        User user = useservice.updateUserById(id, updatedUser);

        if (user != null) {
            return user; 
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
    }
}
