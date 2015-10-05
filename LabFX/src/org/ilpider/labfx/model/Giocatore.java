package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.ilpider.labfx.view.ControllerLayoutGiocatore;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class Giocatore {

	private int IDGiocatore;
	private String nomeGiocatore;
	private int puntiGiocatore;
	private int puntiCaricati;
	private GridPane viewGiocatore;
	private ControllerLayoutGiocatore controllerLayoutGiocatore;
	private boolean tuttoChiuso;
	private boolean winner;
	private int numeri = 21; // quanti sono i "numeri" sul tabellone - - DEFAULT 21
	private Partita partitaModel;
	private List<RigaNumero> listRigaNumero;
	private RigaNumero rigaNumeroFix;

	/*
	 * Costruttori
	 */
	public Giocatore(int IDGiocatore) {
		super();
		this.setIDGiocatore(IDGiocatore);
		this.puntiGiocatore = 0;
		this.puntiCaricati = 0;
		this.setTuttoChiuso(false);
//		this.setWinner(false);
		setViewGiocatore();
		creaListRigaNumero();
	}

	/*
	 * metodi
	 */
	public void contaAperti() {
		listRigaNumero.forEach(n -> System.out.println(n.getNumero() + ""
				+ n.isChiuso()));
		Stream<RigaNumero> righeAperte = listRigaNumero.stream().filter(
				n -> !n.isChiuso());
//		righeAperte.forEach(r -> System.out.println(r.puntiDaAperte()));
//		controllerLayoutGiocatore.setTxtPunti(getPuntiGiocatore() + " totalizza: " );
		righeAperte.forEach(a -> puntiGiocatore = puntiGiocatore
				+ a.puntiDaAperte());

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

	public void setPuntiGiocatore(int i) {
		this.puntiGiocatore = i;
		controllerLayoutGiocatore.setTxtPunti("" + i);
	}

	public int getPuntiCaricati() {
		return puntiCaricati;
	}

	public void setPuntiCaricati(int puntiCaricati) {
		this.puntiCaricati = puntiCaricati;
		controllerLayoutGiocatore.setLblPuntiCaricati(puntiCaricati);
	}

	public GridPane getViewGiocatore() {
		return viewGiocatore;
	}

	private void setViewGiocatore() {
		try {
			FXMLLoader loaderViewGiocatore = new FXMLLoader();
			loaderViewGiocatore.setLocation(getClass().getResource(
					"/org/ilpider/labfx/view/LayoutGiocatore.fxml"));
			this.viewGiocatore = loaderViewGiocatore.load();
			controllerLayoutGiocatore = loaderViewGiocatore.getController();
			controllerLayoutGiocatore.setGiocatoreModel(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isTuttoChiuso() {

		if (listRigaNumero.stream().allMatch(n -> n.isChiuso())) {
			tuttoChiuso = true;
			return tuttoChiuso;
		} else {
			tuttoChiuso = false;
			return tuttoChiuso;
		}
	}

	public void setTuttoChiuso(boolean tuttoChiuso) {
		this.tuttoChiuso = tuttoChiuso;
	}

	public boolean isWinner() {
		winner = partitaModel.esisteWinner();
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public List<RigaNumero> getListRigaNumero() {
		return listRigaNumero;
	}

	public void creaListRigaNumero() {

		listRigaNumero = new ArrayList<RigaNumero>();

		for (int i = 0; i < numeri; i++) {
			rigaNumeroFix = new RigaNumero(i);
			rigaNumeroFix.setGiocatoreModel(this);
			rigaNumeroFix.getLayoutRigaNumero().autosize();
			listRigaNumero.add(rigaNumeroFix);
			
			viewGiocatore.add(rigaNumeroFix.getLayoutRigaNumero(), 0, 3 + i);
			
		}

		

	}

	public Partita getPartitaModel() {
		return partitaModel;
	}

	public void setPartitaModel(Partita partitaModel) {
		this.partitaModel = partitaModel;
	}

	public void scriviPuntiFinali(int puntiGiocatore) {
		controllerLayoutGiocatore.setLblPuntiFinali(puntiGiocatore);
	}

//	public ControllerLayoutGiocatore getControllerLayoutGiocatore() {
//		return controllerLayoutGiocatore;
//	}

}
