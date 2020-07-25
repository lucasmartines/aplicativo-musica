package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtils {

	
	public static EntityManager getManager() {
		
		return getEntityManagerFactory().createEntityManager();
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("music-jsp");
	}
	
}
