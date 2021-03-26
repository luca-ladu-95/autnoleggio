package dao.file;

import dao.DaoFactory;
import dao.interfaceDao.AutoDao;
import dao.interfaceDao.CategoriaDao;
import dao.interfaceDao.NoleggioDao;
import dao.interfaceDao.UtenteDao;

//Mi restituisce solo le istanze delle classi 
public class FileDaoFactory extends DaoFactory {

	@Override
	public AutoDao getAutoDao() {

		return FileAutoDao.getInstance();
	}

	@Override
	public CategoriaDao getCategoriaDao() {

		return FileCategoriaDao.getInstance();
	}

	@Override
	public NoleggioDao getNoleggioDao() {
		return FileNoleggioDao.getInstance();
	}

	@Override
	public UtenteDao getUtenteDao() {
		return FileUtentiDao.getInstance();
	}

	// TODO per tutti

}
