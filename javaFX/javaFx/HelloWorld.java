package javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button parent = new Button("Hello world!");
		parent.setOnAction((ActionEvent) -> System.out.println("Dupa!"));
		Scene scene = new Scene(parent);

		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	class ButtonAction implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}

		
	}
}