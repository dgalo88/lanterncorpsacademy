package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;

public class UnidadEjercitoOfertaDO implements IUnidadEjercitoOfertaDO{
		

		public static final String CANTIDAD="cantidad";
		public static final String UNIDAD_EJERCITO_ID="unidadEjercitoId";
		public static final String OFERTA_ID="ofertaId";
		
		//------------------------------------------------------------------------------------------
		
		private int id;
		private int cantidad;
		
		//-----------------------------------------------------------------------------------------
		
		private Reference<IUnidadEjercitoDO> unidadEjercitoRef=//
			new Reference<IUnidadEjercitoDO>();
		
		private Reference<IOfertaDO> ofertaRef=//
			new Reference<IOfertaDO>();
		//--------------------------------------------------------------------------------------------
		
		public UnidadEjercitoOfertaDO(){
			
			//empty
		}
		
		//--------------------------------------------------------------------------------
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		//-----------------------------------------------------------------------------------------
			
		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
		//---------------------------------------------------------------------------------------

		public Reference<IUnidadEjercitoDO> getUnidadEjercitoaRef()
		{
			return unidadEjercitoRef;
		}
		
		public  void setUnidadEjercitoRef(Reference<IUnidadEjercitoDO> unidadEjercitoRef)
		{
			this.unidadEjercitoRef=unidadEjercitoRef;
		}
		
		//-----------------------------------------------------------------------------------------
		
		public  Reference<IOfertaDO> getOfertaRef()
		{
			return ofertaRef;
		}
		
		public void setOfertaRef(Reference<IOfertaDO> ofertaRef){
			
			this.ofertaRef=ofertaRef;
		}
		
		//----------------------------------------------------------------------------------------

	}