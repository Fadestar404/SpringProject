/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

/**
 *
 * @author Admin
 */
@Entity
public class Message {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String text;
   
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")   
    private User author;
    
    private String filename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    
    public Message(){}

    public Message(String text, User user) {
        this.author=user;
        this.text = text;
        
    }
    
    public String getAuthorName(){
        return author!=null ? author.getUsername():"<none>";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

 
  
       public User getAuthor() {
        return  author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
    
    
    
}
