package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;


public class HabilidadDAO extends BaseDAO{

	public HabilidadDAO(){
		//Empty
	}
	
    // --------------------------------------------------------------------------------
	
	@Override
	public void createTable() throws SQLException {
		StringBuffer strbuf;

	    // ----------------------------------------

	    strbuf = new StringBuffer();
	    strbuf.append("DROP TABLE IF EXISTS ");
	    strbuf.append(getTableName());
	    strbuf.append(" CASCADE");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());

	    // ----------------------------------------

	    strbuf = new StringBuffer();
	    strbuf.append("DROP SEQUENCE IF EXISTS ");
	    strbuf.append("seq_");
	    strbuf.append(getTableName());
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());

	    // ----------------------------------------

	    strbuf = new StringBuffer();
	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" INT PRIMARY KEY,	");
	    strbuf.append(HabilidadDO.NOMBRE);
	    strbuf.append(" VARCHAR(20), UNIQUE,	");
	    strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
	    strbuf.append(" INT,	");
	    strbuf.append(HabilidadDO.TIPO);
	    strbuf.append(" INT");
	    strbuf.append(")");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());

	    // ----------------------------------------

	    strbuf = new StringBuffer();
	    strbuf.append("CREATE SEQUENCE ");
	    strbuf.append("seq_");
	    strbuf.append(getTableName());
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());
	}

    // --------------------------------------------------------------------------------
	
	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

	    HabilidadDO habilidadDO = (HabilidadDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);
	}

    // --------------------------------------------------------------------------------
	
	private int getNextId() throws SQLException {
		StringBuffer strbuf = new StringBuffer();
	    strbuf.append("SELECT nextval(");
	    strbuf.append(singleQuotes("seq_" + getTableName()));
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    if (!rs.next()) {
	      throw new IllegalStateException("!rs.next()");
	    }
	    return rs.getInt("nextval");
	}

    // --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, HabilidadDO.class, CHECK_INSERT);
	    
	    HabilidadDO habilidadDO = (HabilidadDO) dataObject;
	    habilidadDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(habilidadDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(habilidadDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(habilidadDO.getCosto_de_aprendizaje());
	    strbuf.append(", ");
	    strbuf.append(habilidadDO.getTipo());

	    strbuf.append(")");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());
	    dtaSession.add(dataObject);
	}

    // --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    if (lim >= 0 && off >= 0) {
	      strbuf.append(" LIMIT  ");
	      strbuf.append(lim);
	      strbuf.append(" OFFSET ");
	      strbuf.append(off);
	    }

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<DataObject> ret = new ArrayList<DataObject>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	}
	
    // --------------------------------------------------------------------------------

	private DataObject resultSetToDO(ResultSet rs) {
		HabilidadDO ret = (HabilidadDO) dtaSession.getDtaByKey( //
				HabilidadDO.class, rs.getInt(HabilidadDO.ID));
		
		if (ret != null) {
			return ret;
		}
		
		ret = new PersonajeDO();
		ret.setId(rs.getInt(PersonajeDO.ID));
		ret.setExperiencia(rs.getInt(PersonajeDO.EXPERIENCIA));
		ret.setPuntosDeEntrenamiento(rs
				.getInt(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO));
		ret.setSalud(rs.getInt(PersonajeDO.SALUD));
		ret.setEnergiaDelAnillo(rs.getInt(PersonajeDO.ENERGIA_DEL_ANILLO));
		ret.setNivel(rs.getInt(PersonajeDO.NIVEL));
		ret.setUltimaFechaIngreso(rs.getDate(PersonajeDO.ULTIMA_FECHA_INGRESO));
		Reference<PlanetaDO> ref = new Reference<PlanetaDO>();
		ref.setRefIdent(rs.getInt(PersonajeDO.USUARIO_ID));
		Reference<PlanetaDO> ref1 = new Reference<PlanetaDO>();
		ref1.setRefIdent(rs.getInt(PersonajeDO.PLANETA_ID));
		Reference<GrupoDO> ref2 = new Reference<GrupoDO>();
		ref2.setRefIdent(rs.getInt(PersonajeDO.GRUPO_ID));
		Reference<ClaseLinternaDO> ref3 = new Reference<ClaseLinternaDO>();
		ref3.setRefIdent(rs.getInt(PersonajeDO.CLASE_LINTERNA_ID));
		
		return (PersonajeDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

    // --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

    // --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    // --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, HabilidadDO.class, CHECK_UPDATE);

	    HabilidadDO habilidadDO = (HabilidadDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();
	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");
	    
	    strbuf.append(HabilidadDO.NOMBRE);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(habilidadDO.getNombre()));
	    strbuf.append(", ");
	    
	    strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getCosto_de_aprendizaje());
	    strbuf.append(", ");
	    
	    strbuf.append(HabilidadDO.TIPO);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getTipo());
	    strbuf.append(", ");
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());
	}


}
