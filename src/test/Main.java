package test;

import model.*;
import utilita.DataConversion;
import utilita.TargaGenerator;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

//		Utente luca = new Utente("Luca", "Ladu", "l.ladu3", "1234", Date.valueOf("1995-03-14"));
//		// String nome, double prezzoGiornaliero, double prezzoSettimanale, double
//		// prezzoMensile
//		Categoria utilitaria = new Categoria("Utilitaria", 50.0, 300.0, 1000.0);
//	    Categoria sportiva = new Categoria("Sportiva", 100, 600, 2100);
//		Categoria luxury = new Categoria("Luxury", 200, 800, 5000);

//		// String marca, String modello, String targa, Categoria categoria
//		Automobile a1 = new Automobile("Bentley", "Continental", TargaGenerator.getSaltString(), luxury, "BLU");
//		Automobile a2 = new Automobile("Reneault", "Clio", TargaGenerator.getSaltString(), utilitaria, "NERO");
//		Automobile a3 = new Automobile("Ferrari", "California", TargaGenerator.getSaltString(), sportiva, "ROSSO");
//
//		// Utente utente, Automobile automobile, LocalDate dataInizio, LocalDate
//		// dataFine
//		// Noleggio passato di 5 giorni
//		Noleggio n1 = new Noleggio(luca, a1, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(4)));
//		Noleggio n2 = new Noleggio(luca, a2, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusMonths(1)));
//		Noleggio n3 = new Noleggio(luca, a3,Date.valueOf(LocalDate.now().minusMonths(4)),Date.valueOf(LocalDate.now().minusMonths(3)));
//		Noleggio n4 = new Noleggio(luca, a1,Date.valueOf(LocalDate.now().minusMonths(6)), Date.valueOf(LocalDate.now().minusMonths(5)));
//		
		
//		Noleggio sovrapposto = new Noleggio(luca, a1, Date.valueOf(LocalDate.now().minusDays(9)), Date.valueOf(LocalDate.now()));
//
//		
//		System.out.println(n1.calcolaPrezzoNoleggio());
		
		
		
//		DataBase.getInstance().addUtente(luca);
//
//		DataBase.getInstance().addCategoria(luxury);
//		DataBase.getInstance().addCategoria(sportiva);
//		DataBase.getInstance().addCategoria(utilitaria);
//
//		DataBase.getInstance().addAutomobile(a1);
//		DataBase.getInstance().addAutomobile(a2);
//		DataBase.getInstance().addAutomobile(a3);
//
//		DataBase.getInstance().addPrenotazione(n1);
//		DataBase.getInstance().addPrenotazione(n2);
//		DataBase.getInstance().addPrenotazione(n3);
//		DataBase.getInstance().addPrenotazione(n4);
//		DataBase.getInstance().addPrenotazione(sovrapposto);

		// Deve stampare 3 prenotazioni
		// System.out.println("Prenotazioni vecchie:");
		// System.out.println(DataBase.getInstance().getPrenotazioniVecchie());
		// Deve stampare 1 prenotazione
		// System.out.println("Prenotazioni in corso");
		// System.out.println(DataBase.getInstance().getPrenotazioniInCorso());

//		System.out.println("Lista Auto disponibili");
//		System.out.println(DataBase.getInstance().getAutomobili());
//
//		// Effettuo una prenotazione
//
//		DataBase.getInstance().addPrenotazione(luca, a3, LocalDate.now(), LocalDate.now().plusDays(6));
//
//		// Dovrebbe aver tolot la ferrrari dalle disponibili
//
//		System.out.println("Lista Auto disponibili dopo prenotazione");
//		System.out.println(DataBase.getInstance().getAutomobili());
//
//		// Elimino la prenotazione simulando il tempo
//
//		DataBase.getInstance().deletePrenotazioniAuto(a3.getPERSONAL_ID());
//
//		System.out.println("Lista Auto disponibili dopo disdetta");
//		System.out.println(DataBase.getInstance().getAutomobili());
//
//		
//		 System.out.println("Prenotazioni vecchie:");
//		 System.out.println(DataBase.getInstance().getPrenotazioniVecchie());
		
		

	}

}
