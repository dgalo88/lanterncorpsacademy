package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import dao.lantern.HabilidadDO;



public class HabilidadDAO extends BaseDAO {

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

//	    HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = new HabilidadClaseLinternaDAO(); // Used to make the FK
//	    habilidadClaseLinternaDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(HabilidadDO.NOMBRE); //AQUI VA EL NOMBRE DE LA COLUMNA STATIC FINAL
	    strbuf.append(" VARCHAR(100),    ");
	    strbuf.append(HabilidadDO.COST);
	    strbuf.append(" INT CHECK (costo_aprendizaje>=0),    ");
	    strbuf.append(HabilidadDO.TIPO);
	    strbuf.append(" INT,    ");
//	    strbuf.append(HabilidadDO.CLASE_ID);
//	    strbuf.append(" INT REFERENCES   ");
//	    strbuf.append(habilidadClaseLinternaDAO.getTableName());
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
	public void delete(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

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
	    strbuf.append(", ");
	    Reference<HabilidadClaseLinternaDO> ref = habilidadDO.getHabilidadClaseLinternaRef();
	    ref.checkInsert();
	    strbuf.append(ref.getIdAsString());

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

	
	
}
