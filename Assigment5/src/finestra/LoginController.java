package finestra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utente.Utente;
import javafx.scene.control.Button;

public class LoginController {
	
	private String inputUser;
	private String inputPwd;

	@FXML private Label lblMessage;
	@FXML private Button btnAccedi;
	@FXML private TextField txtUser;
	@FXML private PasswordField txtPwd;
	
	@FXML
	void handleUser(ActionEvent event) {
		inputUser = txtUser.getText();
	}
	
	@FXML
	void handlePwd(ActionEvent event) {
		inputPwd = txtPwd.getText();
	}
	
	@FXML
	void handleAccedi(ActionEvent event) {
		
		Utente u = new Utente(inputUser, inputPwd);
		
		if(u.accedi()) {
			lblMessage.setText("Benevento/a " + u.getUsername() + "!");
		} else {
			lblMessage.setText("Username o password errati");
		}
	}
}