package utente;

import java.sql.Connection;

import database.UtenteDAOImpl;
import controlloInput.Validazione;

public class Utente {
	
	private String username;
	private String password;
	private UtenteDAOImpl ut;
	
	public Utente(String user, String pwd) throws NullPointerException {
		if(user == null && pwd == null) throw new NullPointerException("Nome utente e password non validi");
		
		if(!Validazione.isValido(user) && !Validazione.isValido(pwd)) {
			System.out.println("Username o password non validi");	
		}
		
		ut = new UtenteDAOImpl();
		username = user;
		password = pwd;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean accedi() {
		Connection con = ut.connessione();
		String passwordDB = ut.queryPassword(con, username);
		ut.chiudiConnessione(con);
		
		if(passwordDB == null) {
			return false; 
		} else if(passwordDB.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Utente setUtente() {
		//Attivazione del pulsante dalla finestra di login
		//Controllo dei parametri passati in input
		//Chiamata del metodo per inserire nel datbase
		
		return null;
	}
}
