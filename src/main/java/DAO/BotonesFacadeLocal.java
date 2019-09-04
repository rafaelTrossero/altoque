/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Botones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface BotonesFacadeLocal {

    void create(Botones botones);

    void edit(Botones botones);

    void remove(Botones botones);

    Botones find(Object id);

    List<Botones> findAll();

    List<Botones> findRange(int[] range);

    int count();
    
}
