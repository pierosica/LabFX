package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControllerDialogNuovaPartita {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private RadioButton rdb2;
	@FXML
	private RadioButton rdb3;
	@FXML
	private RadioButton rdb4;
	@FXML
	private ToggleGroup grpRdbNumeroGiocatori;
	@FXML
	private TextField txtNomeGiocatore1;
	@FXML
	private TextField txtNomeGiocatore2;
	@FXML
	private TextField txtNomeGiocatore3;
	@FXML
	private TextField txtNomeGiocatore4;
	@FXML
	private Button idOK;
	@FXML
	private Button idAnnulla;

	private int numeroGiocatori;
	private List<TextField> listaTxt;

	@FXML
	void doOK(ActionEvent event) {
		System.out.println(listaTxt);
		listaTxt.forEach(nome-> System.out.println(nome.getText()));
	}

	@FXML
	void doAnnulla(ActionEvent event) {
		Stage stage = (Stage) idAnnulla.getScene().getWindow();
		stage.close();
	}

	@FXML
	void doActionTxtNome(ActionEvent event) {
	}

	@FXML
	void doBtnNumero(ActionEvent event) {
//		event.getSource().
	}

	@FXML
	void initialize() {
		assert rdb2 != null : "fx:id=\"rdb2\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert rdb3 != null : "fx:id=\"rdb3\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert rdb4 != null : "fx:id=\"rdb4\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert grpRdbNumeroGiocatori != null : "fx:id=\"grpRdbNumeroGiocatori\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert txtNomeGiocatore1 != null : "fx:id=\"txtNomeGiocatore1\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert txtNomeGiocatore2 != null : "fx:id=\"txtNomeGiocatore2\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert txtNomeGiocatore3 != null : "fx:id=\"txtNomeGiocatore3\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert txtNomeGiocatore4 != null : "fx:id=\"txtNomeGiocatore4\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert idOK != null : "fx:id=\"idOK\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";
		assert idAnnulla != null : "fx:id=\"idAnnulla\" was not injected: check your FXML file 'DialogNuovaPartita.fxml'.";

		rdb2.setUserData(2);
		rdb3.setUserData(3);
		rdb4.setUserData(4);

		txtNomeGiocatore1.setUserData(0);
		txtNomeGiocatore2.setUserData(1);
		txtNomeGiocatore3.setUserData(2);
		txtNomeGiocatore4.setUserData(3);

		txtNomeGiocatore3.setDisable(true);
		txtNomeGiocatore4.setDisable(true);

		listaTxt = new ArrayList<TextField>();
		
		grpRdbNumeroGiocatori.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> ov, Toggle old_toggle,
						Toggle new_toggle) -> {
					if (grpRdbNumeroGiocatori.getSelectedToggle() != null) {
						System.out.println("Ho selezionato il Toggle con userData: " + new_toggle.getUserData());
						if (new_toggle.getUserData().equals(2)) {
							txtNomeGiocatore1.setDisable(false);
							txtNomeGiocatore2.setDisable(false);
							txtNomeGiocatore3.setDisable(true);
							txtNomeGiocatore4.setDisable(true);
							txtNomeGiocatore3.setText(null);
							txtNomeGiocatore4.setText(null);

							listaTxt.removeAll(listaTxt);
							listaTxt.add(txtNomeGiocatore1);
							listaTxt.add(txtNomeGiocatore2);
						}
						if (new_toggle.getUserData().equals(3)) {
							txtNomeGiocatore1.setDisable(false);
							txtNomeGiocatore2.setDisable(false);
							txtNomeGiocatore3.setDisable(false);
							txtNomeGiocatore4.setDisable(true);
							txtNomeGiocatore4.setText(null);

							listaTxt.removeAll(listaTxt);
							listaTxt.add(txtNomeGiocatore1);
							listaTxt.add(txtNomeGiocatore2);
							listaTxt.add(txtNomeGiocatore3);
						}
						if (new_toggle.getUserData().equals(4)) {
							txtNomeGiocatore1.setDisable(false);
							txtNomeGiocatore2.setDisable(false);
							txtNomeGiocatore3.setDisable(false);
							txtNomeGiocatore4.setDisable(false);
						
							listaTxt.removeAll(listaTxt);
							listaTxt.add(txtNomeGiocatore1);
							listaTxt.add(txtNomeGiocatore2);
							listaTxt.add(txtNomeGiocatore3);
							listaTxt.add(txtNomeGiocatore4);
						}
					}
				});

		leggiNumeroGiocatori();
	}

		/*
		 * qui ci starebbe una gestione piu pulita
		 * di quello che faccio con la listaTxt in initialize()
		 */
//	private void sbloccaCelle() {
//		
//	}

	public String leggiNomeGiocatore(int id) {
		String nomeGiocatore = txtNomeGiocatore1.getText();
		return nomeGiocatore;
	}
	
	/*
	 * Getters e Setters
	 */
	public int leggiNumeroGiocatori() {
		Toggle selectedToggle = grpRdbNumeroGiocatori.getSelectedToggle();
		numeroGiocatori = (int) selectedToggle.getUserData();
		return numeroGiocatori;
	}

	public void setNumeroGiocatori(int numeroGiocatori) {
		this.numeroGiocatori = numeroGiocatori;
	}
}