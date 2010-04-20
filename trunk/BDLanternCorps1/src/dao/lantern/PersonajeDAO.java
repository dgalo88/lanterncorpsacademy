package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class PersonajeDAO extends BaseDAO {

	@Override
	public int countAll() throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT COUNT(*) FROM ");
	    strbuf.append(getTableName());

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    rs.next();

	    return rs.getInt("count");
	}

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

	    UsuarioDAO usuarioDAO = new UsuarioDAO(); 
	    usuarioDAO.init(connectionBean);
	    
	    PlanetaDAO planetaDAO = new PlanetaDAO(); 
	    planetaDAO.init(connectionBean);
	    
	    GrupoDAO grupoDAO = new GrupoDAO(); 
	    grupoDAO.init(connectionBean);
	    
	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(PersonajeDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(PersonajeDO.ALIAS); 
	    strbuf.append(" VARCHAR(15) UNIQUE,    ");
	    strbuf.append(PersonajeDO.EXPERIENCIA); 
	    strbuf.append(" INT CHECK (experiencia>=0),   ");
	    strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO); 
	    strbuf.append(" INT,   ");
	    strbuf.append(PersonajeDO.SALUD); 
	    strbuf.append(" INT,   ");
	    strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO); 
	    strbuf.append(" INT,   ");
	    strbuf.append(PersonajeDO.NIVEL); 
	    strbuf.append(" INT,   ");
	    strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO); 
	    strbuf.append(" DATE,   ");
	    strbuf.append(PersonajeDO.USUARIO_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(usuarioDAO.getTableName());
	    strbuf.append(PersonajeDO.PLANETA_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(planetaDAO.getTableName());
	    strbuf.append(PersonajeDO.GRUPO_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(grupoDAO.getTableName());
	    
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

	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

	    PersonajeDO personajeDO = (PersonajeDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(PersonajeDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, NpcDO.class, CHECK_INSERT);

	    PersonajeDO personajeDO = (PersonajeDO) dataObject;

	    personajeDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(personajeDO.getId()); // INSTANCIA
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(personajeDO.getAlias()));
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getExperiencia());
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getPuntosDeEntrenamiento());
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getSalud());
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getEnergiaDelAnillo());
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getNivel());
	    strbuf.append(", ");
	    strbuf.append(personajeDO.getUltimaFechaIngreso());
	    strbuf.append(", ");
	    Reference<UsuarioDO> refU = personajeDO.getUsuarioRef();
	    refU.checkInsert();
	    strbuf.append(refU.getIdAsString());

	    //Done...
	    Reference<PlanetaDO> refPl = personajeDO.getPlanetaRef();
	    refPl.checkUpdate();
	    strbuf.append(refPl.getIdAsString());
	    
	    Reference<GrupoDO> refGr = personajeDO.getGrupoRef();
	    refGr.checkUpdate();
	    strbuf.append(refGr.getIdAsString());
	    
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.add(dataObject);

	}

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

	private PersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
	    PersonajeDO ret = //
	        (PersonajeDO) dtaSession.getDtaByKey( //
	            PersonajeDO.class, rs.getInt(PersonajeDO.ID));

	        if (ret != null) {
	          return ret;
	        }

	        ret = new PersonajeDO();

	        ret.setId/*     					*/(rs.getInt(PersonajeDO.ID));
	        ret.setAlias/*						*/(rs.getString(PersonajeDO.ALIAS));
	        ret.setExperiencia/*	            */(rs.getInt(PersonajeDO.EXPERIENCIA));
	        ret.setPuntosDeEntrenamiento/*	    */(rs.getInt(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO));
	        ret.setSalud/*						*/(rs.getInt(PersonajeDO.SALUD));
	        ret.setEnergiaDelAnillo/*			*/(rs.getInt(PersonajeDO.ENERGIA_DEL_ANILLO));
	        ret.setNivel/*						*/(rs.getInt(PersonajeDO.NIVEL));
	        ret.setUltimaFechaIngreso/*     	*/(rs.getDate(PersonajeDO.ULTIMA_FECHA_INGRESO));

	        Reference<UsuarioDO> refU = new Reference<UsuarioDO>();
	        refU.setRefIdent(rs.getInt(PersonajeDO.USUARIO_ID));
	        ret.setUsuarioRef(refU);
	        //Done...
	        Reference<PlanetaDO> refPl = new Reference<PlanetaDO>();
	        refPl.setRefIdent(rs.getInt(PersonajeDO.PLANETA_ID));
	        ret.setPlanetaRef(refPl);
	        
	        Reference<GrupoDO> refGr = new Reference<GrupoDO>();
	        refGr.setRefIdent(rs.getInt(PersonajeDO.GRUPO_ID));
	        ret.setGrupoRef(refGr);
	        
	        
	        return (PersonajeDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(PersonajeDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(id);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    if (rs.next()) {
	      return resultSetToDO(rs);
	    }

	    return null;
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, PersonajeDO.class, CHECK_UPDATE);

	    PersonajeDO personajeDO = (PersonajeDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(PersonajeDO.ALIAS);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(personajeDO.getAlias()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.EXPERIENCIA);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getExperiencia());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getPuntosDeEntrenamiento());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.SALUD);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getSalud());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getEnergiaDelAnillo());
	    
	    strbuf.append(", ");

	    strbuf.append(PersonajeDO.NIVEL);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getNivel());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getUltimaFechaIngreso());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.USUARIO_ID);
	    strbuf.append(" = ");
	    Reference<UsuarioDO> refP = personajeDO.getUsuarioRef();
	    refP.checkUpdate();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.PLANETA_ID);
	    strbuf.append(" = ");
	    Reference<PlanetaDO> refPl = personajeDO.getPlanetaRef();
	    refPl.checkUpdate();
	    strbuf.append(refPl.getIdAsString());
 
	    strbuf.append(", ");
	    
	    strbuf.append(PersonajeDO.GRUPO_ID);
	    strbuf.append(" = ");
	    Reference<GrupoDO> refGr = personajeDO.getGrupoRef();
	    refGr.checkUpdate();
	    strbuf.append(refGr.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(PersonajeDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}

}
