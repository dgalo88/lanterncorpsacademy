

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import Object.ClaseLinterna;
import Object.Grupo;
import Object.Habilidad;
import Object.HabilidadActiva;
import Object.HabilidadClaseLinterna;
import Object.Mision;
import Object.MisionClaseLinterna;
import Object.MisionPersonaje;
import Object.NivelHabilidad;
import Object.Objetivo;
import Object.Orden;
import Object.Personaje;
import Object.Planeta;
import Object.Usuario;





public class Main {

	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// PLANETAS 1

		Planeta planeta = new Planeta();
		planeta.setNombre("Oa");
		planeta.setSector("0");
		planeta.setCoordenadaEnX(1);
		session.save(planeta);

		// CLASELINTERNA 2

		ClaseLinterna claseLinterna = new ClaseLinterna();
		claseLinterna.setColor("Verde");
		claseLinterna.setNombre_de_cuerpo_linterna("Green Lantern Corps");
		claseLinterna.setPlanetaRef(planeta);
		session.save(claseLinterna);

		// HABILIDAD 3

		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("Vuelo");
		habilidad.setCosto_de_aprendizaje(50);
		habilidad.setTipo(1);
		session.save(habilidad);

		// NIVELHABILIDAD 4

		NivelHabilidad nivelHabilidad = new NivelHabilidad();
		nivelHabilidad.setNivel_de_habilidad(1);
		nivelHabilidad.setEfectividad(0);
		nivelHabilidad.setCosto_de_energia(1);
		nivelHabilidad.setHabilidadRef(habilidad);
		session.save(habilidad);

		// HABILIDADCLASESLINTERNA 5

		HabilidadClaseLinterna habilidadClaseLinterna = new HabilidadClaseLinterna();
		habilidadClaseLinterna.setHabilidadRef(habilidad);
		habilidadClaseLinterna.setClaseLinternaRef(claseLinterna);
		session.save(habilidadClaseLinterna);
		
		//MISION 6
		
		Mision mision = new Mision();
		mision.setNombre("Cazar");
		mision.setDescripcion("Tienes que cazar");
		mision.setExperiencia_ganada(300);
		mision.setPuntos_de_entrenamiento_ganados(300);
		mision.setNivel_necesario(1);
		session.save(mision);
		
		//MISIONCLASE 7
		
		MisionClaseLinterna misionClaseLinterna=new MisionClaseLinterna();
		misionClaseLinterna.setClaseLinternaRef(claseLinterna);
		misionClaseLinterna.setMisionRef(mision);
		session.save(misionClaseLinterna);
		
		//OBJETIVO 8
		
		Objetivo objetivo= new Objetivo();
		objetivo.setDescripcion("mounstros faciles");
		objetivo.setNumeroDeNpc(3);
		objetivo.setPlanetaRef(planeta);
		session.save(objetivo);
		
		//ORDEN 9
		
		Orden orden= new Orden();
		orden.setMisionRef(mision);
		orden.setObjetivoRef(objetivo);
		session.save(orden);
		
		//PERSONAJE 10

		Personaje personaje=new Personaje();
		personaje.setAlias("pj1");
		personaje.setClaseLinternaRef(claseLinterna);
		personaje.setPlanetaRef(planeta);
		session.save(personaje);
		
		//USUARIO 11
		
		Usuario usuario=new Usuario();
		usuario.setClave("pass");
		usuario.setCorreo("us@try.com");
		usuario.setNombre("usuario");
		usuario.setPersonajeRef(personaje);
		session.save(usuario);
		
		//HABILIDADACTIVA 12
		
		HabilidadActiva activa=new HabilidadActiva();
		activa.setHabilidadRef(habilidad);
		activa.setNivel_habilidad(1);
		activa.setPersonajeRef(personaje);
		session.save(activa);
		
		//GRUPO 13
		
		Grupo grupo=new Grupo();
		grupo.setClaseLinternaRef(claseLinterna);
		grupo.setNombre("clan");
		grupo.setEstado(false);
		session.save(grupo);
		
		personaje.setGrupoRef(grupo);
		
		//MISIONPERSONAJE 14
		
		MisionPersonaje misionPersonaje=new MisionPersonaje();
		misionPersonaje.setMisionRef(mision);
		misionPersonaje.setPersonajeRef(personaje);
		session.save(misionPersonaje);
		
		
		session.getTransaction().commit();
		session.close();

/*		session = sessionFactory.openSession();
		session.beginTransaction();

		//p = (Persona) session.load(Persona.class, 1);
		//System.out.println(p.getConyugue().getNombre());

		session.getTransaction().commit();
		session.close();*/
	}
}
