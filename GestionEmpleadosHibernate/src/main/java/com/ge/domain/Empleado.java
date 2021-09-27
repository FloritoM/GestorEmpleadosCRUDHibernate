package com.ge.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private Integer idEmpleado;
    
    private String nombre;
    private String apellido;
    private String departamento;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Usuario usuario;
    
    @JoinColumn(name="id_contacto", referencedColumnName="id_contacto")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contacto contacto;
    
    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, String apellido, String departamento, Usuario usuario, Contacto contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.usuario = usuario;
        this.contacto = contacto;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{idEmpleado=").append(idEmpleado);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", departamento=").append(departamento);
        sb.append(", usuario=").append(usuario);
        sb.append(", contacto=").append(contacto);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}

