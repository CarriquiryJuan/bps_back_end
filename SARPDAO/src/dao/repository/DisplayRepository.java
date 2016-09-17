package dao.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

import model.Display;

public class DisplayRepository {
	
	private static EntityManager em;
	
	private EntityManager getEntityManagerInstance(){
		if(em == null){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("postgresUnit");
			em = factory.createEntityManager();
		}
		return em;
	}
	
	
	public void crearDisplay(String rutaArchivo){
		System.out.println("crearDisplay0");
		EntityManager em = getEntityManagerInstance();
		System.out.println("crearDisplay1");
		Display d = new Display();
		System.out.println("crearDisplay2");
		//d.setCodigo(codigo);
		System.out.println("crearDisplay3");
		d.setRutaArchivo(rutaArchivo);
		System.out.println("crearDisplay4");
		d.setDateCreated(new Date());
		System.out.println("crearDisplay5");
		d.setLastUpdated(new Date());
		System.out.println("crearDisplay6");
		em.getTransaction().begin();
		System.out.println("crearDisplay7");
		em.persist(d);
		System.out.println("crearDisplay8");
		em.getTransaction().commit();
	}
	
	public Display obtenerDisplay(int codigo){
		EntityManager em = getEntityManagerInstance();
    	return em.find(Display.class, codigo);
    }
	
	public List<Display> listarDisplays(){
		EntityManager em = getEntityManagerInstance();
		return (List<Display>) em.createQuery("select d from Display d").getResultList();
	}
	
	public void modificarDisplay(int codigo, String rutaArchivo) throws Exception{
		EntityManager em = getEntityManagerInstance();
		System.out.println("modificarDisplay1");
		Display d = obtenerDisplay(codigo);
		if(d != null){
			System.out.println("modificarDisplay2");
			d.setRutaArchivo(rutaArchivo);
			System.out.println("modificarDisplay3");
			d.setLastUpdated(new Date());
			System.out.println("modificarDisplay4");
			em.getTransaction().begin();
			em.persist(d);
			em.getTransaction().commit();
		}
		else{
			throw new Exception("No existe el display con código " + codigo);
		}
	}
	
	public void eliminarDisplay(int codigo){
		EntityManager em = getEntityManagerInstance();	
		Display d = obtenerDisplay(codigo);
		System.out.println("eliminarDisplay1");
		em.getTransaction().begin();
    	em.remove(d);
		em.getTransaction().commit();
    }
	
}
