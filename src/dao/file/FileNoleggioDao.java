package dao.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.DaoFactory;
import dao.interfaceDao.*;
import model.Automobile;
import model.Noleggio;
import model.Utente;

public class FileNoleggioDao implements NoleggioDao {

	List<Noleggio> noleggi;
	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";

	private FileNoleggioDao() {

		loadNoleggi();
	}

	private static FileNoleggioDao instance = new FileNoleggioDao();

	public static FileNoleggioDao getInstance() {
		return instance;
	}

	@Override
	public List<Noleggio> getPrenotazioni() {

		return this.noleggi;
	}

	

	@Override
	public List<Noleggio> getPrenotazioniVecchie() {
		List<Noleggio> lista = this.noleggi.stream()
				.filter(noleggio -> noleggio.getDataFine().before(Date.valueOf(LocalDate.now())))
				.collect(Collectors.toCollection(ArrayList::new));

		return lista;
	}

	@Override
	public List<Noleggio> getPrenotazioniInCorso() {
		List<Noleggio> lista = this.noleggi.stream().filter(noleggio -> noleggio.getDataFine().after(Date.valueOf(LocalDate.now())))
				.collect(Collectors.toCollection(ArrayList::new));

		return lista;
	}

	@Override
	public void deletePrenotazioniAuto(int idAuto) {
		for (int i = 0; i < this.noleggi.size(); i++) {

			if ((this.noleggi.get(i).getDataFine().equals(Date.valueOf(LocalDate.now())))
					|| (this.noleggi.get(i).getDataFine().after(Date.valueOf(LocalDate.now())))
					&& (this.noleggi.get(i).getAutomobile().getPERSONAL_ID() == idAuto)) {

				this.deletePrenotazione(this.noleggi.get(i).getPERSONAL_ID());

			}

		}

	}

	@Override
	public void deletePrenotazione(int id) {
		boolean flag1 = true;
		boolean flag2 = true;

		for (int i = 0; i < this.noleggi.size() && flag1; i++) {

			if (this.noleggi.get(i).getPERSONAL_ID() == id) {

				for (int j = 0; j < FileAutoDao.getInstance().getAutomobili().size() && flag2; j++) {

					if (FileAutoDao.getInstance().getAutomobili().get(j).getPERSONAL_ID() == this.noleggi.get(i)
							.getAutomobile().getPERSONAL_ID()) {
						// Auto di nuovo Disponibile
						FileAutoDao.getInstance().getAutomobili().get(j).setCancellata(false);
						FileAutoDao.getInstance().saveAutomobili();
						// Termina oggi il noelggio
						this.noleggi.get(i).setDataFine(Date.valueOf(LocalDate.now().minusDays(1)));
						this.saveNoleggi();
						flag1 = false;
						flag2 = false;

					}
				}
			}
		}

	}

	@Override
	public boolean addPrenotazione(Noleggio p) {
		if (this.checkPrenotazione(p)) {

			this.noleggi.add(p);
			this.saveNoleggi();
			return true;
		} else
			return false;

	}

	@Override
	public boolean addPrenotazione(Utente utente, Automobile automobile, Date dataInizio, Date dataFine) {
		Noleggio p = new Noleggio(utente, automobile, dataInizio, dataFine);

		if (this.checkPrenotazione(p)) {

			// Rimuovo auto dalle disponibili
			FileAutoDao.getInstance().deleteAutomobile(automobile.getPERSONAL_ID());

			this.noleggi.add(p);

			this.saveNoleggi();

			return true;

		}

		return false;
	}

	@Override
	public void saveNoleggi() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Noleggi"))) {

			oos.writeObject(this.noleggi);
		} catch (IOException e) {

		}

	}

	@Override
	public void loadNoleggi() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "Noleggi"))) {

			this.noleggi = (List<Noleggio>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			this.noleggi = new ArrayList<Noleggio>();
		}

	}

	public boolean haPrenotazioniInCorso(int idAuto) {
		// Devo capire se l'auto ha prenotazioni in corso prima di eliminarla
		Automobile auto = FileAutoDao.getInstance().getAuto(idAuto);

		if (auto == null)
			return false;

		for (Noleggio l : this.getPrenotazioniInCorso()) {

			if (l.getAutomobile().equals(auto))
				return true;
		}

		return false;

	}

	@Override
	public boolean checkPrenotazione(Noleggio n) {
		for (Noleggio noleggio : this.getPrenotazioniInCorso()) {

			if (noleggio.getAutomobile().getPERSONAL_ID() == n.getAutomobile().getPERSONAL_ID()) {
				// Verifico che l'inzio della mia data non sia compresa in un noleggio in corso
				if ((n.getDataInizio().after(noleggio.getDataInizio())
						|| n.getDataInizio().equals(noleggio.getDataInizio()))
						&& (n.getDataInizio().before(noleggio.getDataFine())
								|| n.getDataInizio().equals(noleggio.getDataFine()))
						||

						(n.getDataFine().after(noleggio.getDataInizio())
								|| n.getDataFine().equals(noleggio.getDataInizio()))
								&& (n.getDataFine().before(noleggio.getDataFine())
										|| n.getDataFine().equals(noleggio.getDataFine()))) {

					return false;

				}

			}

		}

		return true;
	}

	@Override
	public List<Noleggio> getPrenotazioniUtente(int utente) {
		List<Noleggio> noleggi = DaoFactory.getDaoFactory().getNoleggioDao().getPrenotazioni()
				.stream().filter(nol -> nol.getUtente().getPERSONAL_ID()== utente)
				.collect(Collectors.toCollection(ArrayList::new));
		
		return noleggi;
	}

}
