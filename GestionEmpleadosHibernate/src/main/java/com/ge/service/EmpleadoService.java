package com.ge.service;

import com.ge.data.EmpleadoDAO;
import com.ge.domain.Empleado;
import java.util.List;

public class EmpleadoService {
    
    private EmpleadoDAO dao = new EmpleadoDAO();
    
    public void verEmpleados(){
        List<Empleado> empleados = dao.listar();
        iterador(empleados);
    }
    
    public void agregarEmpleado(Empleado empleado){
        dao.insertar(empleado);
    }
    
    public void eliminarEmpleado(Empleado empleado){
        dao.eliminar(empleado);
    }
    
    public void modificarEmpleado(Empleado empleado){
        dao.modificar(empleado);
    }
    
    public Empleado encontrarEmpleado(Empleado empleado){
        return dao.encontrar(empleado);
    }
    
//    public boolean validarEncontrar(Empleado empleado){
//         return dao.validarEncontrar(empleado);
//    }
//    
    public void iterador(List<Empleado> empleados){
        for(Empleado e: empleados){
            System.out.println("ID: " + e.getIdEmpleado());
            System.out.println("Nombre: " + e.getNombre() + " " + e.getApellido() + ", Departamento: " + e.getDepartamento());
            System.out.println("Mail: " + e.getContacto().getMail() + ", Telefono: " + e.getContacto().getTelefono());
            System.out.println("Usuario: " + e.getUsuario().getUser() + ", Password: " + e.getUsuario().getPass());
        }
    }
}
