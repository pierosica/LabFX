package org.ilpider.labfx.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javafx.fxml.FXMLLoader;
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

	private GridPane creaLayoutGiocatori(List<Giocatore> listaGiocatori) { // creo
// il layout che contiene i pannelli dei singoli Giocatore

		try {
			FXMLLoader loaderLayoutGiocatori = new FXMLLoader();
			loaderLayoutGiocatori.setLocation(getClass().getResource(
					"../view/LayoutGiocatori.fxml"));
			layoutGiocatori = (GridPane) loaderLayoutGiocatori.load();
			// ciclo sulla lista per assegnare tutte le viewGiocatore al
			// GridPane LayoutGiocatori
			for (Giocatore g : listaGiocatori) {
				layoutGiocatori
						.add(g.getViewGiocatore(), g.getIDGiocatore(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layoutGiocatori;
	}

	public boolean isNumeroMorto(int numero) {
		boolean morto = false;
		listaGiocatori.forEach(g -> g.getListRigaNumero().get(numero)
				.setMorto(false));
		Stream<Giocatore> giocatoriIsChiuso = listaGiocatori.stream().filter(
				p -> p.getListRigaNumero().get(numero).isChiuso());
		if (giocatoriIsChiuso.count() == listaGiocatori.size()) {
			morto = true;
			System.out.println("numero: " + numero + " morto: " + morto);
			listaGiocatori.forEach(g -> g.getListRigaNumero().get(numero)
					.setMorto(true));
		}
		return morto;
	}

	public void sommaPunti(int id) {
		System.out.println("sommo i punti: " + id);
		if (isNumeroMorto(id)) {
//			System.out.println("sommo i punti a me");
		} else {
			System.out.println("sommo i punti agli altri");
			Stream<Giocatore> giocatoriNumeroAperto = listaGiocatori.stream()
					.filter(a -> !a.getListRigaNumero().get(id).isChiuso());
			giocatoriNumeroAperto.forEach(g -> g.setPuntiGiocatore(g
					.getPuntiGiocatore() + g.getListRigaNumero().get(id).getNumero()));
			Stream<Giocatore> giocatoriNumeroApertoa = listaGiocatori.stream()
					.filter(a -> !a.getListRigaNumero().get(id).isChiuso());
			giocatoriNumeroApertoa.forEach(f -> f.setPuntiCaricati(f
					.getPuntiCaricati() + f.getListRigaNumero().get(id).getNumero()));
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