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
        grupo.getPersonajeList().add(personaje);        
        session.save(grupo);
        
        personaje.setGrupo(grupo);
        
        //MISIONPERSONAJE 14
        
        MisionPersonajeDO misionPersonaje=new MisionPersonajeDO();
        misionPersonaje.setMision(mision);
        misionPersonaje.setPersonaje(personaje);
        session.save(misionPersonaje);
        
        session.getTransaction().commit();
//        session.close();
        
// XXX: LOAD ----------------------------------------------------------------------------------
        
        //estos dan problemas xq no tengo control sobre el id de los q inserte anteriormente y no 
        // se que id genero hibernate
        
		Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        
	    // PLANETAS 1

        PlanetaDO planet;
        planet = (PlanetaDO) session2.load(PlanetaDO.class, 1);
        System.err.println("planet nombre: "+planet.getNombre());
        System.err.println("planet sector: "+planet.getSector());
        System.err.println("planet x: "+planet.getCoordenadaEnX());

        // CLASELINTERNA 2

        ClaseLinternaDO claseLint;
        claseLint = (ClaseLinternaDO) session2.load(ClaseLinternaDO.class, 2);
        System.err.println("clase nombre: "+claseLint.getColor());
        System.err.println("clase cuerpo: "+claseLint.getNombre_de_cuerpo_linterna());
//        System.err.println("planet base nombre: "+claseLint.getPlaneta().getNombre());

        // HABILIDAD 3

        HabilidadDO hability = (HabilidadDO) session2.load(HabilidadDO.class, 3);        
        System.err.println("hability nombre: "+hability.getNombre());
        System.err.println("hability costo: "+hability.getCosto_de_aprendizaje());
        System.err.println("hability tipo: "+hability.getTipo());

        // NIVELHABILIDAD 4

        NivelHabilidadDO nivHabilidad = (NivelHabilidadDO) session2.load(NivelHabilidadDO.class, 4);
        System.err.println("nivHability nivel: "+nivHabilidad.getNivel_de_habilidad());
        System.err.println("nivHability efectividad: "+nivHabilidad.getEfectividad());
        System.err.println("nivHability nivel: "+nivHabilidad.getCosto_de_energia());
        System.err.println("nivHability hability id: "+nivHabilidad.getHabilidad().getId());
        

        // HABILIDADCLASESLINTERNA 5

		HabilidadClaseLinternaDO habClaseLinterna = (HabilidadClaseLinternaDO) session2
				.load(HabilidadClaseLinternaDO.class, 5);
		System.err.println("habClase hability id: "+habClaseLinterna.getHabilidad().getId());
		System.err.println("habCLase clase id: "+habClaseLinterna.getClaseLinterna().getId());

        
//        MISION 6
        
        MisionDO mision2 = (MisionDO) session2.load(MisionDO.class, 6);
        System.err.println("mision nombre: "+mision2.getNombre());
        System.err.println("mision desc: "+mision2.getDescripcion());
        System.err.println("mision exp won: "+mision2.getExperiencia_ganada());
        System.err.println("mision trains won: "+mision2.getPuntos_de_entrenamiento_ganados());
        System.err.println("mision nivel nec: "+mision2.getNivel_necesario());

        
        //MISIONCLASE 7
        
		MisionClaseLinternaDO misionClaseLint = (MisionClaseLinternaDO) session2
				.load(MisionClaseLinternaDO.class, 7);
		System.err.println("misionClase claseId: "+misionClaseLint.getClaseLinterna().getId());
		System.err.println("misionClase misionId: "+misionClaseLint.getMision().getId());

        
        //OBJETIVO 8
        
        ObjetivoDO objetivo2= (ObjetivoDO) session2.load(ObjetivoDO.class, 8);
        System.err.println("objetivo desc: "+objetivo2.getDescripcion());
        System.err.println("objetivo num npc: "+objetivo2.getNumeroDeNpc());
        System.err.println("objetivo planetId: "+objetivo2.getPlaneta().getId());

        
        //ORDEN 9
        
        OrdenDO orden2= (OrdenDO) session2.load(OrdenDO.class, 9);
        System.err.println("orden misionID: "+orden2.getMision().getId());
        System.err.println("orden objID: "+orden2.getObjetivo().getId());

        
        //PERSONAJE 10

        PersonajeDO personaje2= (PersonajeDO) session2.load(PersonajeDO.class, 10);
        System.err.println("personaje alias: "+personaje2.getAlias());
        System.err.println("personaje clase id: "+personaje2.getClaseLinterna().getId());
        System.err.println("personaje planeta id: "+personaje2.getPlaneta().getId());

        
        //USUARIO 11 Ref
        
        UsuarioDO usuario2= (UsuarioDO) session2.load(UsuarioDO.class, 11);
        System.err.println("usuario clave: "+usuario2.getClave());
        System.err.println("usuario correo: "+usuario2.getCorreo());
        System.err.println("usuario nombre: "+usuario2.getNombre());
        //System.err.println("usuario personajeId: "+usuario2.getPersonaje().getId());

        
        //HABILIDADACTIVA 12
        
        HabilidadActivaDO habactiva=(HabilidadActivaDO) session2.load(HabilidadActivaDO.class, 12);
        System.err.println("hab activa habilidadID: "+habactiva.getHabilidad().getId());
        System.err.println("hab activa nivel: "+habactiva.getNivel_habilidad());
        System.err.println("hab activa personajeID: "+habactiva.getPersonaje().getId());

        
        //GRUPO 13
        
        GrupoDO grupo2=(GrupoDO) session2.load(GrupoDO.class, 13);
        System.err.println("grupo claseID: "+grupo2.getClaseLinterna().getId());
        System.err.println("grupo nombre: "+grupo2.getNombre());
        System.err.println("grupo estado: "+grupo2.isEstado());
        
        //MISIONPERSONAJE 14
        
        MisionPersonajeDO misionPers=(MisionPersonajeDO) session2.load(MisionPersonajeDO.class, 14);
        System.err.println("misionP misionId: "+misionPers.getMision().getId());
        System.err.println("misionP personajeId: "+misionPers.getPersonaje().getId());


		session2.getTransaction().commit();
		session2.close();
	}
}