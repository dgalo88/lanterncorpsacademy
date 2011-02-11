package dao.lantern;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IOfertaPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;

public class OfertaPersonajeDO implements IOfertaPersonajeDO {

	public static final String OFERTA_ID = "ofertaId";
	public static final String PERSONAJE_ID = "personajeId";

	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Reference<IOfertaDO> ofertaRef = new Reference<IOfertaDO>();

	private Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();

	// --------------------------------------------------------------------------------

	public OfertaPersonajeDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public Reference<IOfertaDO> getOfertaRef() {
		return ofertaRef;
	}

	@Override
	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	@Override
	public void setOfertaRef(Reference<IOfertaDO> ofertaRef) {
		this.ofertaRef = ofertaRef;

	}

	@Override
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;

	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

}