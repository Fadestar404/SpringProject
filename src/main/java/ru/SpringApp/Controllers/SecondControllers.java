/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp.Controllers;

import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.SpringApp.Role;
import ru.SpringApp.User;
import ru.SpringApp.repos.UserRepo;

/**
 *
 * @author Admin
 */
@Controller
public class SecondControllers {
    @Autowired
    private UserRepo repo;
    @GetMapping("/registration")
    public String registration(){
        
        return"registration";
        
    }
    
    @PostMapping("/registration")
    public String addUser(User user, Model model){
        
        User userFromDb = repo.findByUsername(user.getUsername());
        
        if(userFromDb !=null){
            model.addAttribute("message", "User Exists!");
            return "registration";
        }
        
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        repo.save(user);
        
        
        return "redirect:/login";
    }
    
    
        
    
}
