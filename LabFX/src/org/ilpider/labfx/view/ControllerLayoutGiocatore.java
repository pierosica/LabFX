package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.ilpider.labfx.model.Giocatore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML
	private Label lblPuntiFinali;
	@FXML
	private Label lblPuntiCaricati;
	@FXML
	private Button btnPiu1;
	@FXML
	private Button btnPiu10;
	@FXML
	private Button btnMeno1;
	@FXML
	private Button btnMeno10;
	@FXML
	private Button btnCaricatiPiu10;
	@FXML
	private Button btnCaricatiMeno10;

	private Giocatore giocatoreModel;

	@FXML
	void initialize() {
		assert lblPuntiCaricati != null : "fx:id=\"lblPuntiCaricati\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert txtNomeGiocatore != null : "fx:id=\"txtNomeGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert txtPuntiGiocatore != null : "fx:id=\"txtPuntiGiocatore\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert btnPiu1 != null : "fx:id=\"btnPiu1\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert btnPiu10 != null : "fx:id=\"btnPiu10\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert btnMeno1 != null : "fx:id=\"btnMeno1\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";
		assert btnMeno10 != null : "fx:id=\"btnMeno10\" was not injected: check your FXML file 'LayoutGiocatore.fxml'.";

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
					giocatoreModel.setNomeGiocatore(newValue);
				});
	}

	@FXML
	public void doBtnPiuMeno(ActionEvent event) {
		Button source = (Button) event.getSource();
//		System.out.println(source.getClass().isInstance(btnMeno1));
		int val = Integer.parseInt(source.getText());
		try {
			giocatoreModel.setPuntiGiocatore(giocatoreModel.getPuntiGiocatore()
					+ val);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("giocatore: " + giocatoreModel.getPuntiGiocatore() + " - " + event.getSource().getClass());
	}

	@FXML
	public void doBtnCaricatiPiuMeno(ActionEvent event) {
		Button source = (Button) event.getSource();
//		System.out.println(source.getClass().isInstance(btnMeno1));
		int val = Integer.parseInt(source.getText());
		try {
			giocatoreModel.setPuntiCaricati(giocatoreModel.getPuntiCaricati()
					+ val);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("giocatore: " + giocatoreModel.getPuntiGiocatore() + " - " + event.getSource().getClass());
	}

	public void setGiocatoreModel(Giocatore giocatoreModel) {
		this.giocatoreModel = giocatoreModel;
	}

	public void setTxtPunti(String string) {
		txtPuntiGiocatore.setText(string);
	}

	public void setTxtNome(String nomeGiocatore) {
		txtNomeGiocatore.setText(nomeGiocatore);
	}

	public void setLblPuntiCaricati(int punti) {
		lblPuntiCaricati.setText("" + punti);
	}

	public void setLblPuntiFinali(int punti) {
		lblPuntiFinali.setText("avevi: " + punti);
	}
}
