package utilita;

public class VerificaStringe {

	
	public static boolean areNotNull(String ...args) {
		
		for(String a :args) {
			
			if(a==null)
				return false;
		}
		
		return true;
		
	}
	
}
