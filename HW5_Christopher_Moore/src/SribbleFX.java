import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

//***********************************************************
// Scribble.java         Author: Christopher Moore
// Problem 2             Date: 7/12/2020
//
// Allows to draw a scribble on screen
//***********************************************************
public class SribbleFX extends Application{
	
	private Group root;
	private ColorPicker colorpicker;
	private Button clearbtn;
	private Color stroke;
	private Polyline polyline;
	
	public void start(Stage primaryStage) {
		
		colorpicker = new ColorPicker(Color.BLACK);
		stroke = colorpicker.getValue();
		colorpicker.setOnAction(event -> {stroke = colorpicker.getValue();});
		clearbtn = new Button("Clear");
		clearbtn.setLayoutY(25);
		clearbtn.setOnAction(this::clear);
		
		root = new Group(colorpicker, clearbtn);
		Scene scene = new Scene(root,500,500,Color.WHITE);
		
		scene.setOnMousePressed(this::startLine);
		scene.setOnMouseDragged(this::addPoints);
		
		primaryStage.setTitle("Scribble");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public void clear(ActionEvent event) {
		root.getChildren().clear();
		root.getChildren().add(colorpicker);
		root.getChildren().add(clearbtn);
	}
	
	public void startLine(MouseEvent event) {
		polyline = new Polyline();
		polyline.setStroke(stroke);
		root.getChildren().add(polyline);
	}
	
	public void addPoints(MouseEvent event) {
		polyline.getPoints().addAll(event.getX(), event.getY());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
