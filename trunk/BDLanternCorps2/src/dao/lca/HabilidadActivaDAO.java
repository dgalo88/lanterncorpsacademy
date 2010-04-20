package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadActivaDAO extends BaseDAO{

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
	
	public List<HabilidadActivaDO> listByHabilidadId(int HabilidadId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(HabilidadId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadActivaDO> ret = new ArrayList<HabilidadActivaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	private HabilidadActivaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadActivaDO ret = (HabilidadActivaDO) dtaSession.getDtaByKey( //
				HabilidadActivaDO.class, rs.getInt(HabilidadActivaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadActivaDO();
		ret.setId(rs.getInt(HabilidadActivaDO.ID));
		ret.setNivel_habilidad(rs.getInt(HabilidadActivaDO.NIVEL_HABILIDAD));
		Reference<PersonajeDO> ref = new Reference<PersonajeDO>();
	    ref.setRefIdent(rs.getInt(HabilidadActivaDO.PERSONAJE_ID));
	    ret.setPersonajeRef(ref);
		Reference<HabilidadDO> ref1 = new Reference<HabilidadDO>();
	    ref1.setRefIdent(rs.getInt(HabilidadActivaDO.HABILIDAD_ID));
	    ret.setHabilidadRef(ref1);

		return (HabilidadActivaDO) dtaSession.add(ret);
		
	}

}
