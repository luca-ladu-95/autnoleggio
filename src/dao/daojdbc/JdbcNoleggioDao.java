package dao.daojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import dao.DaoFactory;
import dao.interfaceDao.NoleggioDao;
import model.Automobile;
import model.Noleggio;
import model.Utente;
import static dao.daojdbc.JdbcDaoFactory.*;

public class JdbcNoleggioDao implements NoleggioDao {

	private JdbcNoleggioDao() {
	}

	private static JdbcNoleggioDao instance = new JdbcNoleggioDao();

	public static JdbcNoleggioDao getInstance() {
		return instance;
	}

	@Override
	public List<Noleggio> getPrenotazioni() {
		List<Noleggio> noleggi = new ArrayList<Noleggio>();
		String query = "select * from noleggio";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet res = s.executeQuery(query);

			while (res.next()) {

				int id = res.getInt("id");
				Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(id);
				Utente utente = DaoFactory.getDaoFactory().getUtenteDao().getUtente(id);
				Date dataInizio = res.getDate("dataInizio");
				Date dataFine = res.getDate("dataFine");

				noleggi.add(new Noleggio(id, utente, auto, dataInizio, dataFine));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return noleggi;

	}

	@Override
	public boolean haPrenotazioniInCorso(int idAuto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Noleggio> getPrenotazioniVecchie() {

		List<Noleggio> prenotazioni = new ArrayList<Noleggio>();
		String query = "select * from noleggio where dataFine<curdate()";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet res = s.executeQuery(query);

			while (res.next()) {

				int id = res.getInt("id");
				Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(id);
				Utente utente = DaoFactory.getDaoFactory().getUtenteDao().getUtente(id);
				Date dataInizio = res.getDate("dataInizio");
				Date dataFine = res.getDate("dateFine");

				prenotazioni.add(new Noleggio(id, utente, auto, dataInizio, dataFine));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prenotazioni;

	}

	@Override
	public List<Noleggio> getPrenotazioniInCorso() {
		List<Noleggio> prenotazioni = new ArrayList<Noleggio>();
		String query = "select * from noleggio where dataFine>curdate()";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet res = s.executeQuery(query);

			while (res.next()) {

				int id = res.getInt("id");
				Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(id);
				Utente utente = DaoFactory.getDaoFactory().getUtenteDao().getUtente(id);
				Date dataInizio = res.getDate("dataInizio");
				Date dataFine = res.getDate("dateFine");

				prenotazioni.add(new Noleggio(id, utente, auto, dataInizio, dataFine));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prenotazioni;
	}

	@Override
	public void deletePrenotazioniAuto(int idAuto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePrenotazione(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addPrenotazione(Noleggio p) {

		return this.addPrenotazione(p.getUtente(), p.getAutomobile(), p.getDataInizio(), p.getDataFine());
	}

	@Override
	public boolean addPrenotazione(Utente utente, Automobile automobile, Date dataInizio, Date dataFine) {

		String query = "insert into noleggio(id_auto,id_utente,dataInizio,dataFine) values(?,?,?,?)";

		Noleggio n = new Noleggio(utente, automobile, dataInizio, dataFine);

		if (checkPrenotazione(n)) {

			try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

				p.setInt(1, automobile.getPERSONAL_ID());
				p.setInt(2, utente.getPERSONAL_ID());
				p.setDate(3, dataInizio);
				p.setDate(4, dataFine);

				int res = p.executeUpdate();

				return res > 0;

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;

	}

	@Override
	public void saveNoleggi() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadNoleggi() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPrenotazione(Noleggio n) {

		int counter = 0;
		String query = "select * from noleggio where id_auto="+n.getAutomobile().getPERSONAL_ID()
				+" and "+"((dataInizio BETWEEN '" + n.getDataInizio() + "' and '"
				+ n.getDataFine() + "') or (dataFine BETWEEN '" + n.getDataInizio() + "' and '" + n.getDataFine()
				+ "'))";

		try (Connection c = getConnection(); Statement s = c.createStatement()) {

			ResultSet res = s.executeQuery(query);
			
			while(res.next() && counter < 1){
				
				counter++;
				
			}

			return counter==0;

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return false;

	}

	@Override
	public List<Noleggio> getPrenotazioniUtente(int id_utente) {

		List<Noleggio> noleggi = new ArrayList<Noleggio>();
		String query = "select * from noleggio where id_utente=?";

		try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(query)) {

			p.setInt(1, id_utente);

			ResultSet res = p.executeQuery();

			while (res.next()) {

				int id = res.getInt("id");
				Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(id);
				Utente utente = DaoFactory.getDaoFactory().getUtenteDao().getUtente(id);
				Date dataInizio = res.getDate("dataInizio");
				Date dataFine = res.getDate("dataFine");

				noleggi.add(new Noleggio(id, utente, auto, dataInizio, dataFine));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noleggi;

	}

}
