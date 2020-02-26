/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.User;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface UserDAO {
    
    List<User> Get();
    
    void create(User user);
}
