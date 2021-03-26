package dao.interfaceDao;

import java.util.List;

import model.Categoria;

public interface CategoriaDao {

	
	Categoria getGategoria(int id);
	 List<Categoria> getCategorie();
	 boolean addCategoria(Categoria c);
	 void saveCategorie();
	 void loadCategorie();
	 Categoria getGategoria(String nome);
	
}
