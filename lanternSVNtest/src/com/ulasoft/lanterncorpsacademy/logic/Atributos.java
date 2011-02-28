package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.menus.MenuStatus;
import com.ulasoft.lanterncorpsacademy.paneles.PanelConquistar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMisDatos;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Atributos {

	public Atributos() {

	}

	public static final int SALUD = 200;
	public static final int ENERGIA = 100;

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private IPersonajeDO personaje;
	private IUsuarioDO usuario;

	public void updateAtributos () throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
		usuario = (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
        IUsuarioDAO usDAO = (IUsuarioDAO) //
        		GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);

        usuario = (IUsuarioDO) usDAO.loadById(usuario.getId());
        personaje = (IPersonajeDO) personajeDAO.loadById(personaje.getId());

		System.err.println("PERSONAJE ID en atts:" + personaje.getId());
		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}
	
	public void updateMenuStatus(MenuStatus menuStatus) throws Exception {

		System.err.println("PERSONAJE ID en atts menuStatus: " //
				+ personaje.getId());
		System.err.println("PERSONAJE salud en atts menuStatus: " //
				+ personaje.getSalud());

		menuStatus.getSalud().setCurrValue( //
				(personaje.getSalud()) * 100 / //
				(SALUD + 50 * (personaje.getNivel() - 1)));

		menuStatus.getEnergia().setCurrValue( //
				personaje.getEnergiaDelAnillo() * 100 / //
				(ENERGIA + 10 * (personaje.getNivel() - 1)));

		menuStatus.getEnergia().setColor(Estilo.getColor(app.getAtributos()));

		menuStatus.getExperiencia().setCurrValue( //
				personaje.getExperiencia() * 100 / //
				15 * 2^(personaje.getNivel() - 1));

		System.err.println("PERSONAJE ID en atts menuStatus2: " + personaje.getId());
	}

	public void updatePanelMain(PanelMain main) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());
		IPlanetaDO planetaCasa = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getClaseLinternaRef().getRefIdent());

		ConnectionFactory.closeConnection(connectionBean.getConnection());
		System.err.println("PLANETA ID en atts main: " + planeta.getId());

		main.setPlaneta(planetaCasa);

		main.getLblPlanetaValue().setText("Planeta: " + planeta.getNombre());
		main.getLblSectorValue().setText("Sector: " + planeta.getSector());
		main.getLblFechaValue().setText("Fecha: " + personaje.getUltimaFechaIngreso().toString());

	}

	public void updatePanelConquistar(PanelConquistar conquistar) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());
		IClaseLinternaDAO claseLinternaDAO = (IClaseLinternaDAO) //
				GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, connectionBean);
		IClaseLinternaDO claseLinterna = (IClaseLinternaDO) //
				claseLinternaDAO.loadById(personaje.getClaseLinternaRef().getRefIdent());

		ConnectionFactory.closeConnection(connectionBean.getConnection());
		System.err.println("PLANETA ID en atts main: " + planeta.getId());

		conquistar.getLblAlias().setText(personaje.getAlias());
		conquistar.getLblClase().setText(claseLinterna.getNombre_de_cuerpo_linterna());
		conquistar.getLblNivel().setText(Integer.toString(personaje.getNivel()));

	}

	public void updatePanelMisDatos(PanelMisDatos misDatos) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());
		IClaseLinternaDAO claseLinternaDAO = (IClaseLinternaDAO) //
				GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, connectionBean);
		IClaseLinternaDO claseLinterna = (IClaseLinternaDO) //
				claseLinternaDAO.loadById(personaje.getClaseLinternaRef().getRefIdent());
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);

		IRecursoDO recursoDO[] = new IRecursoDO[8];
		for (int i = 0; i < 8; i++) {
			recursoDO[i] = (IRecursoDO) recursoDAO.loadById(i+1);
		}

		personajeDAO.loadRecursoPersonajeList(personaje);


		IRecursoPersonajeDO recursoPersonaje = (IRecursoPersonajeDO) //
				GlobalDOFactory.getDO(IRecursoPersonajeDO.class);
		Reference<IRecursoDO> refRecurso = new Reference<IRecursoDO>();
		Reference<IPersonajeDO> refPersonaje = new Reference<IPersonajeDO>();

		IRecursoPersonajeDO recursoPersonajeDO[] = new IRecursoPersonajeDO[8];
		for (int i = 0; i < personaje.getRecursoPersonajeList().size(); i++) {

			if (personaje.getRecursoPersonajeList().get(i).getRecursoRef().getRefIdent() == //
				recursoDO[i].getId()) {
				recursoPersonajeDO[i] = personaje.getRecursoPersonajeList().get(i);
			}

			IRecursoDO refValue1 = (IRecursoDO) recursoDAO.loadById(i);
			refValue1 = (IRecursoDO) recursoDAO.loadById(i);
			refRecurso.setRefValue(refValue1);

			IPersonajeDO refValue2 = (IPersonajeDO) personajeDAO.loadById(i);
			refValue2 = (IPersonajeDO) personajeDAO.loadById(i);
			refPersonaje.setRefValue(refValue2);

			recursoPersonaje.setCantidad(0);
			recursoPersonaje.setRecursoRef(refRecurso);
			recursoPersonaje.setPersonajeRef(refPersonaje);

			recursoPersonajeDO[i] = recursoPersonaje;

		}

		// TODO: Arreglar Referencia
		IPlanetaDO planetaCasa = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getClaseLinternaRef().getRefIdent());

		ConnectionFactory.closeConnection(connectionBean.getConnection());
		System.err.println("PLANETA ID en atts main: " + planeta.getId());

		misDatos.getLblNombre().setText("Nombre: " + usuario.getNombre());
		misDatos.getLblCorreo().setText("Correo: " + usuario.getCorreo());
		misDatos.getLblAlias().setText("Alias: " + personaje.getAlias());
