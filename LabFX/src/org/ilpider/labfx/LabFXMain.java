package org.ilpider.labfx;
/*
 * New branch
 */
import java.util.List;
import org.ilpider.labfx.model.Giocatore;
import org.ilpider.labfx.model.Partita;
import org.ilpider.labfx.view.ControllerDialogNuovaPartita;
import org.ilpider.labfx.view.ControllerLayoutLabFX;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

public class LabFXMain extends Application {

	private Stage primaryStage;
	private BorderPane layoutLabFXRoot;
	private ControllerLayoutLabFX controllerLayoutLabFXRoot;
	private ControllerDialogNuovaPartita controllerDialogNuovaPartita;
	private Partita partita;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LabFX");

		inizializzaLayoutLabFXRoot();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * relativo al layout
	 */
	public void inizializzaLayoutLabFXRoot() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/LayoutLabFX.fxml"));
			layoutLabFXRoot = loader.load();

			controllerLayoutLabFXRoot = loader.getController();
			controllerLayoutLabFXRoot.setLabFXMain(this);
			Scene scene = new Scene(layoutLabFXRoot);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());

			primaryStage.setScene(scene);
			// primaryStage.setMinWidth(800);
			// primaryStage.setMinHeight(600);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inizializzaLayoutGiocatori(GridPane layoutGiocatori) {
		layoutLabFXRoot.setCenter(layoutGiocatori);
		primaryStage.sizeToScene();
	}

	/*
	 * relativo alla Partita
	 * - creo una nuova partita
	 * - getter e setter di partita
	 * 
	 * DA VEDERE
	 * - apro la Dialog
	 * - getter e setter di controllerDialog
	 * 
	 */
	public void creaNuovaPartita(int numeroGiocatori) {

		partita = new Partita(numeroGiocatori);
		controllerLayoutLabFXRoot.setPartita(partita);
		// inizializzaLayoutGiocatori(partita.getLayoutGiocatori());
	}

	public void creaNuovaPartita(List<Giocatore> listaGiocatori) {
		partita = new Partita(listaGiocatori);
		controllerLayoutLabFXRoot.setPartita(partita);
	}

	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	public void mostraDialog() {
		new LabFXDialog(this);
	}

	public ControllerDialogNuovaPartita getControllerDialogNuovaPartita() {
		return controllerDialogNuovaPartita;
	}

	public void setControllerDialogNuovaPartita(ControllerDialogNuovaPartita controllerDialogNuovaPartita) {
		this.controllerDialogNuovaPartita = controllerDialogNuovaPartita;
	}
}
