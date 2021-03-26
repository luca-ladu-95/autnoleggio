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
import model.Categoria;

public class FileCategoriaDao implements CategoriaDao {

	List<Categoria> categorie;
	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";

	private FileCategoriaDao() {

		loadCategorie();
	}

	private static FileCategoriaDao instance = new FileCategoriaDao();

	public static FileCategoriaDao getInstance() {
		return instance;
	}

	@Override
	public Categoria getGategoria(int id) {
		Optional<Categoria> cate = this.categorie.stream().filter(cat -> cat.getPERSONAL_ID() == id).findFirst();

		if (cate.isPresent())
			return cate.get();
		else
			return null;
	}

	@Override
	public List<Categoria> getCategorie() {
		List<Categoria> lista = this.categorie.stream().filter(categoria -> categoria.isCancellato() == false)
				.collect(Collectors.toCollection(ArrayList::new));

		return lista;
	}

	@Override
	public boolean addCategoria(Categoria c) {
		if (!(this.categorie.contains(c))) {

			this.categorie.add(c);
			this.saveCategorie();
			return true;
		}

		return false;
	}

	@Override
	public void saveCategorie() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Categorie"))) {

			oos.writeObject(this.categorie);
		} catch (IOException e) {

		}
	}

	@Override
	public void loadCategorie() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "Categorie"))) {

			this.categorie = (List<Categoria>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			this.categorie = new ArrayList<Categoria>();
		}

	}

	@Override
	public Categoria getGategoria(String nome) {
		
		Optional<Categoria> cate = this.categorie.stream().filter(cat -> cat.getNome().equalsIgnoreCase(nome)).findFirst();

		if (cate.isPresent())
			return cate.get();
		else
			return null;
	}
}
