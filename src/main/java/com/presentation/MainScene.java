package com.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainScene extends Application {

	public static void main(String[] args) {
		Application.launch(MainScene.class, (java.lang.String[]) null);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(MainScene.class
					.getResource("MainWindow.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Surf");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(MainScene.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

}
