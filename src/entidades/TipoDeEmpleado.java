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
@Table(name = "tipo de empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeEmpleado.findAll", query = "SELECT t FROM TipoDeEmpleado t"),
    @NamedQuery(name = "TipoDeEmpleado.findByIdTipodeempleado", query = "SELECT t FROM TipoDeEmpleado t WHERE t.idTipodeempleado = :idTipodeempleado"),
    @NamedQuery(name = "TipoDeEmpleado.findByNombre", query = "SELECT t FROM TipoDeEmpleado t WHERE t.nombre = :nombre")})
public class TipoDeEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo de empleado")
    private Integer idTipodeempleado;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;

    public TipoDeEmpleado() {
    }

    public TipoDeEmpleado(Integer idTipodeempleado) {
        this.idTipodeempleado = idTipodeempleado;
    }

    public TipoDeEmpleado(Integer idTipodeempleado, String nombre) {
        this.idTipodeempleado = idTipodeempleado;
        this.nombre = nombre;
    }

    public Integer getIdTipodeempleado() {
        return idTipodeempleado;
    }

    public void setIdTipodeempleado(Integer idTipodeempleado) {
        this.idTipodeempleado = idTipodeempleado;
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
        hash += (idTipodeempleado != null ? idTipodeempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeEmpleado)) {
            return false;
        }
        TipoDeEmpleado other = (TipoDeEmpleado) object;
        if ((this.idTipodeempleado == null && other.idTipodeempleado != null) || (this.idTipodeempleado != null && !this.idTipodeempleado.equals(other.idTipodeempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoDeEmpleado[ idTipodeempleado=" + idTipodeempleado + " ]";
    }
    
}
