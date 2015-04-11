package org.ilpider.labfx.model;

import java.io.IOException;
import org.ilpider.labfx.view.ControllerLayoutRigaNumero;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class RigaNumero {

	private int id;
	private int numero;
	private boolean chiuso;
	private boolean morto;
	private AnchorPane layoutRigaNumero;
	private Giocatore giocatoreModel;
	private ControllerLayoutRigaNumero controllerLayoutRigaNumero;

	/*
	 * costruttore
	 */
	public RigaNumero(int id) {

		this.id = id;
		numero = id + 1;
		if (id == 20) {
			numero = 25;
		}
		this.chiuso = false;
		this.morto = false;
		setLayoutRigaNumero();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Getters e Setters
	 */
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isChiuso() {
		return chiuso;
	}

	public void setChiuso(boolean chiuso) {
		this.chiuso = chiuso;
	}

	public boolean isMorto() {
		return morto;
	}

	public void setMorto(boolean morto) {
		this.morto = morto;
	}

	public AnchorPane getLayoutRigaNumero() {
		return this.layoutRigaNumero;
	}

	public void setLayoutRigaNumero() {

		try {
			FXMLLoader loaderRigaNumero = new FXMLLoader();
			loaderRigaNumero.setLocation(getClass().getResource(
					"../view/LayoutRigaNumero.fxml"));
			layoutRigaNumero = (AnchorPane) loaderRigaNumero.load();
			controllerLayoutRigaNumero = loaderRigaNumero.getController();
			controllerLayoutRigaNumero.setIDNumero(id);
			controllerLayoutRigaNumero.setNumero(numero);
			controllerLayoutRigaNumero.setRigaNumeroModel(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Giocatore getGiocatoreModel() {
		return giocatoreModel;
	}

	public void setGiocatoreModel(Giocatore giocatoreModel) {
		this.giocatoreModel = giocatoreModel;
	}

	public ControllerLayoutRigaNumero getControllerLayoutRigaNumero() {
		return controllerLayoutRigaNumero;
	}

	public void setControllerLayoutRigaNumero(
			ControllerLayoutRigaNumero controllerLayoutRigaNumero) {
		this.controllerLayoutRigaNumero = controllerLayoutRigaNumero;
	}
}
