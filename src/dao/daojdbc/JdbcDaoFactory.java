package dao.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.DaoFactory;
import dao.interfaceDao.AutoDao;
import dao.interfaceDao.CategoriaDao;
import dao.interfaceDao.NoleggioDao;
import dao.interfaceDao.UtenteDao;

public class JdbcDaoFactory extends DaoFactory{

	
	
	public JdbcDaoFactory() {}
	
	
	@Override
	public AutoDao getAutoDao() {
	
		return JdbcAutoDao.getInstance();
	}

	@Override
	public CategoriaDao getCategoriaDao() {
		
		return JdbcCategoriaDao.getInstance();
	}

	@Override
	public NoleggioDao getNoleggioDao() {
	
		return JdbcNoleggioDao.getInstance();
	}

	@Override
	public UtenteDao getUtenteDao() {
		
		return JdbcUtenteDao.getInstance();
	}
	
	
//	protected static Connection getConnection() throws SQLException {
//		String indirizzoDatabase="jdbc:mysql://localhost:3306/autonoleggio?serverTimezone=UTC";
//		String usernameDatabase="root";
//		String passwordDatabase="admin";
//		//andiamo a dirgli di forza di caricare i nostri driver;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//		}
//		
//		
//		Connection c=DriverManager.getConnection(indirizzoDatabase,usernameDatabase,passwordDatabase);
//		return c;
//	}
	
	protected static Connection getConnection() throws SQLException {
		
		try {
			DataSource d = InitialContext.doLookup("java:comp/env/jdbc/autonoleggio");
			return d.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
