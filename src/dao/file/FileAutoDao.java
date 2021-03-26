package dao.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.DaoFactory;
import dao.daojdbc.JdbcDaoFactory;
import dao.interfaceDao.*;
import model.Automobile;
import model.Categoria;
import model.Noleggio;

public class FileAutoDao implements AutoDao {

	List<Automobile> automobili;
	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";

	private static FileAutoDao instance = new FileAutoDao();

	private FileAutoDao() {

		loadAutomobili();
	}

	public static FileAutoDao getInstance() {
		return instance;
	}

	@Override
	public void addAutomobile(Automobile a) {
		if (!(this.automobili.contains(a))) {
			this.automobili.add(a);
			this.saveAutomobili();
		}

	}

	

	@Override
	public Automobile getAuto(int id) {
		for (int i = 0; i < this.automobili.size(); i++) {

			if (this.automobili.get(i).getPERSONAL_ID() == id) {

				return this.automobili.get(i);
			}
		}
		return null;
	}

	@Override
	public void deleteAutomobile(int id) {

		for (int i = 0; i < this.automobili.size(); i++) {

			if (this.automobili.get(i).getPERSONAL_ID() == id) {
				this.automobili.get(i).setCancellata(true);
				// Devo eliminare tutte le prenotazioni future??
				FileNoleggioDao.getInstance().deletePrenotazione(id);

				break;
			}
		}

		this.saveAutomobili();
		
	}

	@Override
	public List<Automobile> getAutomobili() {
		// If don't match return empty list
		List<Automobile> lista = this.automobili.stream().filter(auto -> auto.isCancellata() == false)
				.collect(Collectors.toCollection(ArrayList::new));

		return lista;
	}

	@Override
	public void saveAutomobili() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Automobili"))) {

			oos.writeObject(this.automobili);
		} catch (IOException e) {

		}

	}

	@Override
	public void loadAutomobili() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "Automobili"))) {

			this.automobili = (List<Automobile>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			this.automobili = new ArrayList<Automobile>();
		}

	}

	@Override
	public List<Automobile> getAutoCategoria(String categoria) {
		List<Automobile> automobili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();
		List<Automobile> ritorno = null;
		Categoria cate = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(categoria);
		
		if(cate != null) {
		ritorno = automobili.stream().filter(auto -> auto.getCategoria().getNome().equalsIgnoreCase(cate.getNome()))
				.collect(Collectors.toCollection(ArrayList::new));
		}
		return ritorno;
	}

	@Override
	public List<Automobile> getAutoModello(String modello) {
		List<Automobile> automobili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();
		List<Automobile> ritorno = null;
		
		ritorno = automobili.stream().filter(auto -> auto.getModello().equalsIgnoreCase(modello))
				.collect(Collectors.toCollection(ArrayList::new));
		
		return ritorno;
	}

	@Override
	public List<Automobile> getAutoColore(String colore) {
		List<Automobile> automobili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();
		List<Automobile> ritorno = null;
		
		ritorno = automobili.stream().filter(auto -> auto.getColore().equalsIgnoreCase(colore))
				.collect(Collectors.toCollection(ArrayList::new));
		
		return ritorno;
	}

	@Override
	public List<Automobile> getAutoMarca(String marca) {
		List<Automobile> automobili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();
		List<Automobile> ritorno = null;
		
		ritorno = automobili.stream().filter(auto -> auto.getMarca().equalsIgnoreCase(marca))
				.collect(Collectors.toCollection(ArrayList::new));
		
		return ritorno;
	}

}
