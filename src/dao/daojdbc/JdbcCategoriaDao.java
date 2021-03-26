package dao.daojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.interfaceDao.CategoriaDao;
import model.Categoria;
import static dao.daojdbc.JdbcDaoFactory.*;
public class JdbcCategoriaDao implements CategoriaDao{

	
	private JdbcCategoriaDao() {};
	
	private static JdbcCategoriaDao instance = new JdbcCategoriaDao();
	
	public static JdbcCategoriaDao getInstance() {
		return instance;
	}
	
	
	@Override
	public Categoria getGategoria(int id) {
		String query = "select * from categoria where id="+id;
		
		try(Connection c = getConnection();
				Statement s = c.createStatement()){
			
			ResultSet result = s.executeQuery(query);
			if(result.next()) {
				
				id = result.getInt("id");
				String nome = result.getString("nome");
				double prezzoGiornaliero = result.getDouble("prezzo_giornaliero");
				double prezzoSettimanale = result.getDouble("prezzo_settimanale");
				double prezzoMensile = result.getDouble("prezzo_mensile");
				boolean isCancellata = result.getInt("isCancellata")==1;
				
				return new Categoria(id,nome,prezzoGiornaliero,prezzoSettimanale,prezzoMensile,isCancellata);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Categoria> getCategorie() {
		List<Categoria> categorie = new ArrayList<Categoria>();
		String query = "select * from categoria";
		
		try(Connection c = getConnection();
				Statement s = c.createStatement()){
			
			ResultSet result = s.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String nome = result.getString("nome");
				double prezzoGiornaliero = result.getDouble("prezzo_giornaliero");
				double prezzoSettimanale = result.getDouble("prezzo_settimanale");
				double prezzoMensile = result.getDouble("prezzo_mensile");
				boolean isCancellata = result.getInt("isCancellata")==1;
				
				categorie.add(new Categoria(id,nome,prezzoGiornaliero,prezzoSettimanale,prezzoMensile,isCancellata));
				
				
				
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return categorie;
	}

	@Override
	public boolean addCategoria(Categoria cat) {
	
		String query="insert into categoria(nome,prezzo_giornaliero,prezzo_settimanale,prezzo_mensile,isCancellata) values(?,?,?,?,?)";
		
		try(Connection c = getConnection();
				PreparedStatement p = c.prepareStatement(query)){
			p.setString(1, cat.getNome());
			p.setDouble(2,cat.getPrezzoGiornaliero());
			p.setDouble(3,cat.getPrezzoSettimanale());
			p.setDouble(4, cat.getPrezzoMensile());
			p.setInt(5,0);
			
			int res = p.executeUpdate();
			
			return res>0;
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
		
	}


	@Override
	public void saveCategorie() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void loadCategorie() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Categoria getGategoria(String nome) {
	String query = "select * from categoria where nome=?";
		
		try(Connection c = getConnection();
				PreparedStatement s = c.prepareStatement(query)){
			
			s.setString(1, nome);
			ResultSet result = s.executeQuery();
			if(result.next()) {
				
				int id = result.getInt("id");
				nome = result.getString("nome");
				double prezzoGiornaliero = result.getDouble("prezzo_giornaliero");
				double prezzoSettimanale = result.getDouble("prezzo_settimanale");
				double prezzoMensile = result.getDouble("prezzo_mensile");
				boolean isCancellata = result.getInt("isCancellata")==1;
				
				return new Categoria(id,nome,prezzoGiornaliero,prezzoSettimanale,prezzoMensile,isCancellata);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	

}
