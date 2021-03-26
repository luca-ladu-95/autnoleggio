package dao;

import dao.daojdbc.JdbcDaoFactory;
import dao.file.FileDaoFactory;
import dao.interfaceDao.*;

public abstract class DaoFactory {

	public abstract AutoDao getAutoDao();
	public abstract CategoriaDao getCategoriaDao();
	public abstract NoleggioDao getNoleggioDao();
	public abstract UtenteDao getUtenteDao();
	
	
	
	
	public static DaoFactory getDaoFactory() {
		
		return new JdbcDaoFactory();
	}
}
