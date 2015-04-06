package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class Partita {

	private int numeroGiocatori;
	private List<Giocatore> listaGiocatori;
	private GridPane layoutGiocatori;

	public Partita(int numeroGiocatori) {
		System.out.println("non qui");
		this.numeroGiocatori = numeroGiocatori;
		creaListaGiocatori(numeroGiocatori);
		listaGiocatori.forEach(g -> System.out.println("ID: " + g.getIDGiocatore() + "nome: " + g.getNomeGiocatore() + "punti: "
				+ g.getPuntiGiocatore() + "view: " + g.getViewGiocatore()));
		creaLayoutGiocatori(listaGiocatori);
	}

	public Partita(List<Giocatore> listaGiocatori) {
		System.out.println("sono qui");
		this.numeroGiocatori = listaGiocatori.size();
		this.listaGiocatori = listaGiocatori;
		creaLayoutGiocatori(this.listaGiocatori);
	}

	public void creaListaGiocatori(int numeroGiocatori) {
		listaGiocatori = new ArrayList<Giocatore>();

		for (int i = 0; i < numeroGiocatori; i++) {
			Giocatore g = new Giocatore(i);
			listaGiocatori.add(g);
		}
	}

	public void addGiocatoreToList(int ID, String nome) {
		Giocatore g = new Giocatore(nome);
		listaGiocatori.add(g);
	}

	public GridPane creaLayoutGiocatori(List<Giocatore> listaGiocatori) { // creo il layout che contiene i pannelli dei singoli Giocatore

		try {
			FXMLLoader loaderLayoutGiocatori = new FXMLLoader();
			loaderLayoutGiocatori.setLocation(getClass().getResource("../view/LayoutGiocatori.fxml"));
			layoutGiocatori = (GridPane) loaderLayoutGiocatori.load();
			// ciclo sulla lista per assegnare tutte le viewGiocatore al
			// GridPane LayoutGiocatori
			for (Giocatore g : listaGiocatori) {
				// System.out.println("aaa");
				layoutGiocatori.add(g.getViewGiocatore(), g.getIDGiocatore(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layoutGiocatori;
	}

	public GridPane getLayoutGiocatori() {
		return layoutGiocatori;
	}

	public List<Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}

	public int getNumeroGiocatori() {
		return numeroGiocatori;
	}

	public void setNumeroGiocatori(int numeroGiocatori) {
		this.numeroGiocatori = numeroGiocatori;
	}
}
