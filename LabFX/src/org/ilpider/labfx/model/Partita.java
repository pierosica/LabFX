package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class Partita {

	private int numeroGiocatori;
	private List<Giocatore> listaGiocatori;
	private GridPane layoutGiocatori;

	/*
	 * Costruttori
	 * 
	 * la differenza:
	 * con numeroGiocatori -> creo anche la listaGiocatori
	 * con listaGiocatori -> uso la listaGiocatori gia esistente
	 */
	public Partita(int numeroGiocatori) {
		this.numeroGiocatori = numeroGiocatori;
		creaListaGiocatori(numeroGiocatori);
//		listaGiocatori.forEach(g -> System.out.println("ID: " + g.getIDGiocatore() + "nome: " + g.getNomeGiocatore() + "punti: "
//				+ g.getPuntiGiocatore() + "view: " + g.getViewGiocatore()));
		creaLayoutGiocatori(listaGiocatori);
	}

	public Partita(List<Giocatore> listaGiocatori) {
		this.numeroGiocatori = listaGiocatori.size();
		this.listaGiocatori = listaGiocatori;
		creaLayoutGiocatori(this.listaGiocatori);
	}

	/*
	 * Metodi
	 */
	private void creaListaGiocatori(int numeroGiocatori) {
		listaGiocatori = new ArrayList<Giocatore>();

		for (int i = 0; i < numeroGiocatori; i++) {
			Giocatore g = new Giocatore(i);
			g.setPuntiGiocatore(0);
			listaGiocatori.add(g);
		}
	}

	private GridPane creaLayoutGiocatori(List<Giocatore> listaGiocatori) { // creo il layout che contiene i pannelli dei singoli Giocatore

		try {
			FXMLLoader loaderLayoutGiocatori = new FXMLLoader();
			loaderLayoutGiocatori.setLocation(getClass().getResource("../view/LayoutGiocatori.fxml"));
			layoutGiocatori = (GridPane) loaderLayoutGiocatori.load();
			// ciclo sulla lista per assegnare tutte le viewGiocatore al
			// GridPane LayoutGiocatori
			for (Giocatore g : listaGiocatori) {
//				g.getControllerLayoutGiocatore().setPuntiGiocatore(0);
				layoutGiocatori.add(g.getViewGiocatore(), g.getIDGiocatore(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layoutGiocatori;
	}

	/*
	 * getters e setters
	 */
	public GridPane getLayoutGiocatori() {
		return layoutGiocatori;
	}

	/*
	 * usato dal controllerLayoutLabFX
	 */
	public List<Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}

	/*
	 * usato dal controllerLayoutLabFX per vedere se cambi il numero rispetto al radioButton 
	 * e decidere se fare una nuova partita con una nuova lista o solo una nuova partita
	 * utilizzando la lista esistente
	 * 
	 * SE ho una lista e il numero di giocatori della partita in corso e quelli della nuova partita
	 * non cambiano, ho buoni motivi per ipotizzare che i giocatori sono gli stessi per cui non li ricreo 
	 */
	public int getNumeroGiocatori() {
		return numeroGiocatori;
	}
}