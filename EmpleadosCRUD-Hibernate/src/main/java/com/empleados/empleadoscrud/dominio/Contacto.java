package com.empleados.empleadoscrud.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contactos")
public class Contacto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_contacto")
    private Integer idContacto;
    
    private Integer telefono;
    private String mail;
    
//    @JoinColumn(name="id_empleado", referencedColumnName="id_empleado")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Empleado empleado;
    
    public Contacto() {
    }

    public Contacto(Integer telefono, String mail) {
        this.telefono = telefono;
        this.mail = mail;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Contacto:").append(idContacto);
        sb.append(", Telefono: ").append(telefono);
        sb.append(", Mail: ").append(mail);
        return sb.toString();
    }
}