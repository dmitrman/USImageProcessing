package com.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JFrame;

public class ClusterConstructor extends Application {

	public static void main(String[] args) {
		Application.launch(ClusterConstructor.class, (java.lang.String[]) null);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(ClusterConstructor.class
					.getResource("ClusterWindow.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ClusterConstructor");
			primaryStage.setResizable(false);
			primaryStage.show();			
		} catch (Exception ex) {
			Logger.getLogger(ClusterConstructor.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		
	}
}
