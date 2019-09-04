/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.OpcionFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author USUARIO
 */
@Named
@ViewScoped
public class RegistroMedicionMB implements Serializable {

    /**
     * Creates a new instance of registroMedicionMB
     */
    @EJB
    private OpcionFacadeLocal opcionFacadeLocal;

    Integer cantidadGenial;
    Integer cantidadMal;
    Integer cantidadBueno;
    Integer cantidadPesimo;

    public RegistroMedicionMB() {

        this.cantidadGenial = new Integer(0);
        this.cantidadMal = new Integer(0);
        this.cantidadBueno = new Integer(0);
        this.cantidadPesimo = new Integer(0);
    }

    public OpcionFacadeLocal getOpcionFacadeLocal() {
        return opcionFacadeLocal;
    }

    public void setOpcionFacadeLocal(OpcionFacadeLocal opcionFacadeLocal) {
        this.opcionFacadeLocal = opcionFacadeLocal;
    }

    public Integer getCantidadGenial() {
        return cantidadGenial;
    }

    public void setCantidadGenial(Integer cantidadGenial) {
        this.cantidadGenial = cantidadGenial;
    }

    public Integer getCantidadMal() {
        return cantidadMal;
    }

    public void setCantidadMal(Integer cantidadMal) {
        this.cantidadMal = cantidadMal;
    }

    public Integer getCantidadBueno() {
        return cantidadBueno;
    }

    public void setCantidadBueno(Integer cantidadBueno) {
        this.cantidadBueno = cantidadBueno;
    }

    public Integer getCantidadPesimo() {
        return cantidadPesimo;
    }

    public void setCantidadPesimo(Integer cantidadPesimo) {
        this.cantidadPesimo = cantidadPesimo;
    }

    public Integer buscarCantidadGenial() {

        this.setCantidadGenial(this.opcionFacadeLocal.findByBoton(1).size());

        return cantidadGenial;

    }

    public Integer buscarCantidadBueno() {

        this.setCantidadBueno(this.opcionFacadeLocal.findByBoton(2).size());

        return cantidadBueno;

    }

    public Integer buscarCantidadMal() {

        this.setCantidadMal(this.opcionFacadeLocal.findByBoton(3).size());

        return cantidadMal;

    }

    public Integer buscarCantidadPesimo() {

        this.setCantidadPesimo(this.opcionFacadeLocal.findByBoton(4).size());

        return cantidadPesimo;

    }

}
