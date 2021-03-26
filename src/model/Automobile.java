package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Automobile implements Serializable {

	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";
	/**
	 * 
	 */
	private static final long serialVersionUID = -5076902295150091797L;
	private final int PERSONAL_ID;
	private static int ID;
	private String marca;
	private String modello;
	private String targa;
	private String colore;
	private Categoria categoria;
	private boolean isCancellata;

	public Automobile(String marca, String modello, String targa, Categoria categoria,String colore) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.categoria = categoria;
		this.loadIdFromFile();
		ID++;
		this.PERSONAL_ID = ID;
		this.targa = targa;
		this.isCancellata = false;
		this.colore= colore;
		this.saveIdToFile();
	}
	
	public Automobile(int personalID,String marca, String modello, String targa, Categoria categoria,String colore,boolean isCancellata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.categoria = categoria;
		this.PERSONAL_ID = personalID;
		this.targa = targa;
		this.isCancellata = isCancellata;
		this.colore= colore;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public String getColore() {
		
		return this.colore;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isCancellata() {
		return isCancellata;
	}

	public void setCancellata(boolean isCancellata) {
		this.isCancellata = isCancellata;
	}

	public String getTarga() {
		return this.targa;
	}

	public int getPERSONAL_ID() {
		return PERSONAL_ID;
	}

	@Override
	public String toString() {
		return "\nAutomobile [marca=" + marca + ", modello=" + modello + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targa == null) ? 0 : targa.hashCode());
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
		Automobile other = (Automobile) obj;
		if (targa == null) {
			if (other.targa != null)
				return false;
		} else if (!targa.equalsIgnoreCase(other.targa))
			return false;
		return true;
	}

	private void saveIdToFile() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "IdAutomobile"))) {

			oos.writeObject(ID);
		} catch (IOException e) {

		}

	}

	private void loadIdFromFile() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "IdAutomobile"))) {

			ID = (int) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			ID = 0;
		}

	}

}
