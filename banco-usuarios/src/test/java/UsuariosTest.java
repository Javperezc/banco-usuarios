

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.common.util.impl.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.TiposUsuarios;
import co.edu.usbcali.demo.modelo.Usuarios;

public class UsuariosTest {

	private final static Logger log=LoggerFactory.getLogger(UsuariosTest.class);
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	private static int usu_cedula=10;
		
	@Test
	public void consul_usutest() {
		
		entityManagerFactory= Persistence.createEntityManagerFactory("banco-usuarios");
		entityManager= entityManagerFactory.createEntityManager() ;
	
		Usuarios usuarios=entityManager.find(Usuarios.class, usu_cedula);
		assertNull("El usuario no existe",usuarios);
		
		usuarios = new Usuarios();
		usuarios.setUsuCedula(10);
		usuarios.setUsuNombre("Pedro Fernandez");
		usuarios.setUsuLogin("pfernandez");
								
		TiposUsuarios tiposUsuarios =entityManager.find(TiposUsuarios.class, 25L);
		assertNotNull("El tipo de usuario no exite",tiposUsuarios);
		
		usuarios.setTiposUsuarios(tiposUsuarios);
		
		entityManager.getTransaction().begin();
			entityManager.persist(usuarios);
		entityManager.getTransaction().commit();
					
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	@Test
	public void crear_usutest() {
		
		entityManagerFactory= Persistence.createEntityManagerFactory("banco-usuarios");
		entityManager= entityManagerFactory.createEntityManager() ;
	
		Usuarios usuarios=entityManager.find(Usuarios.class, usu_cedula);
		assertNull("El usuario no existe",usuarios);
		
		usuarios = new Usuarios();
		usuarios.setUsuCedula(20);
		usuarios.setUsuNombre("Javier Perez");
		usuarios.setUsuLogin("Javierpc");
				
		TiposUsuarios tiposUsuarios =entityManager.find(TiposUsuarios.class, 25L);
		assertNotNull("El tipo de usuario no exite",tiposUsuarios);
		
		usuarios.setTiposUsuarios(tiposUsuarios);
		
		entityManager.getTransaction().begin();
			entityManager.merge(usuarios);
		entityManager.getTransaction().commit();
		
				
		entityManager.close();
		entityManagerFactory.close();
		
	}
			
	@Test
	public void buscar_usutest() {
		
		entityManagerFactory= Persistence.createEntityManagerFactory("banco-usuarios");
		entityManager= entityManagerFactory.createEntityManager() ;
	
		TiposUsuarios tiposUsuarios =entityManager.find(TiposUsuarios.class, 25L);
		assertNotNull("Usuario no encontrado",tiposUsuarios);
		
		log.info(""+tiposUsuarios.getTusuCodigo());
		log.info(""+tiposUsuarios.getTusuNombre());
		
		log.info(""+tiposUsuarios.getUsuarioses());
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	@Test
	public void eliminar_usutest() {
		
		entityManagerFactory= Persistence.createEntityManagerFactory("banco-usuarios");
		entityManager= entityManagerFactory.createEntityManager() ;
	
		TiposUsuarios tiposUsuarios =entityManager.find(TiposUsuarios.class, 25L);
		assertNotNull("Usuario no encontrado",tiposUsuarios);
		
		log.info(""+tiposUsuarios.getTusuCodigo());
		log.info(""+tiposUsuarios.getTusuNombre());
		
		log.info(""+tiposUsuarios.getUsuarioses());
		
		entityManager.getTransaction().begin();
		entityManager.remove(usu_cedula);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
