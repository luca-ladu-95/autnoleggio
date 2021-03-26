package dao.daojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.interfaceDao.UtenteDao;
import model.Categoria;
import model.Utente;
import static dao.daojdbc.JdbcDaoFactory.*;

public class JdbcUtenteDao implements UtenteDao {

	private JdbcUtenteDao() {
	}

	private static JdbcUtenteDao instance = new JdbcUtenteDao();

	public static JdbcUtenteDao getInstance() {
		return instance;
	}

	@Override
	public boolean addUtente(Utente u) {

		String query = "insert into utente(nome,cognome,username,password,dataDiNascita,isCancellato) values(?,?,?,?,?,?)";

		byte[] s = Base64.getEncoder().encode(u.getPassword().getBytes());
		String k = new String(s);

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, u.getNome());
			p.setString(2, u.getCognome());
			p.setString(3, u.getUsername());
			p.setString(4, k);
			p.setDate(5, u.getDataDiNascita());
			p.setBoolean(6, u.isCancellato());

			int res = p.executeUpdate();

			return res > 0;

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public Utente getUtente(int id) {

		String query = "select * from utente where id=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setInt(1, id);

			ResultSet res = p.executeQuery();

			if (res.next()) {

				id = res.getInt("id");
				String nome = res.getString("nome");
				String cognome = res.getString("cognome");
				String username = res.getString("username");
				String password = res.getString("password");
				Date dataNascita = res.getDate("dataDiNascita");
				boolean isCancellato = res.getInt("isCancellato") == 1;

				return new Utente(id, nome, cognome, username, password, dataNascita, isCancellato);

			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Utente isRegistrato(String username, String password) {

		String query = "select * from utente where username=? and password=?";

		byte[] s = Base64.getEncoder().encode(password.getBytes());
		String k = new String(s);

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setString(1, username);
			p.setString(2, k);

			ResultSet res = p.executeQuery();

			if (res.next()) {

				int id = res.getInt("id");
				String nome = res.getString("nome");
				String cognome = res.getString("cognome");
				username = res.getString("username");
				password = res.getString("password");
				Date dataNascita = res.getDate("dataDiNascita");
				boolean isCancellato = res.getInt("isCancellato") == 1;

				return new Utente(id, nome, cognome, username, password, dataNascita, isCancellato);

			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Utente> getUtenti() {
		List<Utente> utenti = new ArrayList<Utente>();
		String query = "select * from utente";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet res = s.executeQuery(query);

			while (res.next()) {

				int id = res.getInt("id");
				String nome = res.getString("nome");
				String cognome = res.getString("cognome");
				String username = res.getString("username");
				String password = res.getString("password");
				Date dataNascita = res.getDate("dataDiNascita");
				boolean isCancellato = res.getInt("isCancellato") == 1;

				utenti.add(new Utente(id, nome, cognome, username, password, dataNascita, isCancellato));

			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {

			return utenti;
		}

	}

	@Override
	public void saveUtenti() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadUtenti() {
		// TODO Auto-generated method stub

	}

}
