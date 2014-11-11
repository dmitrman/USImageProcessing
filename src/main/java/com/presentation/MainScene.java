package com.presentation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.matlab.functions.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainScene extends Application {

	public static void main(String[] args) {
		//Application.launch(MainScene.class, (java.lang.String[]) null);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		MatlabAPI a=(MatlabAPI) applicationContext.getBean("MatlabAPI");
		Object[] res=null;
		//res=a.getStatisticalFeatures("C:\\11.png", 20);
		//res=a.readImage("C:\\11.png");
		res=a.getHomomorphicFilter("C:\\11.png",3.0);
		System.out.println(res[0]);
		
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
