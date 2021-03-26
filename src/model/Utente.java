package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;

public class Utente implements Serializable{
	private final String path ="C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";

	/**
	 * 
	 */
	private static final long serialVersionUID = -9019688413772617994L;
	
	private static int ID=0;
	private final int PERSONAL_ID;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataDiNascita;
	private boolean isCancellato;
	
	
	
	public Utente(String nome, String cognome, String username, String password, Date dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataDiNascita = dataDiNascita;
		this.loadIdFromFile();
		ID++;
		this.PERSONAL_ID = ID;
		this.isCancellato = false;
		this.saveIdToFile();
	}
	
	
	public Utente(int id,String nome, String cognome, String username, String password, Date dataDiNascita,boolean isCancellato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataDiNascita = dataDiNascita;
		this.PERSONAL_ID = id;
		this.isCancellato = isCancellato;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}



	public boolean isCancellato() {
		return isCancellato;
	}



	public void setCancellato(boolean isCancellato) {
		this.isCancellato = isCancellato;
	}



	public int getPERSONAL_ID() {
		return PERSONAL_ID;
	}



	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equalsIgnoreCase(other.username))
			return false;
		return true;
	}
	
	private void saveIdToFile() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "IdUtente"))) {

			oos.writeObject(ID);
		} catch (IOException e) {

		}

	}

	private void loadIdFromFile() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "IdUtente"))) {

			ID = (int) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			ID = 0;
		}

	}
	
	
	
	
	
	
	
	

}
