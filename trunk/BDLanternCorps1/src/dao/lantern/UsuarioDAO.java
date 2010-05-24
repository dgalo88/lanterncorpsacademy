package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;

public class UsuarioDAO extends BaseDAO implements IUsuarioDAO{

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

	    PersonajeDAO personajeDAO = new PersonajeDAO(); 
	    personajeDAO.init(connectionBean);
	    
	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(UsuarioDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(UsuarioDO.NOMBRE); 
	    strbuf.append(" VARCHAR(50) UNIQUE,    ");
	    strbuf.append(UsuarioDO.CORREO); 
	    strbuf.append(" VARCHAR(30) NOT NULL UNIQUE,   ");
	    strbuf.append(UsuarioDO.CLAVE); 
	    strbuf.append(" VARCHAR(12) NOT NULL,   ");
	    strbuf.append(UsuarioDO.PERSONAJE_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(personajeDAO.getTableName());
	    
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, UsuarioDO.class, CHECK_INSERT);

	    UsuarioDO usuarioDO = (UsuarioDO) dataObject;

	    usuarioDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(usuarioDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(usuarioDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(usuarioDO.getCorreo()));
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(usuarioDO.getClave()));
	    strbuf.append(", ");
	    Reference<IPersonajeDO> refP = usuarioDO.getPersonajeRef();
	    refP.checkInsert();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.add(dataObject);

	}
	
	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, UsuarioDO.class, CHECK_UPDATE);

	    UsuarioDO usuarioDO = (UsuarioDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(UsuarioDO.NOMBRE);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(usuarioDO.getNombre()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(UsuarioDO.CORREO);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(usuarioDO.getCorreo()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(UsuarioDO.CLAVE);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(usuarioDO.getClave()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(UsuarioDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    Reference<IPersonajeDO> refP = usuarioDO.getPersonajeRef();
	    refP.checkUpdate();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(UsuarioDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(usuarioDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}
	
	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, UsuarioDO.class, CHECK_DELETE);

	    UsuarioDO usuarioDO = (UsuarioDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(UsuarioDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(usuarioDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}
	
	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(UsuarioDO.ID);
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
	
	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<UsuarioDO> listByPersonajeId(int personajeId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(UsuarioDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<UsuarioDO> ret = new ArrayList<UsuarioDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }

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

	private UsuarioDO resultSetToDO(ResultSet rs) throws SQLException {
	    UsuarioDO ret = //
	        (UsuarioDO) dtaSession.getDtaByKey( //
	            UsuarioDO.class, rs.getInt(UsuarioDO.ID));

	        if (ret != null) {
	          return ret;
	        }

	        ret = new UsuarioDO();

	        ret.setId/*     					*/(rs.getInt(UsuarioDO.ID));
	        ret.setNombre/*						*/(rs.getString(UsuarioDO.NOMBRE));
	        ret.setCorreo/*						*/(rs.getString(UsuarioDO.CORREO));
	        ret.setClave/*						*/(rs.getString(UsuarioDO.CLAVE));

	        Reference<IPersonajeDO> refP = new Reference<IPersonajeDO>();
	        refP.setRefIdent(rs.getInt(UsuarioDO.PERSONAJE_ID));
	        ret.setPersonajeRef(refP);
	        
	        return (UsuarioDO) dtaSession.add(ret);
	}
	
	  public void loadPersonajeRef(IUsuarioDO usuarioDO) throws SQLException {
		    checkClass(usuarioDO, UsuarioDO.class, CHECK_UPDATE);

		    PersonajeDAO personajeDAO = new PersonajeDAO();
		    personajeDAO.init(connectionBean);

		    Reference<IPersonajeDO> ref = usuarioDO.getPersonajeRef();

		    if (ref.getRefIdent() == 0) {
		      return;
		    }

		    PersonajeDO personajeDO = //
		    	(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		        ref.setRefValue(personajeDO);
	  }
	  
      public boolean checkIfUsuarioExists(String correo) throws SQLException {
          StringBuffer strbuf = new StringBuffer();

          strbuf.append("SELECT * FROM ");
          strbuf.append(getTableName());

          strbuf.append(" WHERE ");
//          strbuf.append(UsuarioDO.NOMBRE);
//          strbuf.append(" = ");
//          strbuf.append(singleQuotes(nombre));
//          strbuf.append(" OR ");
          strbuf.append(UsuarioDO.CORREO);
          strbuf.append(" = ");
          strbuf.append(singleQuotes(correo));
          
          System.err.println(strbuf.toString());

          ResultSet rs = connection.createStatement().executeQuery(
                          strbuf.toString());

          if(rs.next()) {
                  return true;
          }
          
          return false;
  }

      
      public IUsuarioDO loadByCorreo(String mail) throws SQLException {
  	    StringBuffer strbuf = new StringBuffer();

  	    strbuf.append("SELECT * FROM ");
  	    strbuf.append(getTableName());

  	    strbuf.append(" WHERE ");
  	    strbuf.append(UsuarioDO.CORREO);
  	    strbuf.append(" = ");
  	    strbuf.append(singleQuotes(mail));

  	    System.err.println(strbuf.toString());

  	    ResultSet rs = //
  	    connection.createStatement().executeQuery(strbuf.toString());

  	    if (rs.next()) {
  	      return resultSetToDO(rs);
  	    }

  	    return null;
  	}

	@Override
	public IPersonajeDO login(IUsuarioDO usuarioDO) throws SQLException {
        checkCache(usuarioDO, CHECK_INSERT);
        checkClass(usuarioDO, UsuarioDO.class, CHECK_INSERT);
        
        StringBuffer strbuf = new StringBuffer();
        strbuf.append("SELECT * FROM ");
        strbuf.append(getTableName());
        strbuf.append(" WHERE ");
        strbuf.append(UsuarioDO.CORREO);
        strbuf.append(" = ");
        strbuf.append(singleQuotes(usuarioDO.getCorreo()));
        strbuf.append(" AND ");
        strbuf.append(UsuarioDO.CLAVE);
        strbuf.append(" = ");
        strbuf.append(singleQuotes(usuarioDO.getClave()));
        System.err.println(strbuf.toString());
        ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
        
        PersonajeDO personajeDO=new PersonajeDO();
        
        if(rs.next()){  
                PersonajeDAO personajeDAO;
                try {
                        personajeDAO = (PersonajeDAO) FactoryDAO.getDAO(PersonajeDAO.class, connectionBean);
                        usuarioDO = (UsuarioDO) dtaSession.add(resultSetToDO(rs));
                        System.out.print(usuarioDO.getId());
                        personajeDO= (PersonajeDO) personajeDAO.loadById(usuarioDO.getId());
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
                
        }
        return personajeDO;

	}
}
