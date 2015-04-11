package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.ilpider.labfx.model.Giocatore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	private Button btnPreso01;
	@FXML
	private Button btnTogli01;
	@FXML
	private CheckBox chk01a;
	@FXML
	private CheckBox chk01b;
	@FXML
	private CheckBox chk01c;
    @FXML
    private Label lblPuntiCaricati;

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
//					System.out.println("TextField Text Changed (newValue: " + newValue + ") ...e oldValue: " + oldValue);
					giocatoreModel.setNomeGiocatore(newValue);
				});
	}

	@FXML
	void doBtnPreso(ActionEvent event) {
		if (!chk01a.isSelected()) {
			chk01a.setSelected(true);
		} else if (!chk01b.isSelected()) {
			chk01b.setSelected(true);
		} else if (!chk01c.isSelected()) {
			chk01c.setSelected(true);
		} else {
			System.out.println("chiuso");
		}
	}

	@FXML
	void doBtnTogli(ActionEvent event) {
		if (chk01c.isSelected()) {
			chk01c.setSelected(false);
		} else if (chk01b.isSelected()) {
			chk01b.setSelected(false);
		} else if (chk01a.isSelected()) {
			chk01a.setSelected(false);
		} else {
			System.out.println("mai preso fisso");
		}
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
}
