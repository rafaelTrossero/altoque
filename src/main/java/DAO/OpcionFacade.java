/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Opcion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rat_5
 */
@Stateless
public class OpcionFacade extends AbstractFacade<Opcion> implements OpcionFacadeLocal {

    @PersistenceContext(unitName = "roiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionFacade() {
        super(Opcion.class);
    }

    @Override
    public List<Opcion> findByBoton(Integer boton) {
         try {
           
            Query q = em.createNamedQuery("Opcion.findByBoton");
            q.setParameter("boton", boton);
           
            
            return (List<Opcion>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
