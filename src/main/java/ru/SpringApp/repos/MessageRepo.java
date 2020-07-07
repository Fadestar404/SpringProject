/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.SpringApp.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ru.SpringApp.Message;

/**
 *
 * @author Admin
 */
public interface MessageRepo extends CrudRepository<Message,Long> {
    
    List<Message>findByText(String text);
    
}
