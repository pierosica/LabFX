package org.ilpider.labfx.model;

import org.ilpider.labfx.view.ControllerLayoutGiocatore;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Giocatore {

	private int IDGiocatore;
	private String nomeGiocatore;
	private int puntiGiocatore;
	private AnchorPane viewGiocatore;
	private ControllerLayoutGiocatore controllerLayoutGiocatore;

	public ControllerLayoutGiocatore getControllerLayoutGiocatore() {
		return controllerLayoutGiocatore;
	}

	public Giocatore(int IDGiocatore) {
		super();
		this.setIDGiocatore(IDGiocatore);
		this.puntiGiocatore = 0;
		setViewGiocatore();
		this.nomeGiocatore = controllerLayoutGiocatore.leggiNomeGiocatore();
	}

	public Giocatore(String nome) {
		super();
		this.nomeGiocatore = nome;
		this.puntiGiocatore = 0;
	}

	public AnchorPane getViewGiocatore() {
		return viewGiocatore;
	}

	public void setViewGiocatore() {
		try {
			FXMLLoader loaderViewGiocatore = new FXMLLoader();
			loaderViewGiocatore.setLocation(getClass().getResource("../view/LayoutGiocatore.fxml"));
			this.viewGiocatore = loaderViewGiocatore.load();
			controllerLayoutGiocatore = loaderViewGiocatore.getController();
			controllerLayoutGiocatore.setGiocatoreModel(this);
			// controllerLayoutGiocatore.setPuntiGiocatore(puntiGiocatore);
			// controllerLayoutGiocatore.setIDGiocatore(IDGiocatore);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}

	public int getPuntiGiocatore() {
		return puntiGiocatore;
	}

	public void setPuntiGiocatore(int puntiGiocatore) {
		this.puntiGiocatore = puntiGiocatore;
	}

	public int getIDGiocatore() {
		return IDGiocatore;
	}

	public void setIDGiocatore(int iDGiocatore) {
		IDGiocatore = iDGiocatore;
	}
}
