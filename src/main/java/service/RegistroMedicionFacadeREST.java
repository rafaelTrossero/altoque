/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.MedicionFacadeLocal;
import DAO.OpcionFacadeLocal;
import DAO.RegistroMedicionFacadeLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entidad.Medicion;
import entidad.Opcion;
import entidad.RegistroMedicion;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rat_5
 */
@Stateless
@Path("entidad.registromedicion")
public class RegistroMedicionFacadeREST extends AbstractFacade<RegistroMedicion> {

    @PersistenceContext(unitName = "roiPU")
    private EntityManager em;
    @EJB
    private RegistroMedicionFacadeLocal registroMedicionFacadeLocal;
    @EJB
    private MedicionFacadeLocal medicionFacadeLocal;
    @EJB
    private OpcionFacadeLocal opcionFacadeLocal;
    private Medicion medicion;
    private Opcion opcion;

    public RegistroMedicionFacadeREST() {
        super(RegistroMedicion.class);
        this.medicion = new Medicion();
        this.opcion = new Opcion();

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public RegistroMedicionFacadeLocal getRegistroMedicionFacadeLocal() {
        return registroMedicionFacadeLocal;
    }

    public void setRegistroMedicionFacadeLocal(RegistroMedicionFacadeLocal registroMedicionFacadeLocal) {
        this.registroMedicionFacadeLocal = registroMedicionFacadeLocal;
    }

    public MedicionFacadeLocal getMedicionFacadeLocal() {
        return medicionFacadeLocal;
    }

    public void setMedicionFacadeLocal(MedicionFacadeLocal medicionFacadeLocal) {
        this.medicionFacadeLocal = medicionFacadeLocal;
    }

    public OpcionFacadeLocal getOpcionFacadeLocal() {
        return opcionFacadeLocal;
    }

    public void setOpcionFacadeLocal(OpcionFacadeLocal opcionFacadeLocal) {
        this.opcionFacadeLocal = opcionFacadeLocal;
    }

    public Medicion getMedicion() {
        return medicion;
    }

    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RegistroMedicion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, RegistroMedicion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RegistroMedicion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RegistroMedicion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RegistroMedicion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PUT
    @Path("registromedicion")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String registrar_medicion(String json) {

        try {
            System.out.println("MEDICIoooooooON----" + medicion);
            final Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            RegistroMedicion registro = gson.fromJson(json, RegistroMedicion.class);
            System.out.println("json es----" + json);
            System.out.println("registroooo----mac" + registro.getMac());
            System.out.println("registroooo----" + registro.getOpciones().get(0).getBoton());
            System.out.println("registroooo----ts" + registro.getOpciones().get(0).getTs());

            medicion.setBateria(registro.getBateria().toString());
            medicion.setMac(registro.getMac().toString());
            medicion.setCreatedAt(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(registro.getOpciones().get(0).getTs()));
            System.out.println("setCreatedAt----" + medicion.getCreatedAt());
            
            this.medicionFacadeLocal.create(medicion);

            Iterator<Opcion> it1 = registro.getOpciones().iterator();

            while (it1.hasNext()) {

                Opcion tmp = it1.next();

                opcion.setBoton(tmp.getBoton());
                opcion.setTs(tmp.getTs());
                opcion.setMedicionId(medicion.getId());
                
                this.opcionFacadeLocal.create(opcion);

                System.out.println("OPCION----" + opcion);
            }

            return "200";
        } catch (Exception ex) {
            Logger.getLogger(RegistroMedicionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }
}
