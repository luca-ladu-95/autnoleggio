package dao.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.interfaceDao.*;
import model.Utente;

public class FileUtentiDao implements UtenteDao {

	List<Utente> utenti;

	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";
	
	private FileUtentiDao() {
		
		loadUtenti();
	}
	
	private static FileUtentiDao instance = new FileUtentiDao();
	
	public static FileUtentiDao getInstance() {
		return instance;
	}

	@Override
	public boolean addUtente(Utente u) {

		if (!(this.utenti.contains(u))) {
			this.utenti.add(u);
			this.saveUtenti();
			return true;
		}

		return false;
	}

	@Override
	public Utente getUtente(int id) {
		Optional<Utente> utente = this.utenti.stream().filter(us -> us.getPERSONAL_ID() == id).findFirst();

		if (utente.isPresent())
			return utente.get();
		else
			return null;
	}

	@Override
	public Utente isRegistrato(String username, String password) {
		Optional<Utente> utente = this.utenti.stream()
				.filter(us -> us.getUsername().equals(username) && us.getPassword().equals(password)).findFirst();

		if (utente.isPresent())
			return utente.get();
		else
			return null;
	}

	@Override
	public List<Utente> getUtenti() {
		List<Utente> lista = this.utenti.stream().filter(utente -> utente.isCancellato() == false)
				.collect(Collectors.toCollection(ArrayList::new));

		return lista;
	}

	@Override
	public void saveUtenti() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Utenti"))) {

			oos.writeObject(this.utenti);
		} catch (IOException e) {

		}
	}

	@Override
	public void loadUtenti() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "Utenti"))) {

			this.utenti = (List<Utente>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			this.utenti = new ArrayList<Utente>();
		}

	}

}
