package persistencia;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

    static {
    	
        try {
            
            sessionFactory = new AnnotationConfiguration()
            	.configure("config/oracle_hibernate.cfg.xml").buildSessionFactory();
        
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    	
    }
	
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
