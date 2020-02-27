/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.UserBean;
import entidades.User;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "UserSW")
public class UserSW {

    private UserBean userBean;
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Get")
    public List<User> Get() {
        userBean = new UserBean();
        return userBean.Get();
    }

    /**
     * Web service operation
     * @param user
     */
    @WebMethod(operationName = "Create")
    @Oneway
    public void Create(@WebParam(name = "user") User user) {
        userBean = new UserBean();
        userBean.create(user);
    }

    /**
     * Web service operation
     * @param id
     */
    @WebMethod(operationName = "GetById")
    public User GetById(@WebParam(name = "id") Integer id) {
        userBean = new UserBean();
        return userBean.GetById(id);
    }
    
    
}
