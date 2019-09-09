/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Configuraciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ConfiguracionesFacade extends AbstractFacade<Configuraciones> implements ConfiguracionesFacadeLocal {

    @PersistenceContext(unitName = "roiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionesFacade() {
        super(Configuraciones.class);
    }

    @Override
    public Configuraciones findById(Integer id) {
        em.getEntityManagerFactory().getCache().evictAll();
         try {
           
            Query q = em.createNamedQuery("Configuraciones.findById");
            q.setParameter("id", id);
           
            
            return  (Configuraciones) q.getSingleResult();
            
        } catch (Exception e) {
            return null;
        }
    }
    
}
