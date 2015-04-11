package org.ilpider.labfx.model;

import org.ilpider.labfx.view.ControllerLayoutGiocatore;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Giocatore {

	private int IDGiocatore;
	private String nomeGiocatore;
	private int puntiGiocatore;
	private GridPane viewGiocatore;
	private ControllerLayoutGiocatore controllerLayoutGiocatore;

	/*
	 * Costruttori
	 */
	public Giocatore(int IDGiocatore) {
		super();
		this.setIDGiocatore(IDGiocatore);
		this.puntiGiocatore = 0;
		setViewGiocatore();
	}

	/*
	 * metodi
	 */
	public ControllerLayoutGiocatore getControllerLayoutGiocatore() {
		return controllerLayoutGiocatore;
	}

	/*
	 * getters e setters
	 */
	public int getIDGiocatore() {
		return IDGiocatore;
	}

	public void setIDGiocatore(int iDGiocatore) {
		IDGiocatore = iDGiocatore;
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
		controllerLayoutGiocatore.setTxtNome(this.nomeGiocatore);
	}

	public int getPuntiGiocatore() {
		return puntiGiocatore;
	}

	public GridPane getViewGiocatore() {
		return viewGiocatore;
	}

	private void setViewGiocatore() {
		try {
			FXMLLoader loaderViewGiocatore = new FXMLLoader();
			loaderViewGiocatore.setLocation(getClass().getResource("../view/LayoutGiocatore.fxml"));
			this.viewGiocatore = loaderViewGiocatore.load();
			controllerLayoutGiocatore = loaderViewGiocatore.getController();
			controllerLayoutGiocatore.setGiocatoreModel(this);

//			System.out.println(viewGiocatore.getChildren());
			
			FXMLLoader loaderRigaNumero = new FXMLLoader();
			loaderRigaNumero.setLocation(getClass().getResource("../view/LayoutRigaNumero.fxml"));
			AnchorPane rigaNumero = (AnchorPane) loaderRigaNumero.load();
			this.viewGiocatore.add(rigaNumero, 0, 3);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPuntiGiocatore(int i) {
		this.puntiGiocatore = i;
		controllerLayoutGiocatore.setTxtPunti("" + i);
	}
}
