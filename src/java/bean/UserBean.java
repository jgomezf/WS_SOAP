/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UserDAO;
import dao.UserJpaDao;
import entidades.User;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UserBean {
    private UserDAO userDAO;
    
    public UserBean(){
        userDAO = new UserJpaDao();
    }
    
    public List<User> Get(){
        return userDAO.Get();
    }
    
    public User GetById(Integer id){
        return userDAO.GetById(id);
    }
    
    public void create(User user){
        userDAO.create(user);
    }
    
}
