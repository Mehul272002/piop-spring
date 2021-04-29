package com.codespring.poip;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class AppController {
 
    
    @GetMapping("")
    public String viewHomePage() {
        return "login";
    }
}
