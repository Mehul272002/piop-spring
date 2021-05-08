package com.codespring.poip;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
    @GetMapping("")
    public String viewHomePage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "register_user";
    }
    
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
       
         
        userRepo.save(user);
         
        return "login";
    }
    
    
    
}



