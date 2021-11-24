package com.empleados.empleadoscrud.datos;

import com.empleados.empleadoscrud.dominio.Contacto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ContactoDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpleadosPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public List<Contacto> listar() {
        String hql = "SELECT c FROM Contacto c";
        Query query = em.createQuery(hql);
        List<Contacto> contactos = query.getResultList();

        return contactos;
    }

    public void insertar(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    public void modificar(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    public void eliminar(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }
}
