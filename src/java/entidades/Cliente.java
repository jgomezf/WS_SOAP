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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByClienteName", query = "SELECT c FROM Cliente c WHERE c.clienteName = :clienteName"),
    @NamedQuery(name = "Cliente.findByClienteEmail", query = "SELECT c FROM Cliente c WHERE c.clienteEmail = :clienteEmail"),
    @NamedQuery(name = "Cliente.findByClienteTel", query = "SELECT c FROM Cliente c WHERE c.clienteTel = :clienteTel"),
    @NamedQuery(name = "Cliente.findByClienteCiudad", query = "SELECT c FROM Cliente c WHERE c.clienteCiudad = :clienteCiudad"),
    @NamedQuery(name = "Cliente.findByClienteDireccion", query = "SELECT c FROM Cliente c WHERE c.clienteDireccion = :clienteDireccion"),
    @NamedQuery(name = "Cliente.findByClienteNumDocumento", query = "SELECT c FROM Cliente c WHERE c.clienteNumDocumento = :clienteNumDocumento")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteName")
    private String clienteName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteEmail")
    private String clienteEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clienteTel")
    private String clienteTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clienteCiudad")
    private String clienteCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clienteDireccion")
    private String clienteDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clienteNumDocumento")
    private String clienteNumDocumento;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String clienteName, String clienteEmail, String clienteTel, String clienteCiudad, String clienteDireccion, String clienteNumDocumento) {
        this.idcliente = idcliente;
        this.clienteName = clienteName;
        this.clienteEmail = clienteEmail;
        this.clienteTel = clienteTel;
        this.clienteCiudad = clienteCiudad;
        this.clienteDireccion = clienteDireccion;
        this.clienteNumDocumento = clienteNumDocumento;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteTel() {
        return clienteTel;
    }

    public void setClienteTel(String clienteTel) {
        this.clienteTel = clienteTel;
    }

    public String getClienteCiudad() {
        return clienteCiudad;
    }

    public void setClienteCiudad(String clienteCiudad) {
        this.clienteCiudad = clienteCiudad;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public String getClienteNumDocumento() {
        return clienteNumDocumento;
    }

    public void setClienteNumDocumento(String clienteNumDocumento) {
        this.clienteNumDocumento = clienteNumDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
