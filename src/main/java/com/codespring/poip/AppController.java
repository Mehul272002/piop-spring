package com.codespring.poip;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
    
    
   
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "register_user";
    }
    
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
       
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         String encodedPassword = encoder.encode(user.getPassword());
         user.setPassword(encodedPassword);
          userRepo.save(user);
         
        return "login";
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
    	org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(authentication == null|| authentication instanceof AnonymousAuthenticationToken) {
    		return "login";
    	}
		return "tempSucess";
        
    }

    @GetMapping("/tempSucess")
    public String LoginSucess() {
    	
    	return "tempSucess";

    		 		
    	
    }
    
}