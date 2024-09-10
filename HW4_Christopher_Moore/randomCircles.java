import java.util.Random;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

//***********************************************************
// randomCircles.java          Author: Christopher Moore
// Problem 2                    Date: 7/2/2020
//
// Crate 40 random circles using JavaFX
//***********************************************************
public class randomCircles extends Application {

	private Circle[] Circles = new Circle[40];
	private Group root;
	private Random generator = new Random();
	
	//========================================================================
	// Create a JavaFX scene that displays Randomly generated circles
	//========================================================================
	public void start(Stage primaryStage)
	{
		root = new Group();
		Scene scene = new Scene(root, 300, 300, Color.WHITE);
        
		//Fill circle array with randomly generated circles
        for(int index = 0; index < Circles.length; index++)
		{
			double radius = generator.nextInt(29) + 1;
			double x = generator.nextInt((int)(scene.getWidth() - 2 * radius)) + radius;
			double y = generator.nextInt((int)(scene.getHeight() - 2 * radius)) + radius;
			Circles[index] = new Circle(x,y,radius);
		}
		
        //========================================================================
        // Iterate through the array comparing it to other circles in the array 
        // if the current circle overlaps another circle its opacity is set  
        // to 0.3, if a circle never overlaps it is opaque. 
        //========================================================================
        for(int current = 0; current < Circles.length; current++) 
        {
        	for(int compare = 0; compare < Circles.length; compare++) 
        	{
        		if (current == compare) continue; //won't compare to itself
        		
        		double xdist = Math.abs(Circles[current].getCenterX() - Circles[compare].getCenterX());
        		double ydist = Math.abs(Circles[current].getCenterY() - Circles[compare].getCenterY());
        		double distance = Math.sqrt(Math.pow(xdist, 2) + Math.pow(ydist, 2));
        		
        		if(distance < Circles[current].getRadius() + Circles[compare].getRadius())
        		{
        			Circles[current].setFill(Color.rgb(3, 152, 252, 0.3));
        			break;
        		}
        		Circles[current].setFill(Color.rgb(3, 152, 252));
        	}
        }
		
        //add all Circles to the group of the scene. 
        for (Circle circle : Circles)
        {
        	root.getChildren().add(circle);
        }
        
        primaryStage.setTitle("randomCircles");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	} 
}
