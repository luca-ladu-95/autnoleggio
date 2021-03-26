package dao.daojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.interfaceDao.*;
import model.Automobile;
import model.Categoria;
import model.Noleggio;

import static dao.daojdbc.JdbcDaoFactory.*;

public class JdbcAutoDao implements AutoDao {

	private JdbcAutoDao() {
	}

	private static JdbcAutoDao instance = new JdbcAutoDao();

	public static JdbcAutoDao getInstance() {
		return instance;
	}

	@Override
	public void addAutomobile(Automobile a) {

		String query = "insert into auto(marca,modello,colore,targa,isCancellata,id_categoria)" + "values(?,?,?,?,?,?)";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, a.getMarca());
			p.setString(2, a.getModello());
			p.setString(3, a.getColore());
			p.setString(4, utilita.TargaGenerator.getSaltString());
		
			p.setInt(5, 0);
			p.setInt(6, a.getCategoria().getPERSONAL_ID());
			int righeInserite = p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	 @Override
	public List<Automobile> getAutoMarca(String marca) {
		List<Automobile> automobili = new ArrayList<Automobile>();
		String query = "select * from auto where marca=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, marca);

			ResultSet result = p.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				marca = result.getString("marca");
				String modello = result.getString("modello");
				String colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata") == 1;
				int id_categoria = result.getInt("id_categoria");

				Categoria categoria = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(id_categoria);

				automobili.add(new Automobile(id, marca, modello, targa, categoria, colore, isCancellata));
			}

		} catch (SQLException e) {

		}

		return automobili;
	}

	 @Override
	public List<Automobile> getAutoColore(String colore) {
		List<Automobile> automobili = new ArrayList<Automobile>();
		String query = "select * from auto where colore=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, colore);

			ResultSet result = p.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String marca = result.getString("marca");
				String modello = result.getString("modello");
				colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata") == 1;
				int id_categoria = result.getInt("id_categoria");

				Categoria categoria = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(id_categoria);

				automobili.add(new Automobile(id, marca, modello, targa, categoria, colore, isCancellata));
			}

		} catch (SQLException e) {

		}

		return automobili;
	}

	 @Override
	public List<Automobile> getAutoModello(String modello) {
		List<Automobile> automobili = new ArrayList<Automobile>();
		String query = "select * from auto where modello=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, modello);

			ResultSet result = p.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String marca = result.getString("marca");
				modello = result.getString("modello");
				String colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata") == 1;
				int id_categoria = result.getInt("id_categoria");

				Categoria categoria = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(id_categoria);

				automobili.add(new Automobile(id, marca, modello, targa, categoria, colore, isCancellata));
			}

		} catch (SQLException e) {

		}

		return automobili;
	}
	
	 @Override
	public List<Automobile> getAutoCategoria(String categoria){
		List<Automobile> automobili = new ArrayList<Automobile>();
		String query = "select * from auto where categoria=?";
		
		try(Connection c = getConnection();
				PreparedStatement p = c.prepareStatement(query)){
			
			p.setString(1, categoria);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				int id = result.getInt("id");
				String marca = result.getString("marca");
				String modello = result.getString("modello");
				String colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata")==1;
				int id_categoria = result.getInt("id_categoria");
				
				Categoria cate = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(categoria);
				
				automobili.add(new Automobile(id,marca,modello,targa,cate,colore,isCancellata));
			}
			
		}catch (SQLException e) {
			
			
		}
		
		return automobili;
	}

	@Override
	public Automobile getAuto(int id) {

		String query = "select * from auto where id=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setInt(1, id);

			ResultSet result = p.executeQuery();

			if (result.next()) {
				id = result.getInt("id");
				String marca = result.getString("marca");
				String modello = result.getString("modello");
				String colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata") == 1;
				int id_categoria = result.getInt("id_categoria");

				Categoria categoria = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(id_categoria);

				if (categoria != null) {

					return new Automobile(id, marca, modello, targa, categoria, colore, isCancellata);
				} else
					return null;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public void deleteAutomobile(int id) {

		String query = "update auto set isCancellata=true where id=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, Integer.valueOf(id).toString());

			int r = p.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Automobile> getAutomobili() {
		List<Automobile> automobili = new ArrayList<Automobile>();
		String query = "select * from auto";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet result = s.executeQuery(query);

			while (result.next()) {
				int id = result.getInt("id");
				String marca = result.getString("marca");
				String modello = result.getString("modello");
				String colore = result.getString("colore");
				String targa = result.getString("targa");
				boolean isCancellata = result.getInt("isCancellata") == 1;
				int id_categoria = result.getInt("id_categoria");

				Categoria categoria = JdbcDaoFactory.getDaoFactory().getCategoriaDao().getGategoria(id_categoria);

				if (categoria != null) {

					automobili.add(new Automobile(id, marca, modello, targa, categoria, colore, isCancellata));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return automobili;
	}

	@Override
	public void saveAutomobili() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadAutomobili() {
		// TODO Auto-generated method stub

	}

}
