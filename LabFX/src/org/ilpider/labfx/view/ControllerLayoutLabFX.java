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
	private LabFXMain labFXMain;	// mi serve il riferimento per chiamare i metodi creaNuovapartita
									// e inizializzaLayoutGiocatori

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
		if (partita == null) {
			/*
			 * mi aspetto di entrarci solo la prima volta che viene premuto btnNuovaPartita
			 * 
			 * creo la nuova partita passando il numeroGiocatori
			 * sarà la partita a creare la List<Giocatori>
			 */
			labFXMain.creaNuovaPartita(numeroGiocatori);
		} else {
			/*
			 * dovrei entrarci tutte le altre volte esclusa la prima che viene premuto btnNuovaPartita
			 * creo la nuova partita passando la List<Giocatori> della partita gia esistente
			 * cosi la nuova partita non crea la nuova lista e usa sempre la stessa
			 */

			// se il numGiocatori della partita attuale è uguale al rdb selezionato vuol
			// dire che non è cambiato il numero dei giocatori e di conseguenza non devo
			// rifare la List..gliela passo alla partita
			if (partita.getNumeroGiocatori() == leggiNumeroGiocatori()) {
				partita.getListaGiocatori().forEach(g -> g.setPuntiGiocatore(0));
				labFXMain.creaNuovaPartita(partita.getListaGiocatori());
			} else {
				// se è cambiato il numero dei giocatori faccio nuova partita con costruttore che fa creare anche la List
				labFXMain.creaNuovaPartita(numeroGiocatori);
			}
		}

		/*
		 * dopo che nella partita si è creato il layoutGiocatori, aggiorno il layoutLabFX
		 */
//		partita.getLayoutGiocatori();
		labFXMain.inizializzaLayoutGiocatori(partita.getLayoutGiocatori());
	}

	@FXML
	void doCalcolaPunteggi(ActionEvent event) {
//		partita.getListaGiocatori().forEach(g -> g.getListRigaNumero().);
	}

	@FXML
	public int leggiNumeroGiocatori() {
		Toggle selectedToggle = grpNumeroGiocatori.getSelectedToggle();
		numeroGiocatori = (int) selectedToggle.getUserData();
		return numeroGiocatori;
	}

	/*
	 * getters e setters
	 */
//	public Partita getPartita() {
//		return partita;
//	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

//	public LabFXMain getLabFXMain() {
//		return labFXMain;
//	}

	public void setLabFXMain(LabFXMain labFXMain) {
		this.labFXMain = labFXMain;
	}
}