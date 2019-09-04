/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "botones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Botones.findAll", query = "SELECT b FROM Botones b")
    , @NamedQuery(name = "Botones.findById", query = "SELECT b FROM Botones b WHERE b.id = :id")
    , @NamedQuery(name = "Botones.findByBoton", query = "SELECT b FROM Botones b WHERE b.boton = :boton")
    , @NamedQuery(name = "Botones.findByValor", query = "SELECT b FROM Botones b WHERE b.valor = :valor")})
public class Botones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton")
    private int boton;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private String valor;

    public Botones() {
    }

    public Botones(Integer id) {
        this.id = id;
    }

    public Botones(Integer id, int boton, String valor) {
        this.id = id;
        this.boton = boton;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBoton() {
        return boton;
    }

    public void setBoton(int boton) {
        this.boton = boton;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Botones)) {
            return false;
        }
        Botones other = (Botones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Botones[ id=" + id + " ]";
    }
    
}
