package database;

import java.sql.Connection;

public interface UtenteDAO {

	public Connection connessione();
	
	public void chiudiConnessione(Connection con);

	public String queryPassword(Connection con, String username);
	
	public void inserisciUtente(Connection con, String usr, String pwd);
	
}
