package org.ilpider.labfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ilpider.labfx.model.Giocatore;
import org.ilpider.labfx.model.Partita;
import org.ilpider.labfx.view.ControllerDialogNuovaPartita;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LabFXDialog {

	private Stage dialogStage;
	private LabFXMain labFXMain; // è il riferimento alla mainWindow
	private Partita partita; // mi serve per creare la partita
	private List<Giocatore> listaGiocatori; // mi serve per creare la lista e passarla alla partita
	private ControllerDialogNuovaPartita controllerDialog; //riferimento al controller della Dialog

	public LabFXDialog(LabFXMain labFXMain) {
//		this.labFXMain = labFXMain;
		dialogStage = new Stage();
		dialogStage.setTitle("Nuova Partita");

		try {
			FXMLLoader dialogLoader = new FXMLLoader(getClass().getResource("view/DialogNuovaPartita.fxml"));
			BorderPane layoutDialog = dialogLoader.load();
			controllerDialog = dialogLoader.getController();

			dialogStage.initModality(Modality.APPLICATION_MODAL);
			dialogStage.setScene(new Scene(layoutDialog));
			dialogStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void creaListaGiocatori() {

		listaGiocatori = new ArrayList<Giocatore>(); // creo la lista di Giocatore
		int numeroGiocatori = controllerDialog.leggiNumeroGiocatori(); //leggo il UserData del RadioButton selezionato

		for (int i = 0; i < numeroGiocatori; i++) {
			Giocatore g = new Giocatore(i);
			listaGiocatori.add(g);
		}

		listaGiocatori.forEach(g -> System.out.println("Giocatore: " + g.getIDGiocatore()));
	}

	public void creaNuovaPartita(List<Giocatore> listaGiocatori) {
		partita = new Partita(listaGiocatori);
	}

	public List<Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}

	public void setListaGiocatori(List<Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}
}
