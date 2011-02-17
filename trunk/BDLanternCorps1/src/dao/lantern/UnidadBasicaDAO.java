package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDAO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class UnidadBasicaDAO extends BaseDAO implements IUnidadBasicaDAO {

	public UnidadBasicaDAO() {

	}

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

		TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
		tecnologiaDAO.init(connectionBean);

		UnidadEjercitoDAO unidadEjercitoDAO = new UnidadEjercitoDAO();
		unidadEjercitoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UnidadBasicaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UnidadBasicaDO.NOMBRE);
		strbuf.append(" VARCHAR(50) UNIQUE,    ");
		strbuf.append(UnidadBasicaDO.DEFENSA);
		strbuf.append(" INT,   ");
		strbuf.append(UnidadBasicaDO.ATAQUE);
		strbuf.append(" INT,   ");
		strbuf.append(UnidadBasicaDO.TIPO);
		strbuf.append(" INT,   ");

		strbuf.append(UnidadBasicaDO.TECNOLOGIA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(tecnologiaDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_ARMA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_BALA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_ROBOT_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_VEHICULO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());

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

	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_DELETE);

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_INSERT);

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

		unidadBasicaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(unidadBasicaDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(unidadBasicaDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getDefensa());
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getAtaque());
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getTipo());
		strbuf.append(", ");

		Reference<ITecnologiaDO> ref = unidadBasicaDO.getTecnologiaRef();
		ref.checkInsert();
		strbuf.append(ref.getIdAsString());

		strbuf.append(", ");

		Reference<IUnidadEjercitoDO> ref1 = unidadBasicaDO
				.getUnidadEjercitoArmaRef();
		ref.checkInsert();
		strbuf.append(ref1.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadEjercitoDO> ref2 = unidadBasicaDO
				.getUnidadEjercitoBalaRef();
		ref.checkInsert();
		strbuf.append(ref2.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadEjercitoDO> ref3 = unidadBasicaDO
				.getUnidadEjercitoRobotRef();
		ref.checkInsert();
		strbuf.append(ref3.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadEjercitoDO> ref4 = unidadBasicaDO
				.getUnidadEjercitoVehiculoRef();
		ref.checkInsert();
		strbuf.append(ref4.getIdAsString());

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

	private DataObject resultSetToDO(ResultSet rs) throws SQLException {
		UnidadBasicaDO ret = //
		(UnidadBasicaDO) dtaSession.getDtaByKey( //
				UnidadBasicaDO.class, rs.getInt(UnidadBasicaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadBasicaDO();

		ret.setId/*      */(rs.getInt(UnidadBasicaDO.ID));
		ret.setNombre/*  */(rs.getString(UnidadBasicaDO.NOMBRE));
		ret.setDefensa/* */(rs.getInt(UnidadBasicaDO.DEFENSA));
		ret.setAtaque/*  */(rs.getInt(UnidadBasicaDO.ATAQUE));
		ret.setTipo/*    */(rs.getInt(UnidadBasicaDO.TIPO));

		ret.setTecnologiaId(rs.getInt(UnidadBasicaDO.TECNOLOGIA_ID));
		ret.setUnidadEjercitoArmaId(rs
				.getInt(UnidadBasicaDO.UNIDAD_EJERCITO_ARMA_ID));
		ret.setUnidadEjercitoBalaId(rs
				.getInt(UnidadBasicaDO.UNIDAD_EJERCITO_BALA_ID));
		ret.setUnidadEjercitoRobotId(rs
				.getInt(UnidadBasicaDO.UNIDAD_EJERCITO_ROBOT_ID));
		ret.setUnidadEjercitoVehiculoId(rs
				.getInt(UnidadBasicaDO.UNIDAD_EJERCITO_VEHICULO_ID));

		return (UnidadBasicaDO) dtaSession.add(ret);
	}

	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaDO.ID);
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

	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_UPDATE);

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(UnidadBasicaDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(unidadBasicaDO.getNombre()));
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.DEFENSA);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getDefensa());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.ATAQUE);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getAtaque());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.TIPO);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getTipo());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.TECNOLOGIA_ID);
		strbuf.append(" = ");

		if (unidadBasicaDO.getTecnologiaRef() == null) {
			if (unidadBasicaDO.getTecnologiaId() == 0) {
				strbuf.append("NULL");
			} else {
				strbuf.append(unidadBasicaDO.getTecnologiaId());
			}
		} else {
			if (unidadBasicaDO.getTecnologiaRef().getId() == 0) {
				throw new IllegalArgumentException( //
						"unidadBasicaDO.getTecnologiaRef().getId() == 0");
			} else {
				unidadBasicaDO.setTecnologiaId( //
						unidadBasicaDO.getTecnologiaRef().getId());
				strbuf.append(unidadBasicaDO.getTecnologiaId());
			}
		}
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_ARMA_ID);
		strbuf.append(" = ");

		if (unidadBasicaDO.getUnidadEjercitoArmaRef() == null) {
			if (unidadBasicaDO.getUnidadEjercitoArmaId() == 0) {
				strbuf.append("NULL");
			} else {
				strbuf.append(unidadBasicaDO.getUnidadEjercitoArmaRef());
			}
		} else {
			if (unidadBasicaDO.getUnidadEjercitoArmaRef().getId() == 0) {
				throw new IllegalArgumentException( //
						"unidadBasicaDO.getUnidadEjercitoArmaRef().getId() == 0");
			} else {
				unidadBasicaDO.setUnidadEjercitoArmaId( //
						unidadBasicaDO.getUnidadEjercitoArmaRef().getId());
				strbuf.append(unidadBasicaDO.getUnidadEjercitoArmaId());
			}
		}
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_BALA_ID);
		strbuf.append(" = ");

		if (unidadBasicaDO.getUnidadEjercitoBalaRef() == null) {
			if (unidadBasicaDO.getUnidadEjercitoBalaId() == 0) {
				strbuf.append("NULL");
			} else {
				strbuf.append(unidadBasicaDO.getUnidadEjercitoBalaRef());
			}
		} else {
			if (unidadBasicaDO.getUnidadEjercitoBalaRef().getId() == 0) {
				throw new IllegalArgumentException( //
						"unidadBasicaDO.getUnidadEjercitoBalaRef().getId() == 0");
			} else {
				unidadBasicaDO.setUnidadEjercitoBalaId( //
						unidadBasicaDO.getUnidadEjercitoBalaRef().getId());
				strbuf.append(unidadBasicaDO.getUnidadEjercitoBalaId());
			}
		}
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_ROBOT_ID);
		strbuf.append(" = ");

		if (unidadBasicaDO.getUnidadEjercitoRobotRef() == null) {
			if (unidadBasicaDO.getUnidadEjercitoRobotId() == 0) {
				strbuf.append("NULL");
			} else {
				strbuf.append(unidadBasicaDO.getUnidadEjercitoRobotRef());
			}
		} else {
			if (unidadBasicaDO.getUnidadEjercitoRobotRef().getId() == 0) {
				throw new IllegalArgumentException( //
						"unidadBasicaDO.getUnidadEjercitoRobotRef().getId() == 0");
			} else {
				unidadBasicaDO.setUnidadEjercitoRobotId( //
						unidadBasicaDO.getUnidadEjercitoRobotRef().getId());
				strbuf.append(unidadBasicaDO.getUnidadEjercitoRobotId());
			}
		}
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.UNIDAD_EJERCITO_VEHICULO_ID);
		strbuf.append(" = ");

		if (unidadBasicaDO.getUnidadEjercitoVehiculoRef() == null) {
			if (unidadBasicaDO.getUnidadEjercitoVehiculoId() == 0) {
				strbuf.append("NULL");
			} else {
				strbuf.append(unidadBasicaDO.getUnidadEjercitoVehiculoRef());
			}
		} else {
			if (unidadBasicaDO.getUnidadEjercitoVehiculoRef().getId() == 0) {
				throw new IllegalArgumentException( //
						"unidadBasicaDO.getUnidadEjercitoVehiculoRef().getId() == 0");
			} else {
				unidadBasicaDO.setUnidadEjercitoVehiculoId( //
						unidadBasicaDO.getUnidadEjercitoVehiculoRef().getId());
				strbuf.append(unidadBasicaDO.getUnidadEjercitoVehiculoId());
			}
		}

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

}
