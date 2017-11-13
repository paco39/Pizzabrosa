/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paco Miranda
 */
@Entity
@Table(name = "estatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatus.findAll", query = "SELECT e FROM Estatus e"),
    @NamedQuery(name = "Estatus.findByIdEstatus", query = "SELECT e FROM Estatus e WHERE e.idEstatus = :idEstatus"),
    @NamedQuery(name = "Estatus.findByNombre", query = "SELECT e FROM Estatus e WHERE e.nombre = :nombre")})
public class Estatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstatus")
    private Integer idEstatus;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;

    public Estatus() {
    }

    public Estatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Estatus(Integer idEstatus, String nombre) {
        this.idEstatus = idEstatus;
        this.nombre = nombre;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatus != null ? idEstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatus)) {
            return false;
        }
        Estatus other = (Estatus) object;
        if ((this.idEstatus == null && other.idEstatus != null) || (this.idEstatus != null && !this.idEstatus.equals(other.idEstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estatus[ idEstatus=" + idEstatus + " ]";
    }
    
}
