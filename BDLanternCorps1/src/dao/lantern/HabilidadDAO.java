package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;



public class HabilidadDAO extends BaseDAO implements IHabilidadDAO{

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

	    HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = new HabilidadClaseLinternaDAO(); // Used to make the FK
	    habilidadClaseLinternaDAO.init(connectionBean);
	    
	    NivelHabilidadDAO nivelHabilidadDAO = new NivelHabilidadDAO(); // Used to make the FK
	    nivelHabilidadDAO.init(connectionBean);
	    //TODO these DAOs
	    HabilidadActivaDAO habilidadActivaDAO = new HabilidadActivaDAO(); // Used to make the FK
	    habilidadActivaDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(HabilidadDO.NOMBRE); //AQUI VA EL NOMBRE DE LA COLUMNA STATIC FINAL
	    strbuf.append(" VARCHAR(100),    ");
	    strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
	    strbuf.append(" INT CHECK (costo_aprendizaje>=0),    ");
	    strbuf.append(HabilidadDO.TIPO);
	    strbuf.append(" INT    ");
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
	    strbuf.append(habilidadDO.getId()); // INSTANCIA
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
		//return null;
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
	    strbuf.append(HabilidadDO.ID);
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

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

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

    private HabilidadDO resultSetToDO(ResultSet rs) throws SQLException {
  	  HabilidadDO ret = //
      (HabilidadDO) dtaSession.getDtaByKey( //
      		HabilidadDO.class, rs.getInt(HabilidadDO.ID));

      if (ret != null) {
        return ret;
      }

      ret = new HabilidadDO();

      ret.setId/*     */(rs.getInt(HabilidadDO.ID));
      ret.setNombre/*   */(rs.getString(HabilidadDO.NOMBRE));
      ret.setCosto_de_aprendizaje((rs.getInt(HabilidadDO.COSTO_DE_APRENDIZAJE)));
      ret.setTipo(rs.getInt(HabilidadDO.TIPO));
 
      return (HabilidadDO) dtaSession.add(ret);	
    }
    
    public void loadNivelHabilidadList(IHabilidadDO habilidadDO) throws Exception {
        checkCache(habilidadDO, CHECK_UPDATE);

        NivelHabilidadDAO nivelHabilidadDAO = (NivelHabilidadDAO) FactoryDAO.getDAO( //
        NivelHabilidadDAO.class, connectionBean);

        habilidadDO.setNivelHabilidadList(nivelHabilidadDAO.listByHabilidadId(habilidadDO.getId()));
      }
    
    public void loadHabilidadClaseLinternaList(IHabilidadDO habilidadDO) throws Exception {
        checkCache(habilidadDO, CHECK_UPDATE);

        HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = (HabilidadClaseLinternaDAO) FactoryDAO.getDAO( //
        HabilidadClaseLinternaDAO.class, connectionBean);

        habilidadDO.setHabilidadClaseLinternaList(habilidadClaseLinternaDAO.listByClaseId(habilidadDO.getId()));
      }
    
    public void loadHabilidadActivaList(IHabilidadDO habilidadDO) throws Exception {
        checkCache(habilidadDO, CHECK_UPDATE);

        HabilidadActivaDAO habilidadActivaDAO = (HabilidadActivaDAO) FactoryDAO.getDAO( //
        HabilidadActivaDAO.class, connectionBean);

        habilidadDO.setHabilidadActivaList(habilidadActivaDAO.listByHabilidadId(habilidadDO.getId()));
      }
}