//		misDatos.getLblPlanetaValue().setText("Planeta Casa: " //
//				+ Data.getPlanetaBase(personaje.getClaseLinternaRef().getRefIdent()));
		misDatos.getLblPlanetaValue().setText("Planeta Casa: " + planetaCasa.getNombre());
		misDatos.getLblClase().setText("Clase: " + claseLinterna.getNombre_de_cuerpo_linterna());
		misDatos.getLblNivel().setText("Nivel: " + //
				Integer.toString(personaje.getNivel()));
		misDatos.getLblPuntosEntrenamiento().setText("Puntos de Entrenamiento: " //
				+ Integer.toString(personaje.getPuntosDeEntrenamiento()));
		misDatos.getLblOfertas().setText("Ofertas: 00");

		misDatos.getLblPlomo().setText(recursoDO[0].getNombre() + " " + recursoPersonajeDO[0].getCantidad());
		misDatos.getLblHierro().setText(recursoDO[1].getNombre() + " "  + recursoPersonajeDO[1].getCantidad());
		misDatos.getLblAcero().setText(recursoDO[2].getNombre() + " "  + recursoPersonajeDO[2].getCantidad());
		misDatos.getLblUranio().setText(recursoDO[3].getNombre() + " "  + recursoPersonajeDO[3].getCantidad());
		misDatos.getLblTitanio().setText(recursoDO[4].getNombre() + " "  + recursoPersonajeDO[4].getCantidad());
		misDatos.getLblCristalo().setText(recursoDO[5].getNombre() + " "  + recursoPersonajeDO[5].getCantidad());
		misDatos.getLblAdamantium().setText(recursoDO[6].getNombre() + " "  + recursoPersonajeDO[6].getCantidad());
		misDatos.getLblVibratium().setText(recursoDO[7].getNombre() + " "  + recursoPersonajeDO[7].getCantidad());

//		misDatos.getLblPlomo().setText(recursoDO[0].getNombre() + ": 00");
//		misDatos.getLblHierro().setText(recursoDO[1].getNombre() + ": 00");
//		misDatos.getLblAcero().setText(recursoDO[2].getNombre() + ": 00");
//		misDatos.getLblUranio().setText(recursoDO[3].getNombre() + ": 00");
//		misDatos.getLblTitanio().setText(recursoDO[4].getNombre() + ": 00");
//		misDatos.getLblCristalo().setText(recursoDO[5].getNombre() + ": 00");
//		misDatos.getLblAdamantium().setText(recursoDO[6].getNombre() + ": 00");
//		misDatos.getLblVibratium().setText(recursoDO[7].getNombre() + ": 00");

	}

	public void guardarAtts() throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);

		personajeDAO.update(personaje);

		System.err.println("PERSONAJE ID en atts save: " + personaje.getId());
		ConnectionFactory.closeConnection(connectionBean.getConnection());

	}

	public void recargaAnillo() throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);

		personaje.setEnergiaDelAnillo(ENERGIA);
		personaje.setSalud(SALUD);
		personajeDAO.update(personaje);

		updateMenuStatus(app.getDesktop().getMenuHead().getMenuStatus());

		System.err.println("PERSONAJE ID en atts save: " + personaje.getId());
		ConnectionFactory.closeConnection(connectionBean.getConnection());

	}

	// --------------------------------------------------------------------------------

	public IPersonajeDO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(IPersonajeDO personaje) {
		this.personaje = personaje;
	}

	public IUsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(IUsuarioDO usuario) {
		this.usuario = usuario;
	}

}
