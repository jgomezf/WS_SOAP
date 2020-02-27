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
import javax.persistence.EntityNotFoundException;
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

    @Override
    public User Edit(User user) {
        try {
            em.getTransaction().begin();
            user = em.merge(user);
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
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getIduser();
                if (this.GetById(id) == null) {
                    try {
                        throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
                    } catch (NonexistentEntityException ex1) {
                        Logger.getLogger(UserJpaDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }                    
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return user;
    }

    @Override
    public void Delete(Integer id) {
        try {
            em.getTransaction().begin();            
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getIduser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(user);
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
            try {
                throw ex;
            } catch (Exception ex1) {
                Logger.getLogger(UserJpaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
