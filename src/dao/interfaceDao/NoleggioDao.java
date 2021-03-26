package dao.interfaceDao;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;
import model.Automobile;
import model.Noleggio;
import model.Utente;

public interface NoleggioDao {

	List<Noleggio> getPrenotazioni();
	 boolean haPrenotazioniInCorso(int idAuto);
	 List<Noleggio> getPrenotazioniVecchie();
	 List<Noleggio> getPrenotazioniInCorso();
	 void deletePrenotazioniAuto(int idAuto);
	 void deletePrenotazione(int id);
	 boolean addPrenotazione(Noleggio p);
	 boolean addPrenotazione(Utente utente, Automobile automobile, Date dataInizio,Date dataFine);
	 void saveNoleggi();
	 void loadNoleggi();
	 boolean checkPrenotazione(Noleggio n);
	 List<Noleggio> getPrenotazioniUtente(int utente);
}
