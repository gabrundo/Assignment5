package controlloInput;

public class Validazione {
	
	public static boolean isValido(String s) {
		
		if(s == null) {
			return false;
		}
		
		for(char c : s.toCharArray()) {
			if(!Character.isAlphabetic(c) && !Character.isDigit(c)) {
				return false;
			}
		}
		
		return true;
	}
}
