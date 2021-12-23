package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAOImpl implements UtenteDAO {

	@Override
	public Connection connessione() {
		Connection con = null;	
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:/home/gabriele/sqlite/db/credenziali");
		} catch (SQLException ex) {
			System.out.println("Connessione al database non riuscita!");
		}
		
		return con;
	}

	@Override
	public void chiudiConnessione(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Chiusura del database non riuscita");
			e.printStackTrace();
		}
	}

	@Override
	public String queryPassword(Connection con, String user) {
		String query = "select password as pwd from utenti where username = ?";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, user);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return cifratura.AES.decrypt(resultSet.getString("pwd"), "chiaveCifratura"); 
			} else {	
				return "";
			}
				
		} catch (SQLException e) {
			System.out.println("Comportamento anomalo");
			e.printStackTrace();
		}
		
		return "";
	}

	@Override
	public void inserisciUtente(Connection con, String usr, String pwd) {
		String query = "insert into utenti (username, password) values (?, ?)";
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, usr);
			preparedStatement.setString(2, cifratura.AES.encrypt(pwd, "chiaveCifratura"));
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("Comportamento anomalo");
			e.printStackTrace();
		}
	}
}
