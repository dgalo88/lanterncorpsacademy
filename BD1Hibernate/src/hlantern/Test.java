package hlantern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

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

//		PersonajeDO p = new PersonajeDO();
////		for (int i = 0; i < 3; i++) {
//		UsuarioDO u = new UsuarioDO();
////		Declaran objetos asi y les hacen set de todo para llenarlos.. get+Ref
////
////			AB ab = new AB();
////
//			u.setPersonaje(p);
////			ab.setEntityBRef(b);
////			a.getAbList().add(ab);
////			b.getAbList().add(ab); asi se ponen las listas en relaciones de varios..
//			session.save(p); //asi los insertan..
//			session.save(u);
////
////		UsuarioDO usu = new UsuarioDO();
////		    u = (UsuarioDO) session.load(UsuarioDO.class, 1);// asi se cargan...
////			session.save(b);
////		}
////
////		EntityB b = (EntityB) session.load(EntityB.class, 1);
////		for (int i = 0; i < 3; i++) {
////			a = new EntityA();
////
////			AB ab = new AB();
////
////			ab.setEntityARef(a);
////			ab.setEntityBRef(b);
////			a.getAbList().add(ab);
////			b.getAbList().add(ab);
////
////			session.save(a);
////			session.save(b);
////		}
		
	    // PLANETAS 1

        PlanetaDO planeta = new PlanetaDO();
        planeta.setNombre("Oa");
        planeta.setSector("0");
        planeta.setCoordenadaEnX(1);
        session.save(planeta);

        // CLASELINTERNA 2

        ClaseLinternaDO claseLinterna = new ClaseLinternaDO();
        claseLinterna.setColor("Verde");
        claseLinterna.setNombre_de_cuerpo_linterna("Green Lantern Corps");
        claseLinterna.setPlaneta(planeta);
        session.save(claseLinterna);

        // HABILIDAD 3

        HabilidadDO habilidad = new HabilidadDO();
        habilidad.setNombre("Vuelo");
        habilidad.setCosto_de_aprendizaje(50);
        habilidad.setTipo(1);
        session.save(habilidad);

        // NIVELHABILIDAD 4

        NivelHabilidadDO nivelHabilidad = new NivelHabilidadDO();
        nivelHabilidad.setNivel_de_habilidad(1);
        nivelHabilidad.setEfectividad(0);
        nivelHabilidad.setCosto_de_energia(1);
        nivelHabilidad.setHabilidad(habilidad);
        session.save(nivelHabilidad);

        // HABILIDADCLASESLINTERNA 5

        HabilidadClaseLinternaDO habilidadClaseLinterna = new HabilidadClaseLinternaDO();
        habilidadClaseLinterna.setHabilidad(habilidad);
        habilidadClaseLinterna.setClaseLinterna(claseLinterna);
        session.save(habilidadClaseLinterna);
        
        //MISION 6
        
        MisionDO mision = new MisionDO();
        mision.setNombre("Cazar");
        mision.setDescripcion("Tienes que cazar");
        mision.setExperiencia_ganada(300);
        mision.setPuntos_de_entrenamiento_ganados(300);
        mision.setNivel_necesario(1);
        session.save(mision);
        
        //MISIONCLASE 7
        
        MisionClaseLinternaDO misionClaseLinterna=new MisionClaseLinternaDO();
        misionClaseLinterna.setClaseLinterna(claseLinterna);
        misionClaseLinterna.setMision(mision);
        session.save(misionClaseLinterna);
        
        //OBJETIVO 8
        
        ObjetivoDO objetivo= new ObjetivoDO();
        objetivo.setDescripcion("mounstros faciles");
        objetivo.setNumeroDeNpc(3);
        objetivo.setPlaneta(planeta);
        session.save(objetivo);
        
        //ORDEN 9
        
        OrdenDO orden= new OrdenDO();
        orden.setMision(mision);
        orden.setObjetivo(objetivo);
        session.save(orden);
        
        //PERSONAJE 10

        PersonajeDO personaje=new PersonajeDO();
        personaje.setAlias("pj1");
        personaje.setClaseLinterna(claseLinterna);
        personaje.setPlaneta(planeta);
        session.save(personaje);
        
        //USUARIO 11 Ref
        
        UsuarioDO usuario=new UsuarioDO();
        usuario.setClave("pass");
        usuario.setCorreo("us@try.com");
        usuario.setNombre("usuario");
        usuario.setPersonaje(personaje);
        session.save(usuario);
        
        //HABILIDADACTIVA 12
        
        HabilidadActivaDO activa=new HabilidadActivaDO();
        activa.setHabilidad(habilidad);
        activa.setNivel_habilidad(1);
        activa.setPersonaje(personaje);
        session.save(activa);
        
        //GRUPO 13
        
        GrupoDO grupo=new GrupoDO();
        grupo.setClaseLinterna(claseLinterna);
        grupo.setNombre("clan");
        grupo.setEstado(false);
        session.save(grupo);
        
        personaje.setGrupo(grupo);
        
        //MISIONPERSONAJE 14
        
        MisionPersonajeDO misionPersonaje=new MisionPersonajeDO();
        misionPersonaje.setMision(mision);
        misionPersonaje.setPersonaje(personaje);
        session.save(misionPersonaje);


		session.getTransaction().commit();
		session.close();
	}
}