package org.ilpider.labfx.view;

import org.ilpider.labfx.LabFXMain;
import org.ilpider.labfx.model.Partita;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
//import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ControllerLayoutLabFX {

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
	private ToggleGroup grpNumeroGiocatori;
	@FXML
	private Button btnNuovaPartita;
	@FXML
	private Button btnCalcolaPunteggi;
	@FXML
	private Label lblBottom;

	private Partita partita;
	private int numeroGiocatori;
	private LabFXMain labFXMain;

	/*
	 * metodi che gestiscono i controlli del layout
	 */
	@FXML
	void initialize() {
		assert rdb4 != null : "fx:id=\"rdb4\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert lblBottom != null : "fx:id=\"lblBottom\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert rdb3 != null : "fx:id=\"rdb3\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert rdb2 != null : "fx:id=\"rdb2\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert grpNumeroGiocatori != null : "fx:id=\"grpNumeroGiocatori\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";
		assert btnCalcolaPunteggi != null : "fx:id=\"btnCalcolaPunteggi\" was not injected: check your FXML file 'LayoutLabFX.fxml'.";

		rdb2.setUserData(2);
		rdb3.setUserData(3);
		rdb4.setUserData(4);

		leggiNumeroGiocatori();
	}

	@FXML
	void doRadioButtonNumero() {
//		grpNumeroGiocatori.selectedToggleProperty().addListener(
//				(ObservableValue<? extends Toggle> ov, Toggle old_toggle,
//						Toggle new_toggle) -> {
//					if (grpNumeroGiocatori.getSelectedToggle() != null) {
//						if (new_toggle.getUserData().equals(2)) {
//							System.out.println("cambiato RadioButton da: " + old_toggle + " a: " + new_toggle);
//						}
//						if (new_toggle.getUserData().equals(3)) {
//							System.out.println("cambiato RadioButton da: " + old_toggle + " a: " + new_toggle);
//						}
//						if (new_toggle.getUserData().equals(4)) {
//							System.out.println("cambiato RadioButton da: " + old_toggle + " a: " + new_toggle);
//						}
//					}
//				});
	}

	@FXML
	void doNuovaPartita(ActionEvent event) {

		leggiNumeroGiocatori();
		System.out.println(partita);
		if (partita == null) {
			System.out.println("nessuna partita");
			labFXMain.creaNuovaPartita(numeroGiocatori);
		} else {
			System.out.println("Esiste già " + partita);
			if (partita.getNumeroGiocatori() == leggiNumeroGiocatori()) {
				labFXMain.creaNuovaPartita(partita.getListaGiocatori());
			} else {
				labFXMain.creaNuovaPartita(numeroGiocatori);
			}
		}
		//		labFXMain.mostraDialog();
		// vediSeFareNuovaPartita();
		// System.out.println("toggle selezionato: " + leggiNumeroGiocatori());

		// leggiNumeroGiocatori();

		// labFXMain.creaNuovaPartita();
		// partita.setNumeroGiocatori(numeroGiocatori);
		partita.getLayoutGiocatori();
		labFXMain.inizializzaLayoutGiocatori(partita.getLayoutGiocatori());
	}

	@FXML
	void doCalcolaPunteggi(ActionEvent event) {
		System.out.println(partita.getListaGiocatori());
		partita.getListaGiocatori().forEach(g -> System.out.println(g.getNomeGiocatore()));
		// System.out.println("leggo il numero giocatori della partita in corso "
		// + partita.toString() + " e il numero giocatori è "
		// + partita.getNumeroGiocatori());
		// partita.creaListaGiocatori();
	}

	@FXML
	public int leggiNumeroGiocatori() {
		Toggle selectedToggle = grpNumeroGiocatori.getSelectedToggle();
		numeroGiocatori = (int) selectedToggle.getUserData();
		return numeroGiocatori;
	}

	/*
	 * metodi di logica del gioco
	 */
	public void vediSeFareNuovaPartita() {
		// List<Giocatore> listaInUso = partita.getListaGiocatori();
		// System.out.println("vedi se fare nuova partita.." + listaInUso);
		// System.out.println("ControllerLayoutLabFX - vediSeFareNuovaPartita" +
		// listaInUso);
		// listaInUso
		// .forEach(g -> System.out
		// .printf("printf2%n %-8s %25d %n %-8s %25s %n %-8s %25d %n %-8s %25s %n",
		// "ID:", g.getIDGiocatore(),
		// "Nome:", g.getNomeGiocatore(),
		// "Punti:", g.getPuntiGiocatore(),
		// "View:",g.getViewGiocatore()));
	}

	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	public LabFXMain getLabFXMain() {
		return labFXMain;
	}

	public void setLabFXMain(LabFXMain labFXMain) {
		this.labFXMain = labFXMain;
	}
}