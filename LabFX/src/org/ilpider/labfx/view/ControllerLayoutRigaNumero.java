package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.ilpider.labfx.model.RigaNumero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ControllerLayoutRigaNumero {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private CheckBox chkB;
	@FXML
	private CheckBox chkC;
	@FXML
	private Button btnTogli;
	@FXML
	private Button btnPreso;
	@FXML
	private CheckBox chkA;

	private int IDNumero;
	private int numero;
	private RigaNumero rigaNumeroModel;

	@FXML
	void doBtnPreso(ActionEvent event) {

		if (rigaNumeroModel.isMorto()) {
			System.out.println("sono qui");
			rigaNumeroModel.getGiocatoreModel().setPuntiGiocatore(
					rigaNumeroModel.getGiocatoreModel().getPuntiGiocatore()
							+ numero);
//	    rigaNumeroModel.getGiocatoreModel().getPartitaModel().sommaPunti(numero);
		} else if (rigaNumeroModel.isChiuso()) {
			System.out.println("Era già chiuso");
			rigaNumeroModel.getGiocatoreModel().getPartitaModel()
					.sommaPunti(rigaNumeroModel.getId());
		} else if (!chkA.isSelected()) {
			chkA.setSelected(true);
		} else if (!chkB.isSelected()) {
			chkB.setSelected(true);
		} else if (!chkC.isSelected()) {
			chkC.setSelected(true);
			rigaNumeroModel.setChiuso(true);
			rigaNumeroModel.getGiocatoreModel().getPartitaModel()
					.isNumeroMorto(IDNumero);
		}
	}

	@FXML
	void doBtnTogli(ActionEvent event) {

		if (rigaNumeroModel.isChiuso()) {
			// System.out.println(numero + " Era chiuso");
		}
		if (chkC.isSelected()) {
			chkC.setSelected(false);
			rigaNumeroModel.setChiuso(false);
			rigaNumeroModel.getGiocatoreModel().getPartitaModel()
					.isNumeroMorto(IDNumero);
		} else if (chkB.isSelected()) {
			chkB.setSelected(false);
		} else if (chkA.isSelected()) {
			chkA.setSelected(false);
		} else {

			// System.out.println("mai preso " + numero + "qui");

		}
	}

	@FXML
	void initialize() {

		assert chkB != null : "fx:id=\"chkB\" was not injected: check your FXML file 'LayoutRigaNumero.fxml'.";
		assert chkC != null : "fx:id=\"chkC\" was not injected: check your FXML file 'LayoutRigaNumero.fxml'.";
		assert btnTogli != null : "fx:id=\"btnTogli\" was not injected: check your FXML file 'LayoutRigaNumero.fxml'.";
		assert btnPreso != null : "fx:id=\"btnPreso\" was not injected: check your FXML file 'LayoutRigaNumero.fxml'.";
		assert chkA != null : "fx:id=\"chkA\" was not injected: check your FXML file 'LayoutRigaNumero.fxml'.";
	}

	/*
	 * metodi
	 */
//    public boolean isMorto() {
//	return rigaNumeroModel.getGiocatoreModel().getPartitaModel()
//		.isNumeroMorto(numero);
//    }

	/*
	 * Getters e Setters
	 */
	public int getIDNumero() {
		return IDNumero;
	}

	public void setIDNumero(int numero) {
		this.IDNumero = numero;
	}

	public RigaNumero getRigaNumeroModel() {
		return rigaNumeroModel;
	}

	public void setRigaNumeroModel(RigaNumero rigaNumeroModel) {
		this.rigaNumeroModel = rigaNumeroModel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int valore) {
		btnPreso.setText("" + valore);
		this.numero = valore;
	}
}
