package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean confirmStatus;
	
	public static boolean display(String title, String message) {
		//window setup
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		//Label in screen
		Label label = new Label();
		label.setText(message);
		//buttons
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {confirmStatus = true;
		window.close();
		});
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {confirmStatus = false;
		window.close();
		});
		
	    //setup layout
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label , yesButton, noButton);
		layout.setAlignment(Pos.TOP_CENTER);
		//setup scene
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.showAndWait();
		return confirmStatus;
	}
	
	
	
	
}