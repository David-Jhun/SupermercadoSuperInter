package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.UniversalController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Supermarket;

public class Main extends Application{
	
	private Supermarket supermarket;
	private UniversalController controller;
	
	public Main() {
		supermarket = new Supermarket();
		controller = new UniversalController(supermarket);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome!");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		loader.setController(controller);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				try {
					supermarket.saveFiles();
				}catch( FileNotFoundException e ){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("" + e.getClass());
					alert.setContentText(e.getMessage());
					alert.show();
				}catch( IOException e ) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("" + e.getClass());
					alert.setContentText(e.getMessage());
					alert.show();
				}
				System.exit(0);
			}
		});
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
