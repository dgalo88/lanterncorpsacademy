

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.IPlanetaDO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import Object.ClaseLinterna;
import Object.Habilidad;
import Object.HabilidadClaseLinterna;
import Object.NivelHabilidad;
import Object.Planeta;

import dao.api.Reference;

import factory.GlobalDOFactory;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/relaciones/unoauno/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// PLANETAS
		
		Planeta planeta = new Planeta();
		planeta.setNombre("Oa");
		planeta.setSector("0");
		planeta.setCoordenadaEnX(1);
		session.save(planeta);
		
		//CLASELINTERNA

		ClaseLinterna claseLinterna = new ClaseLinterna();
		claseLinterna.setColor("Verde");
		claseLinterna.setNombre_de_cuerpo_linterna("Green Lantern Corps");
		claseLinterna.setPlanetaRef(planeta);
		session.save(claseLinterna);

		//HABILIDAD
		
		Habilidad habilidad = new Habilidad();	
habilidad.setNombre("Vuelo");
habilidad.setCosto_de_aprendizaje(50);
habilidad.setTipo(1);
session.save(habilidad);

		//NIVELHABILIDAD

	NivelHabilidad nivelHabilidad=new NivelHabilidad();
	nivelHabilidad.setNivel_de_habilidad(1);
	nivelHabilidad.setEfectividad(0);
	nivelHabilidad.setCosto_de_energia(1);
	nivelHabilidad.setHabilidadRef(habilidad);
	session.save(habilidad);
	
//HABILIDADCLASESLINTERNA
	
	HabilidadClaseLinterna habilidadClaseLinterna = new HabilidadClaseLinterna();
	habilidadClaseLinterna.setHabilidadRef(habilidad);
	habilidadClaseLinterna.setClaseLinternaRef(claseLinterna);
	session.save(habilidadClaseLinterna);
	
	

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		p = (Persona) session.load(Persona.class, 1);
		System.out.println(p.getConyugue().getNombre());

		session.getTransaction().commit();
		session.close();
	}
}