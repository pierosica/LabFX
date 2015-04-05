package org.ilpider.labfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ilpider.labfx.model.Giocatore;
import org.ilpider.labfx.view.ControllerDialogNuovaPartita;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LabFXDialog {

//	private LabFXMain labFXMain;
	private Stage dialogStage;
//	private Partita modelPartita;
	private List<Giocatore> listaGiocatori;
	private ControllerDialogNuovaPartita controllerDialog;

	public LabFXDialog(LabFXMain labFXMain) {
//		this.labFXMain = labFXMain;
		dialogStage = new Stage();
		dialogStage.setTitle("Nuova Partita");

		try {
			FXMLLoader dialogLoader = new FXMLLoader(getClass().getResource(
					"view/DialogNuovaPartita.fxml"));
			BorderPane layoutDialog = dialogLoader.load();
			controllerDialog = dialogLoader.getController();
			
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			dialogStage.setScene(new Scene(layoutDialog));
			dialogStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		/*
		 * leggo il Partita dal labFXMain
		 */
//		this.modelPartita = this.labFXMain.getPartita();

//		 leggoListaGiocatori();
	}

	public void leggoListaGiocatori() {

//		List<Giocatore> listaGiocatori = modelPartita.getListaGiocatori();
//		if (listaGiocatori!=null) {
//			System.out.println(listaGiocatori);
//		} else {
//			
//		}
//		listagiocatori.forEach(g -> System.out.println(g.getIDGiocatore()));
	}


//	public void creaListaGiocatori(int numeroGiocatori) {
//
//		listaGiocatori = new ArrayList<Giocatore>();
//
//		for (int i = 0; i < numeroGiocatori; i++) {
//			Giocatore g = new Giocatore(i);
//			g.setNomeGiocatore(controllerDialog.leggiNomeGiocatore(i));
//			listaGiocatori.add(g);
//			
//		}
//		
//		listaGiocatori.forEach(g -> System.out.println("Giocatore: " + g.getIDGiocatore()));
//	}

	public List<Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}


	public void setListaGiocatori(List<Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}
}
