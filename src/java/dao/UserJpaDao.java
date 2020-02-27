/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.User;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author LENOVO
 */
public class UserJpaDao implements UserDAO, Serializable{

    private EntityManager em;
    private EntityManagerFactory emf;
            
    public UserJpaDao(){
        emf = Persistence.createEntityManagerFactory("SOAP_WSPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<User> Get() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(User.class));
        //Query q = em.createQuery("SELECT u FROM User u");
        
        List<User> users = em.createQuery(cq).getResultList();
        
        return users;
    }

    @Override
    public void create(User user) {
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                try {
                    throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
                } catch (RollbackFailureException ex1) {
                    Logger.getLogger(UserJpaDao.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }    

    @Override
    public User GetById(Integer id) {
        return em.find(User.class, id);
    }
}
