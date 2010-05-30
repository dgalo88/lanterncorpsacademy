package hlantern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import crud.Crud;

/** 
 * @author Julian Ovalle 
 */
public class Test {

	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/hlantern/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		PersonajeDO p = new PersonajeDO();
//		for (int i = 0; i < 3; i++) {
			UsuarioDO u = new UsuarioDO();
//		Declaran objetos asi y les hacen set de todo para llenarlos..
//
//			AB ab = new AB();
//
//			ab.setEntityARef(a);
//			ab.setEntityBRef(b);
//			a.getAbList().add(ab);
//			b.getAbList().add(ab); asi se ponen las listas en relaciones de varios..
//
			session.save(p); //asi los insertan..
//
		UsuarioDO usu = new UsuarioDO();
		    u = (UsuarioDO) session.load(UsuarioDO.class, 1);// asi se cargan...
//			session.save(b);
//		}
//
//		EntityB b = (EntityB) session.load(EntityB.class, 1);
//		for (int i = 0; i < 3; i++) {
//			a = new EntityA();
//
//			AB ab = new AB();
//
//			ab.setEntityARef(a);
//			ab.setEntityBRef(b);
//			a.getAbList().add(ab);
//			b.getAbList().add(ab);
//
//			session.save(a);
//			session.save(b);
//		}

		session.getTransaction().commit();
		session.close();
	}
}