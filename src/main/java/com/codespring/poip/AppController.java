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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping
public class AppController {
 
	/*register section starts*/
	
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
    
    /*end register section*/
    
    /* LOign section start*/
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView showLoginPage() {
    	
		return new ModelAndView ("login");
        
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView LoginSucess() {
    	
    	return new ModelAndView("tempSucess");

    		 		
    	
    }
    
    /*end Login section*/
    
    
    /*Admin loign section*/
    
    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public ModelAndView showAdminPage() {
    	
		return new ModelAndView("admin");
        
    }
    
    @RequestMapping(value="/adminSucess",method=RequestMethod.GET)
    public ModelAndView adminSucess() {
    	
    	return new ModelAndView  ("adminSucess");

    		 		
    	
    }
    
    
    /* end Admin loign section*/
    
    
    /*Faculty Login*/
    
    @RequestMapping(value="/faculty",method=RequestMethod.GET)
    public ModelAndView showfacultyPage() {
    	
		return new ModelAndView("faculty");
        
    }
    
    @RequestMapping(value="/faculty",method=RequestMethod.POST)
    public ModelAndView facultySucess() {
    	
    	return new ModelAndView  ("facultySucess");

    		 		
    	
    }    
    
    /*end Faculty Login*/
    
    
    
    
    
    
    
}