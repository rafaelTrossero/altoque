/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Medicion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface MedicionFacadeLocal {

    void create(Medicion medicion);

    void edit(Medicion medicion);

    void remove(Medicion medicion);

    Medicion find(Object id);

    List<Medicion> findAll();

    List<Medicion> findRange(int[] range);

    int count();
    
}
