//*****************************************************************
// CreateTriangle.java    Author: Christopher Moore
// Assignment 2           date: 6/1/2020
// problem 2
//*****************************************************************

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ConversionFX extends Application{
	//----------------------------------------------------------
	// Launches an instance of the Conversion Application
	//----------------------------------------------------------
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
			
		Scene scene = new Scene(new ConversionPane(), 500, 300);
		
		primaryStage.setTitle("ConversionFX.java");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
