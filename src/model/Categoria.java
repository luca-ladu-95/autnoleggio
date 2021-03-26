package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable{
	
	private final String path ="C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2801469264827500348L;
	private String nome;
	private static int ID;
	private final int PERSONAL_ID;
	private double prezzoGiornaliero;
	private double prezzoSettimanale;
	private double prezzoMensile;
	private boolean isCancellato;
	
	public Categoria(String nome, double prezzoGiornaliero, double prezzoSettimanale, double prezzoMensile) {
		super();
		this.nome = nome;
		this.prezzoGiornaliero = prezzoGiornaliero;
		this.prezzoSettimanale = prezzoSettimanale;
		this.prezzoMensile = prezzoMensile;
		this.loadIdFromFile(); //carico ultimo id salvato
		ID++;
		this.PERSONAL_ID = ID;
		this.isCancellato=false;
		this.saveIdToFile(); // salvo questo id
		
	}
	
	public Categoria(int personalID,String nome, double prezzoGiornaliero, double prezzoSettimanale, double prezzoMensile,boolean isCancellato) {
		super();
		this.nome = nome;
		this.prezzoGiornaliero = prezzoGiornaliero;
		this.prezzoSettimanale = prezzoSettimanale;
		this.prezzoMensile = prezzoMensile;	
		this.PERSONAL_ID = personalID;
		this.isCancellato=false;
		this.isCancellato = isCancellato;
		
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzoGiornaliero() {
		return prezzoGiornaliero;
	}

	public void setPrezzoGiornaliero(double prezzoGiornaliero) {
		this.prezzoGiornaliero = prezzoGiornaliero;
	}

	public double getPrezzoSettimanale() {
		return prezzoSettimanale;
	}

	public void setPrezzoSettimanale(double prezzoSettimanale) {
		this.prezzoSettimanale = prezzoSettimanale;
	}

	public double getPrezzoMensile() {
		return prezzoMensile;
	}

	public void setPrezzoMensile(double prezzoMensile) {
		this.prezzoMensile = prezzoMensile;
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
		return "Categoria [nome=" + nome + ", prezzoGiornaliero=" + prezzoGiornaliero + ", prezzoSettimanale="
				+ prezzoSettimanale + ", prezzoMensile=" + prezzoMensile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Categoria other = (Categoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equalsIgnoreCase(other.nome))
			return false;
		return true;
	}
	
	
	private void saveIdToFile() {
		
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path+"IdCategoria"))){
			
			oos.writeObject(ID);
		}catch (IOException e) {
			
		}
		
		
	}
	
	
	
	private void loadIdFromFile() {
		
		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+"IdCategoria"))) {

			ID = (int) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			ID = 0;
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
