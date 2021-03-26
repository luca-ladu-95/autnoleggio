package dao.interfaceDao;

import java.util.List;

import model.Utente;

 public interface UtenteDao {
	
	
	boolean addUtente(Utente u);
	Utente getUtente(int id);
	Utente isRegistrato(String username, String password);
	public List<Utente> getUtenti();
	public void saveUtenti();
	public void loadUtenti();
	
	

}
