package com.ge.client;

import com.ge.domain.Contacto;
import com.ge.domain.Empleado;
import com.ge.domain.Usuario;
import com.ge.service.EmpleadoService;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        EmpleadoService empleadoService = new EmpleadoService();

        Scanner sc = new Scanner(System.in);
        
        String idEmpleadoS, nombre, apellido, departamento, telefonoS, mail, user, password = null;
        int idEmpleado = 0;
        
        boolean condicion = true;
        while(condicion){
            System.out.println("---------------------------------");
            System.out.println("BIENVENIDO AL GESTOR DE EMPLEADOS");
            System.out.println("---------------------------------");
            System.out.println("--- OPCIONES ---");
            System.out.println("1. Crear nuevo registro de empleado");
            System.out.println("2. Buscar empleado por id");
            System.out.println("3. Modificar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Ver lista de empleados");
            System.out.println("6. SALIR");
            System.out.println("----------------------------------");
            
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion){
                case 1: 
                    System.out.println("CREAR REGISTRO");
                    System.out.println("Datos Personales");
                    System.out.println("----------------");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Departamento: ");
                    departamento = sc.nextLine();
                    System.out.println("Datos de contacto");
                    System.out.println("-----------------");
                    System.out.println("Telefono: ");
                    telefonoS = sc.nextLine();
                    System.out.println("Mail: ");
                    mail = sc.nextLine();
                    System.out.println("Datos de usuario");
                    System.out.println("-----------------");
                    System.out.println("Usuario: ");
                    user = sc.nextLine();
                    System.out.println("Contraseña: ");
                    password = sc.nextLine();
                    
                    int telefono = Integer.parseInt(telefonoS);
                    
                    Contacto contacto = new Contacto(telefono, mail);
                    Usuario usuario = new Usuario(user, password);
                    Empleado empleado = new Empleado(nombre, apellido, departamento, usuario, contacto);
                    
                    empleadoService.agregarEmpleado(empleado);
                    System.out.println("EMPLEADO AGREGADO A LA BASE DE DATOS");
                    
                    break;
                case 2: // LISTO agregar que pasa si el id no es correcto
                    System.out.println("BUSCAR EMPLEADO");
                    System.out.println("Ingrese id del empleado: ");
                    idEmpleadoS = sc.nextLine();
                    idEmpleado = Integer.parseInt(idEmpleadoS);
                    
                    Empleado empleadoBuscar = new Empleado(idEmpleado);
                    
                    if(empleadoService.encontrarEmpleado(empleadoBuscar) != null){
                        System.out.println("Empleado encontrado: ");
                        iterador(empleadoBuscar);
                    }   else {
                        System.out.println("Empleado con id " + empleadoBuscar.getIdEmpleado() + " no encontrado");
                    }

                    break;
                case 3: 
                    System.out.println("MODIFICAR");
                    System.out.println("Ingrese id del empleado: ");
                    idEmpleadoS = sc.nextLine();
                    idEmpleado = Integer.parseInt(idEmpleadoS);
                    Empleado empleadoModificar = new Empleado(idEmpleado);
                    
                    if(empleadoService.encontrarEmpleado(empleadoModificar) != null){
                        System.out.println("EMPLEADO A MODIFICAR");
                        empleadoModificar = empleadoService.encontrarEmpleado(empleadoModificar);
                        iterador(empleadoModificar);
                    }   else {
                        System.out.println("Empleado con id " + empleadoModificar.getIdEmpleado() + " no encontrado");
                    }
                    
                    System.out.println("Ingrese los nuevos datos");
                    System.out.println("Datos Personales");
                    System.out.println("----------------");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Departamento: ");
                    departamento = sc.nextLine();
                    System.out.println("Datos de contacto");
                    System.out.println("-----------------");
                    System.out.println("Telefono: ");
                    telefonoS = sc.nextLine();
                    System.out.println("Mail: ");
                    mail = sc.nextLine();
                    System.out.println("Datos de usuario");
                    System.out.println("----------------");
                    System.out.println("Usuario: ");
                    user = sc.nextLine();
                    System.out.println("Contraseña: ");
                    password = sc.nextLine();
                    
                    int telefonoModificar = Integer.parseInt(telefonoS);
                    
                    Contacto contactoModificar = new Contacto(telefonoModificar, mail);
                    Usuario usuarioModificar = new Usuario(user, password);
                    Empleado empleadoModificado = new Empleado(nombre, apellido, departamento, usuarioModificar, contactoModificar);
                    
                    empleadoService.modificarEmpleado(empleadoModificado);
                    System.out.println("DATOS DE EMPLEADO MODIFICADOS");
                    
                    break;
                case 4: 
                    System.out.println("ELIMINAR REGISTRO DE EMPLEADO");
                    System.out.println("Ingrese id del empleado: ");
                    idEmpleadoS = sc.nextLine();
                    idEmpleado = Integer.parseInt(idEmpleadoS);
                    
                    Empleado empleadoEliminar = new Empleado(idEmpleado);
                    
                    empleadoService.eliminarEmpleado(empleadoEliminar);
                    
                    break;
                case 5: 
                    System.out.println("VER LISTA DE EMPLEADOS Y DATOS");
                    empleadoService.verEmpleados();
                    break;
                case 6: 
                    System.out.println("SALIR");
                    condicion = false;
                    break;
                default:
                    System.out.println("Error de opcion");
            }
        }
    }
    
    private static void iterador(Empleado empleado){
        System.out.println("ID: " + empleado.getIdEmpleado());
            System.out.println("Nombre: " + empleado.getNombre() + " " + empleado.getApellido() + ", Departamento: " + empleado.getDepartamento());
            System.out.println("Mail: " + empleado.getContacto().getMail() + ", Telefono: " + empleado.getContacto().getTelefono());
            System.out.println("Usuario: " + empleado.getUsuario().getUser() + ", Password: " + empleado.getUsuario().getPass());
    }
}
