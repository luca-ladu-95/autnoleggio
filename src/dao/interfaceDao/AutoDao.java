package dao.interfaceDao;

import java.util.List;

import model.Automobile;
import model.Noleggio;

public interface AutoDao {

	
	void addAutomobile(Automobile a);
	
	Automobile getAuto(int id);
	void deleteAutomobile(int id);
	List<Automobile> getAutomobili();
	void saveAutomobili();
	void loadAutomobili();
	public List<Automobile> getAutoCategoria(String categoria);
	public List<Automobile> getAutoModello(String modello);
	public List<Automobile> getAutoColore(String colore);
	public List<Automobile> getAutoMarca(String marca);
}
