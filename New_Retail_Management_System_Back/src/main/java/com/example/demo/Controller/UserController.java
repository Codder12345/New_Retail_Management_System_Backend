package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserController {
	
	@Autowired
	UserService useservice ;
	
	@PostMapping
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
	        int roleId = loggedInUser.getRoleID();
	        if (roleId == 1) return "redirect:/admin/dashboard";
	        else if (roleId == 2) return "redirect:/manager/dashboard";
	        else if (roleId == 3) return "redirect:/cashier/dashboard";
	        else return "redirect:/login?error=unknownrole";
	    } else {
	        return "redirect:/login?error=invalid";
	    }
		
	}


}
