/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Paco Miranda
 */
public class OperacionesJPA {

    public OperacionesJPA() {
    }
    
    public boolean editarElemento(Object elemento){
        boolean editado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{            
            em.merge(elemento);
            em.getTransaction().commit();
            editado = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return editado;
    }
    
    public boolean persistencia(Object object){
        boolean agregado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
            agregado = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return agregado;
    }
    
    public Object getObjetoPorId(int id, Class generico){
        Object objetoEncontrado = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            objetoEncontrado = em.find(generico, id);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            return objetoEncontrado;
        }
    }
        
    public boolean eliminarObjeto(int id, Class generico){
        boolean eliminado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            Object aux = em.find(generico, id);
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            eliminado = true;
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            return eliminado;
        }
    }
    
    public boolean eliminarObjetoI(Object objeto){
        boolean eliminado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            eliminado = true;
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
            return eliminado;
        }
    }
    
    public List getTodosLosElementos(String consulta){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzabrosaPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
}
