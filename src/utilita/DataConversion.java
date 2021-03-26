package utilita;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

public class DataConversion {
	
	public static LocalDate conversione(String data) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		 LocalDate localDate = LocalDate.parse(data, formatter);
		 
		 return localDate;
		
	}
	
	
	
	public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return dateToConvert.toLocalDate();
	}
	
	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
	    return Date.valueOf(dateToConvert);
	}
	

}
