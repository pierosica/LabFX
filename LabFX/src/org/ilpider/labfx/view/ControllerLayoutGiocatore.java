package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;
import org.ilpider.labfx.model.Giocatore;
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

	private Giocatore giocatoreModel;

	@FXML
	void initialize() {
		assert txtNomeGiocatore != null : "fx:id=\"txtNomeGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert txtPuntiGiocatore != null : "fx:id=\"txtPuntiGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";

		/*
		 * invocata quando premo ENTER nella txtNomeGicatore
		 */
		txtNomeGiocatore.setOnAction((event) -> {
			System.out.println("TextField Action");
		});

		/*
		 * quando cambia il testo nella TextField cambio il nome al Giocatore
		 */
		txtNomeGiocatore.textProperty().addListener( //invocata quando cambia il testo della txtNomeGiocatore
				(observable, oldValue, newValue) -> {
					System.out.println("TextField Text Changed (newValue: " + newValue + ") ...e oldValue: " + oldValue);
					giocatoreModel.setNomeGiocatore(newValue);
				});
	}

	public void setGiocatoreModel(Giocatore giocatoreModel) {
		this.giocatoreModel = giocatoreModel;
	}



	public void setTxTPunti(String string) {
		txtPuntiGiocatore.setText(string);
	}

//	public void setPuntiGiocatore(int punti) {
//		/*
//		 * TODO vedere sta cosa del dover usare una stringa. mi serve usare un
//		 * numero pre fare le somme!
//		 */
//		txtPuntiGiocatore.setText("" + this.giocatoreModel.getPuntiGiocatore());
//	}
}
