/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Admin
 */
public enum Role implements GrantedAuthority {
    USER;
   

    @Override
    public String getAuthority() {
        return name();
        
    }
    
}
