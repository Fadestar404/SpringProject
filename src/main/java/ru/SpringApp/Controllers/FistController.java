/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp;

import ru.SpringApp.repos.MessageRepo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Controller
public class FistController {
    @Autowired
    MessageRepo mesRepo;
    
    @Value("${upload.path}")
    private String uploadPath;
    
    
    
    
    @GetMapping("/")
    public String home(){
        
        return"home";
        
    }
    
    @GetMapping("/main")
    public String main(@RequestParam(required=false)String filter,Model model){
        
      Iterable<Message>messages=mesRepo.findAll();
      
      if(filter !=null && !filter.isEmpty()){
          messages=mesRepo.findByText(filter);
      }
      else{
          messages=mesRepo.findAll();
      }
      model.addAttribute("messages", messages);
      model.addAttribute("filter",filter);
        
    
        
        
        
        return "main";
        
    }
    
    @PostMapping("/add")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file,
            @RequestParam String text,
            
            Map<String, Object> model) throws IOException {

        Message message = new Message(text, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {

            File upDir = new File(uploadPath);

            if (!upDir.exists()) {
                upDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            message.setFilename(resultFileName);
        }
        
        
        
        
        
        mesRepo.save(message);
        
        
        Iterable<Message>messages=mesRepo.findAll();
       
        model.put("messages", messages);
        
        return "main";
    }
    
    @GetMapping("/user-messages")
    public String userMessages(
    @AuthenticationPrincipal User currentUser,
           
            Model model
    ){
        
        
        Set<Message> messages = currentUser.getMessages();
        
        model.addAttribute("messages", messages);
        
      
       
        
        
        
        return "userMessages";
    }
    
   
        
    
}
