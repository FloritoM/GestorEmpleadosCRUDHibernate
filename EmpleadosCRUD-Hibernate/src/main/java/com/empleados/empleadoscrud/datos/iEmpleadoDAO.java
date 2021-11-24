package com.empleados.empleadoscrud.datos;

import com.empleados.empleadoscrud.dominio.Empleado;
import java.util.List;

public interface iEmpleadoDAO {
    
    public List<Empleado> listar();
    
    public void insertar(Empleado e);
    
    public void eliminar(Empleado e);
    
    public void modificar(Empleado e);
    
    public Empleado encontrar(Empleado e);
}
