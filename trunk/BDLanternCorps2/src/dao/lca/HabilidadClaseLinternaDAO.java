package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadClaseLinternaDAO extends BaseDAO{

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
	
	public List<HabilidadClaseLinternaDO> listByHabilidadId(int HabilidadId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(HabilidadId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadClaseLinternaDO> ret = new ArrayList<HabilidadClaseLinternaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	private HabilidadClaseLinternaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadClaseLinternaDO ret = (HabilidadClaseLinternaDO) dtaSession.getDtaByKey( //
				HabilidadClaseLinternaDO.class, rs.getInt(HabilidadClaseLinternaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadClaseLinternaDO();
		ret.setId(rs.getInt(HabilidadClaseLinternaDO.ID));
		
		Reference<HabilidadDO> ref = new Reference<HabilidadDO>();
	    ref.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.HABILIDAD_ID));
	    ret.setHabilidadRef(ref);
	    
		Reference<ClaseLinternaDO> ref1 = new Reference<ClaseLinternaDO>();
	    ref1.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID));
	    ret.setClaseLinternaRef(ref1);
	    
		return (HabilidadClaseLinternaDO) dtaSession.add(ret);
		
	}

}
