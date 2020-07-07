/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ru.SpringApp.User;

/**
 *
 * @author Admin
 */
public interface UserRepo extends CrudRepository<User,Long> {
    
   User findByUsername(String username);
    
}
