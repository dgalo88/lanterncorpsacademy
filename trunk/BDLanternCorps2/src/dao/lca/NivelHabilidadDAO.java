package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class NivelHabilidadDAO extends BaseDAO{

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public List<NivelHabilidadDO> listByHabilidadId(int HabilidadId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(NivelHabilidadDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(HabilidadId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<NivelHabilidadDO> ret = new ArrayList<NivelHabilidadDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	private NivelHabilidadDO resultSetToDO(ResultSet rs) throws SQLException {
		NivelHabilidadDO ret = (NivelHabilidadDO) dtaSession.getDtaByKey( //
				NivelHabilidadDO.class, rs.getInt(NivelHabilidadDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new NivelHabilidadDO();
		ret.setId(rs.getInt(NivelHabilidadDO.ID));
		
		ret.setNivel_de_habilidad(rs.getInt(NivelHabilidadDO.NIVEL_DE_HABILIDAD));
		ret.setEfectividad(rs.getInt(NivelHabilidadDO.EFECTIVIDAD));
		ret.setCosto_de_energia(rs.getInt(NivelHabilidadDO.COSTO_DE_ENERGIA));
		ret.setProbabilidad(rs.getInt(NivelHabilidadDO.PROBABILIDAD));
		Reference<HabilidadDO> ref = new Reference<HabilidadDO>();
	    ref.setRefIdent(rs.getInt(NivelHabilidadDO.HABILIDAD_ID));
	    ret.setHabilidadRef(ref);
	    
		return (NivelHabilidadDO) dtaSession.add(ret);
		
	}

}
