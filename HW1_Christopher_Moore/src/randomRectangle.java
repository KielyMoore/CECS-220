//****************************************************
// randomRectangle.java     Author: Christopher Moore
// Assignment 1             Date: 5/31/2020         
// Problem 2        
//****************************************************

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.util.Random;

public class randomRectangle extends Application 
{
	
	//-------------------------------------------
	//	Uses JavaFX to draw a rectangle 
	//  with randomly generated properties
	//-------------------------------------------
	
	public void start(Stage primaryStage)
	{
		Random generator = new Random();
		int x, y, length, width, r, g, b;
		
		length = generator.nextInt(30) + 21;
		width = generator.nextInt(30) + 21;
		x = generator.nextInt(300-length);
		y = generator.nextInt(300-width);
		r = generator.nextInt(256);
		g = generator.nextInt(256);
		b = generator.nextInt(256);
		
		Rectangle rectangle = new Rectangle(x,y,length,width);
		rectangle.setFill(Color.rgb(r,g,b));
		Group root = new Group(rectangle);
		Scene scene = new Scene(root, 300, 300, Color.WHITE);
		
		primaryStage.setTitle("randomRectangle.java");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args)
    {
        launch(args);
    }

}
