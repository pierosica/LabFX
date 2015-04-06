package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;
import org.ilpider.labfx.model.Giocatore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerLayoutGiocatore {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtNomeGiocatore;
	@FXML
	private TextField txtPuntiGiocatore;

	// private String nome;
	private Giocatore giocatoreModel;

	@FXML
	void initialize() {
		assert txtNomeGiocatore != null : "fx:id=\"txtNomeGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert txtPuntiGiocatore != null : "fx:id=\"txtPuntiGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";

		txtNomeGiocatore.setOnAction((event) -> { // invocata quando premo ENTER
													// nella txtNomeGicatore
					System.out.println("TextField Action");
				});

		txtNomeGiocatore.textProperty().addListener( //invocata quando cambia il testo della txtNomeGiocatore
				(observable, oldValue, newValue) -> {
					System.out.println("TextField Text Changed (newValue: " + newValue + ") ...e oldValue: " + oldValue);
					giocatoreModel.setNomeGiocatore(newValue);
				});
		
		txtPuntiGiocatore.setText("");
	}

	@FXML
	void leggiNomeGiocatore(ActionEvent event) {
		// giocatoreModel.setNomeGiocatore(txtNomeGiocatore.getText());

		System.out.println("letto");
	}

	public Giocatore getGiocatoreModel() {
		return giocatoreModel;
	}

	public void setGiocatoreModel(Giocatore giocatoreModel) {
		this.giocatoreModel = giocatoreModel;
	}

	public void setPuntiGiocatore(int punti) {
		/*
		 * TODO vedere sta cosa del dover usare una stringa. mi serve usare un
		 * numero pre fare le somme!
		 */
		txtPuntiGiocatore.setText("" + punti);
		this.giocatoreModel.setPuntiGiocatore(0);
	}

	public String leggiNomeGiocatore() {
		return txtNomeGiocatore.getText();
	}

	public void setNomeGiocatore(String nome) {
		txtNomeGiocatore.setText(nome);
	}
}
