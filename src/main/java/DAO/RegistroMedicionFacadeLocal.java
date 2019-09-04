/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.RegistroMedicion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface RegistroMedicionFacadeLocal {

    void create(RegistroMedicion registroMedicion);

    void edit(RegistroMedicion registroMedicion);

    void remove(RegistroMedicion registroMedicion);

    RegistroMedicion find(Object id);

    List<RegistroMedicion> findAll();

    List<RegistroMedicion> findRange(int[] range);

    int count();
    
}
