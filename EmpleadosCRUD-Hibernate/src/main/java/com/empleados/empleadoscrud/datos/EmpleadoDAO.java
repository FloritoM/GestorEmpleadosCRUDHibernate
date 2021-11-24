package com.empleados.empleadoscrud.datos;

import com.empleados.empleadoscrud.dominio.Empleado;
import java.util.List;
import javax.persistence.*;

public class EmpleadoDAO implements iEmpleadoDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpleadosPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @Override
    public List<Empleado> listar() {
        String hql = "SELECT e FROM Empleado e";
        Query query = em.createQuery(hql);
        List<Empleado> empleados = query.getResultList();

        return empleados;
    }

    @Override
    public void insertar(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if(em != null){
//                em.close();
//            }
       }
    }

    @Override
    public void modificar(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if(em != null){
//                em.close();
//            }
       }
    }

    @Override
    public void eliminar(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(empleado));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if(em != null){
//                em.close();
//            }
//       }
    }

    @Override
    public Empleado encontrar(Empleado empleado) {
        return em.find(Empleado.class, empleado.getIdEmpleado());
    }

}
