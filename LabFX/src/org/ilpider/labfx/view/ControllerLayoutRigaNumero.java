package org.ilpider.labfx.view;

import java.net.URL;
import java.util.ResourceBundle;
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

	@FXML
	void doBtnPreso(ActionEvent event) {
		if (!chkA.isSelected()) {
			chkA.setSelected(true);
		} else if (!chkB.isSelected()) {
			chkB.setSelected(true);
		} else if (!chkC.isSelected()) {
			chkC.setSelected(true);
		} else {
			System.out.println("chiuso");
		}
	}

	@FXML
	void doBtnTogli(ActionEvent event) {
		if (!chkA.isSelected()) {
			chkA.setSelected(true);
		} else if (!chkB.isSelected()) {
			chkB.setSelected(true);
		} else if (!chkC.isSelected()) {
			chkC.setSelected(true);
		} else {
			System.out.println("chiuso");
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
}
