package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class Partita {

	private int numeroGiocatori;
	private List<Giocatore> listaGiocatori;
	private GridPane layoutGiocatori;

	/*
	 * Costruttori
	 * 
	 * la differenza: con numeroGiocatori -> creo anche la listaGiocatori con
	 * listaGiocatori -> uso la listaGiocatori gia esistente
	 */
	public Partita(int numeroGiocatori) {
		this.numeroGiocatori = numeroGiocatori;
		creaListaGiocatori(numeroGiocatori);
		creaLayoutGiocatori(listaGiocatori);
	}

	public Partita(List<Giocatore> listaGiocatori) {
		this.numeroGiocatori = listaGiocatori.size();
		List<Giocatore> lG = listaGiocatori;
		creaListaGiocatori(this.numeroGiocatori);
		for (int i = 0; i < lG.size(); i++) {
			this.listaGiocatori.get(i).setNomeGiocatore(
					lG.get(i).getNomeGiocatore());
		}
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
			g.setPartitaModel(this);
			listaGiocatori.add(g);
		}
	}

	private GridPane creaLayoutGiocatori(List<Giocatore> listaGiocatori) { // creo il layout che contiene i pannelli dei singoli Giocatore
		try {
			FXMLLoader loaderLayoutGiocatori = new FXMLLoader();
			loaderLayoutGiocatori.setLocation(getClass().getResource(
					"/org/ilpider/labfx/view/LayoutGiocatori.fxml"));
			layoutGiocatori = (GridPane) loaderLayoutGiocatori.load();
			// ciclo sulla lista per assegnare tutte le viewGiocatore al
			// GridPane LayoutGiocatori
			for (Giocatore g : listaGiocatori) {
				ColumnConstraints col = new ColumnConstraints();
				col.setFillWidth(true);
				layoutGiocatori
						.add(g.getViewGiocatore(), g.getIDGiocatore(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layoutGiocatori;
	}

	public void calcolaPunteggio() {
		listaGiocatori.forEach(h -> h.scriviPuntiFinali(h.getPuntiGiocatore()));
		listaGiocatori.forEach(g -> g.contaAperti());
		listaGiocatori.forEach(b -> System.out.println(b.getNomeGiocatore()
				+ " ha fatto " + b.getPuntiGiocatore() + " punti totali"));
		listaGiocatori.forEach(f -> f.setPuntiGiocatore(f.getPuntiGiocatore()));
	}

	/*
	 * controlla se tutti i giocatori hanno preso il numero
	 * 		si - restituisce true e setta setMorto(true) a tutti i RigaNumero di tutti i giocatori
	 * 		no - restituisce false e mette false ai RigaNumero di tutti i giocatori 
	 */
	public boolean isNumeroMorto(int numero) {

		if (listaGiocatori.stream().allMatch(
				g -> g.getListRigaNumero().get(numero).isChiuso())) {
			Stream<Giocatore> giocatoriNumeroChiuso = listaGiocatori.stream()
					.filter(c -> c.getListRigaNumero().get(numero).isChiuso());
			giocatoriNumeroChiuso.forEach(n -> n.getListRigaNumero()
					.get(numero).setMorto(true));
			return true;
		} else {
			listaGiocatori.forEach(n -> n.getListRigaNumero().get(numero)
					.setMorto(false));
			return false;
		}
	}

	public boolean esisteWinner() {
		// trovo il Giocatore che ha il punteggio piu basso
		Giocatore giocatorePuntiBassi = listaGiocatori
				.stream()
				.sorted((e1, e2) -> Integer.compare(e1.getPuntiGiocatore(),
						e2.getPuntiGiocatore())).findFirst().get();
		// se lo stesso ha anche isTuttoChiuso = true lo setto come winner
		if (giocatorePuntiBassi.isTuttoChiuso()) {
			System.out.println("setto il winner");
			giocatorePuntiBassi.setWinner(true);
			return true;
		} else {
			return false;
		}
	}

	public void sommaPunti(int id) {
		if (isNumeroMorto(id)) {
		} else {
			Stream<Giocatore> giocatoriNumeroAperto = listaGiocatori.stream()
					.filter(a -> !a.getListRigaNumero().get(id).isChiuso());
			giocatoriNumeroAperto.forEach(g -> g.setPuntiGiocatore(g
					.getPuntiGiocatore()
					+ g.getListRigaNumero().get(id).getNumero()));
			Stream<Giocatore> giocatoriNumeroApertoa = listaGiocatori.stream()
					.filter(a -> !a.getListRigaNumero().get(id).isChiuso());
			giocatoriNumeroApertoa.forEach(f -> f.setPuntiCaricati(f
					.getPuntiCaricati()
					+ f.getListRigaNumero().get(id).getNumero()));
		}
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
	 * usato dal controllerLayoutLabFX per vedere se cambi il numero rispetto al
	 * radioButton e decidere se fare una nuova partita con una nuova lista o
	 * solo una nuova partita utilizzando la lista esistente
	 * 
	 * SE ho una lista e il numero di giocatori della partita in corso e quelli
	 * della nuova partita non cambiano, ho buoni motivi per ipotizzare che i
	 * giocatori sono gli stessi per cui non li ricreo
	 */
	public int getNumeroGiocatori() {
		return numeroGiocatori;
	}
}