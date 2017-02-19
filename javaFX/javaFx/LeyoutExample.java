package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LeyoutExample extends Application{

	public static void main(final String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();
		
		setButton(vBox, "1", "Kuba");
		setButton(vBox, "2", "Justyna");
		setButton(vBox, "3", "Agnieszka");
		
		Scene scene = new Scene(vBox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void setButton(VBox vBox, String num, String out) {
		Button button1 = new Button(num);
		vBox.getChildren().add(button1);
		button1.setOnAction((Event) -> System.out.println(out));
	}

}
