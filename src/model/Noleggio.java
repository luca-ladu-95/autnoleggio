package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.sql.Date;

public class Noleggio implements Serializable {

	private final String path = "C:/Users/luca/eclipse-workspace/autonoleggio/src/dati";
	/**
	 * 
	 */
	private static final long serialVersionUID = 7147873637053115504L;

	private static int ID;
	private final int PERSONAL_ID;
	private Utente utente;
	private Automobile automobile;
	private Date dataInizio;
	private Date dataFine;

	public Noleggio(Utente utente, Automobile automobile, Date dataInizio, Date dataFine) {
		super();
		this.utente = utente;
		this.automobile = automobile;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.loadIdFromFile();
		ID++;
		this.PERSONAL_ID = ID;
		this.saveIdToFile();

	}
	
	
	public Noleggio(int id,Utente utente, Automobile automobile, Date dataInizio, Date dataFine) {
		super();
		this.utente = utente;
		this.automobile = automobile;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.PERSONAL_ID = id;

	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Automobile getAutomobile() {
		return automobile;
	}

	public void setAutomobile(Automobile automobile) {
		this.automobile = automobile;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public int getPERSONAL_ID() {
		return PERSONAL_ID;
	}

	@Override
	public String toString() {
		return "\nNoleggio [utente=" + utente + ", automobile=" + automobile + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + "]";
	}

	private void saveIdToFile() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "IdNoleggio"))) {

			oos.writeObject(ID);
		} catch (IOException e) {

		}

	}

	private void loadIdFromFile() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "IdNoleggio"))) {

			ID = (int) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {

			ID = 0;
		}

	}
	
	public double calcolaPrezzoNoleggio() {
		
		int giorni =(int) ChronoUnit.DAYS.between(utilita.DataConversion.convertToLocalDateViaSqlDate(dataInizio), utilita.DataConversion.convertToLocalDateViaSqlDate(dataFine));
		double prezzoGG = this.automobile.getCategoria().getPrezzoGiornaliero();
		double prezzoSS = this.automobile.getCategoria().getPrezzoSettimanale();
		double prezzoMM = this.automobile.getCategoria().getPrezzoMensile();
		
		int mesi=giorni/30;
		giorni=giorni%30;
		int settimane=giorni/7;
		giorni=giorni%7;
		
		
		return (mesi*prezzoMM)+(settimane*prezzoSS)+(giorni*prezzoGG);
		
//		if(giorni  < 7 )
//			return giorni*prezzoGG;
//		else if( giorni >= 7 && giorni < 30) {
//			
//
//			int settimane = giorni/7;
//			int giorniRestanti = giorni%7;
//			double sommaSettimanale = settimane*prezzoSS;
//			double sommaGiornaliera = giorniRestanti*prezzoGG;
//			
//			return sommaSettimanale+sommaGiornaliera;
//			
//			
//			
//		}else {
//			
//			int mesi = giorni/30;
//			int giorniRestanti = giorni-(30*mesi);
//			
//			if(giorniRestanti < 7) {
//				
//				double sommaMensile = mesi*prezzoMM;
//				double sommaGiornaliera = giorniRestanti*prezzoGG;
//				return sommaMensile+sommaGiornaliera;
//			}else {
//				
//				int settimane = giorniRestanti/7;
//				int gg = giorniRestanti%7;
//				double sommaMensile = mesi*prezzoMM;
//				double sommaSettimanale = settimane*prezzoSS;
//				double sommaGiornaliera = gg*prezzoGG;
//				
//				return sommaSettimanale+sommaGiornaliera+sommaMensile;
//				
//				
//			}
//			
//			
//			
//		} 
			
	
	}

}
