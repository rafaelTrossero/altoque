/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DAO.ConfiguracionesFacadeLocal;
import DAO.OpcionFacadeLocal;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
    @EJB
    private ConfiguracionesFacadeLocal configuracionesFacadeLocal;

    Float cantidadGenial;
    Float cantidadMal;
    Float cantidadBueno;
    Float cantidadPesimo;
    Integer cantidadTotalOpiniones;

    public RegistroMedicionMB() {

        this.cantidadGenial = new Float(0);
        this.cantidadMal = new Float(0);
        this.cantidadBueno = new Float(0);
        this.cantidadPesimo = new Float(0);
        this.cantidadTotalOpiniones = new Integer(0);

    }

    public OpcionFacadeLocal getOpcionFacadeLocal() {
        return opcionFacadeLocal;
    }

    public void setOpcionFacadeLocal(OpcionFacadeLocal opcionFacadeLocal) {
        this.opcionFacadeLocal = opcionFacadeLocal;
    }

    public Float getCantidadGenial() {
        return cantidadGenial;
    }

    public void setCantidadGenial(Float cantidadGenial) {
        this.cantidadGenial = cantidadGenial;
    }

    public Float getCantidadMal() {
        return cantidadMal;
    }

    public void setCantidadMal(Float cantidadMal) {
        this.cantidadMal = cantidadMal;
    }

    public Float getCantidadBueno() {
        return cantidadBueno;
    }

    public void setCantidadBueno(Float cantidadBueno) {
        this.cantidadBueno = cantidadBueno;
    }

    public Float getCantidadPesimo() {
        return cantidadPesimo;
    }

    public void setCantidadPesimo(Float cantidadPesimo) {
        this.cantidadPesimo = cantidadPesimo;
    }

    public Integer getCantidadTotalOpiniones() {
        return cantidadTotalOpiniones;
    }

    public void setCantidadTotalOpiniones(Integer cantidadTotalOpiniones) {
        this.cantidadTotalOpiniones = opcionFacadeLocal.findAll().size();
    }

    public String buscarCantidadGenial() {
        this.setCantidadTotalOpiniones(opcionFacadeLocal.findAll().size());
        this.setCantidadGenial((float) (this.opcionFacadeLocal.findByBoton(1).size() * 100) / cantidadTotalOpiniones);

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(cantidadGenial);

    }

    public String buscarCantidadBueno() {
        this.setCantidadTotalOpiniones(opcionFacadeLocal.findAll().size());

        this.setCantidadBueno((float) (this.opcionFacadeLocal.findByBoton(2).size() * 100) / cantidadTotalOpiniones);
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(cantidadBueno);

    }

    public String buscarCantidadMal() {

        this.setCantidadTotalOpiniones(opcionFacadeLocal.findAll().size());

        this.setCantidadMal((float) (this.opcionFacadeLocal.findByBoton(3).size() * 100) / cantidadTotalOpiniones);

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(cantidadMal);

    }

    public String buscarCantidadPesimo() {

        this.setCantidadTotalOpiniones(opcionFacadeLocal.findAll().size());

        this.setCantidadPesimo((float) (this.opcionFacadeLocal.findByBoton(4).size() * 100) / cantidadTotalOpiniones);

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(cantidadPesimo);

    }

    public String buscarPregunta() {

        String pregunta = configuracionesFacadeLocal.findById(1).getPregunta();

        return pregunta;

    }

}
