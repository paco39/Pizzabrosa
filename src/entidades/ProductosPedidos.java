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
@Table(name = "productos pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosPedidos.findAll", query = "SELECT p FROM ProductosPedidos p"),
    @NamedQuery(name = "ProductosPedidos.findByIdProductospedidos", query = "SELECT p FROM ProductosPedidos p WHERE p.idProductospedidos = :idProductospedidos"),
    @NamedQuery(name = "ProductosPedidos.findByIdProducto", query = "SELECT p FROM ProductosPedidos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductosPedidos.findByIdPedido", query = "SELECT p FROM ProductosPedidos p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "ProductosPedidos.findByPreciodeproducto", query = "SELECT p FROM ProductosPedidos p WHERE p.preciodeproducto = :preciodeproducto"),
    @NamedQuery(name = "ProductosPedidos.findByProductoscomprados", query = "SELECT p FROM ProductosPedidos p WHERE p.productoscomprados = :productoscomprados")})
public class ProductosPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductos pedidos")
    private Integer idProductospedidos;
    @Basic(optional = false)
    @Column(name = "idProducto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "idPedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "Precio de producto")
    private double preciodeproducto;
    @Basic(optional = false)
    @Column(name = "Productos comprados")
    private int productoscomprados;

    public ProductosPedidos() {
    }

    public ProductosPedidos(Integer idProductospedidos) {
        this.idProductospedidos = idProductospedidos;
    }

    public ProductosPedidos(Integer idProductospedidos, int idProducto, int idPedido, double preciodeproducto, int productoscomprados) {
        this.idProductospedidos = idProductospedidos;
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.preciodeproducto = preciodeproducto;
        this.productoscomprados = productoscomprados;
    }

    public Integer getIdProductospedidos() {
        return idProductospedidos;
    }

    public void setIdProductospedidos(Integer idProductospedidos) {
        this.idProductospedidos = idProductospedidos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getPreciodeproducto() {
        return preciodeproducto;
    }

    public void setPreciodeproducto(double preciodeproducto) {
        this.preciodeproducto = preciodeproducto;
    }

    public int getProductoscomprados() {
        return productoscomprados;
    }

    public void setProductoscomprados(int productoscomprados) {
        this.productoscomprados = productoscomprados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductospedidos != null ? idProductospedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPedidos)) {
            return false;
        }
        ProductosPedidos other = (ProductosPedidos) object;
        if ((this.idProductospedidos == null && other.idProductospedidos != null) || (this.idProductospedidos != null && !this.idProductospedidos.equals(other.idProductospedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductosPedidos[ idProductospedidos=" + idProductospedidos + " ]";
    }
    
}
