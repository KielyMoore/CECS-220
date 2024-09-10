//***********************************************************************
// CreateTriangle.java    Author: Christopher Moore
// Assignment 2           date: 6/6/2020
// problem 2
//*************************************************************************

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;



public class ConversionPane extends GridPane{

	private Label outputlabel;
	private TextField inputfield;
	static double CONVFACTOR = 0.453592;
	static DecimalFormat fmt = new DecimalFormat("#.##");
	
	public ConversionPane() {
		
		Font font = new Font(12);
		
		Label inputlabel = new Label("Weight in Pounds/Kilograms:");
		inputlabel.setFont(font);
		
		outputlabel = new Label("---");
		outputlabel.setFont(font);
		
		Button lbs_btn = new Button("Convet to Pounds");
		lbs_btn.setFont(font);
		lbs_btn.setOnAction(this::toLbs);
		
		Button kgs_btn = new Button("Convet to Kilograms");
		kgs_btn.setFont(font);
		kgs_btn.setOnAction(this::toKgs);

		
		inputfield = new TextField();
		inputfield.setFont(font);
		
		setAlignment(Pos.CENTER);
		setHgap(20);
		setVgap(20);
		
		add(inputlabel,0,0);
		add(inputfield,1,0);
		add(kgs_btn,0,1);
		add(lbs_btn,2,1);
		add(outputlabel,1,2);
		
	}
	
	public void toLbs(ActionEvent event){
		
		double input = Integer.parseInt(inputfield.getText());
		double output = input / CONVFACTOR;
		outputlabel.setText(fmt.format(output));
	}
	
	public void toKgs(ActionEvent event) {
		double input = Integer.parseInt(inputfield.getText());
		double output = input * CONVFACTOR;
		outputlabel.setText(fmt.format(output));
	}
	
}
