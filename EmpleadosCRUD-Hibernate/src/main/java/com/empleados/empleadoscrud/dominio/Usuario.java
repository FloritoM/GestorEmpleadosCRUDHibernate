package com.empleados.empleadoscrud.dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;
    
    @Column(name="usuario")
    private String user;
    
    @Column(name="contraseña")
    private String pass;
    
//    @JoinColumn(name="id_empleado", referencedColumnName="id_empleado")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Usuario: ").append(idUsuario);
        sb.append(", Username: ").append(user);
        sb.append(", Password: ").append(pass);
        return sb.toString();
    }
    
    
}
