package com.ge.data;

import com.ge.domain.Usuario;
import java.util.List;
import javax.persistence.*;

public class UsuarioDAO {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpleadosPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    public List<Usuario> listar() {
        String hql = "SELECT u FROM Usuario u";
        Query query = em.createQuery(hql);
        List<Usuario> usuarios = query.getResultList();
        
        return usuarios;
    }
    
    public void insertar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public void modificar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
    
    public void eliminar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(usuario));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em != null){
                em.close();
            }
        }
    }
}
