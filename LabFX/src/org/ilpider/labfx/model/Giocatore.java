package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import org.ilpider.labfx.view.ControllerLayoutGiocatore;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class Giocatore {

	private int IDGiocatore;
	private String nomeGiocatore;
	private int puntiGiocatore;
	private GridPane viewGiocatore;
	private ControllerLayoutGiocatore controllerLayoutGiocatore;

	private List<RigaNumero> listRigaNumero;

	/*
	 * Costruttori
	 */
	public Giocatore(int IDGiocatore) {
		super();
		this.setIDGiocatore(IDGiocatore);
		this.puntiGiocatore = 0;
		setViewGiocatore();
		creaListRigaNumero();
	}

	/*
	 * metodi
	 */
	public ControllerLayoutGiocatore getControllerLayoutGiocatore() {
		return controllerLayoutGiocatore;
	}

	public void creaListRigaNumero() {

		for (int i = 0; i < 10; i++) {
			listRigaNumero = new ArrayList<RigaNumero>();
			RigaNumero rigaNumeroFix = new RigaNumero(i);
			listRigaNumero.add(rigaNumeroFix);
			this.viewGiocatore.add(rigaNumeroFix.getLayoutRigaNumero(), 0, 3 + i);
		}
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPuntiGiocatore(int i) {
		this.puntiGiocatore = i;
		controllerLayoutGiocatore.setTxtPunti("" + i);
	}

	public List<RigaNumero> getListRigaNumero() {
		return listRigaNumero;
	}

//	public void setListRigaNumero(List<RigaNumero> listRigaNumero) {
//		this.listRigaNumero = listRigaNumero;
//	}
}
