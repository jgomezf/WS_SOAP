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
    
    User GetById(Integer id);
    
    void create(User user);
    
    User Edit(User user);
    
    void Delete(Integer id);
}
