//Entire Window: Stage
//Window inside: Scene
//Layout 
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootsCalculator extends Application {

	Button button;
	Button button2;
	
	Stage window;
	
	Scene scene1, scene2;
	String mainEquation = "";
	
	Label label1;
	Label equationLabel;
	TextField equationTextField;
	
	VBox layout1, layout2;
	
	public static void main(String[] args) {
		launch(args);

	}

	
	
	
	//Stage
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//sets Title
		window = primaryStage;
		window.setTitle("Quadratic Roots Calculator");
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
        //      Scene One                                //            
		//creates new Instances of a buttons, labels etc
		button = new Button("Enter Equation");
		equationTextField = new TextField();
		label1 = new Label("Input Quadratic with format(include spaces):ax^2 + bx +c");

		//creates a new Instance of a Layout to put buttons and such in
		layout1 = new VBox(20);
		// use addAll() or add() from List class to add to list of children
		layout1.getChildren().addAll(button , label1, equationTextField);
		// creates new instance of a scene inside the window, with a layout, and pixel
		scene1 = new Scene(layout1, 600, 500);
		
        //Event Handlers:
        button.setOnAction((ActionEvent eventButton) -> {
        	//System.out.println(equationTextField.getText());
        	
        	
  	    	//if label exists, erase it, and then put a new one, otherwise put a new one 
  	    	
  	    		if (layout1.getChildren().contains(equationLabel)) {
  	    			layout1.getChildren().remove(equationLabel);
  	    			
  	    			mainEquation = equationTextField.getText();
  	          	    Quadratic equationInput = Quadratic.signAnalyze(mainEquation);
  	    			equationLabel = new Label(equationInput.toString());
  	    			layout1.getChildren().add(equationLabel);
  	    		}
  	    		else {
  	    			mainEquation = equationTextField.getText();
  	          	    Quadratic equationInput = Quadratic.signAnalyze(mainEquation);
  	    			equationLabel = new Label(equationInput.toString());
  	    			layout1.getChildren().add(equationLabel);
  	    		}
  	    	
		});
        
	        equationTextField.setOnAction(eventTextField -> {
	    	//if label exists, erase it, and then put a new one, otherwise put a new one 
  	    	
	    		if (layout1.getChildren().contains(equationLabel)) {
	    			layout1.getChildren().remove(equationLabel);
	    			
	    			mainEquation = equationTextField.getText();
	          	    Quadratic equationInput = Quadratic.signAnalyze(mainEquation);
	    			equationLabel = new Label(equationInput.toString());
	    			layout1.getChildren().add(equationLabel);
	    		}
	    		else {
	    			mainEquation = equationTextField.getText();
	          	    Quadratic equationInput = Quadratic.signAnalyze(mainEquation);
	    			equationLabel = new Label(equationInput.toString());
	    			layout1.getChildren().add(equationLabel);
	    		}
	    });
		
		
		//by default sets to scene1
		//shows the window :p
		window.setScene(scene1);
		window.show();
		
		
////		
////		
////		
		
		
		
	}
		
	private boolean closeProgram() {
		Boolean answer = ConfirmBox.display("Exit Confirm", "Are you sure you want to exit");
		if (answer)
			window.close();
		return answer;
	}
	
	
}
