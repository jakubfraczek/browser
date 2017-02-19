package browser;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;

public class TopPane {
	private WebEngine webEngine;
	private TextField adressField = new TextField();
	private HBox topLayout = new HBox();
	
	public TopPane(WebEngine webEngine) {
		this.webEngine = webEngine;
	}
	
	
	public void prepareTop(BorderPane borderPane, String DEFAULT) {
		adressField.setMinWidth(500);

		topLayout.setPadding(new Insets(5, 0, 5, 0));
		topLayout.setAlignment(Pos.CENTER);

		Button homeButton = new Button("|^|");
		topLayout.getChildren().add(homeButton);
		homeButton.setOnAction(Event -> webEngine.load(DEFAULT));
		adressField.setText(DEFAULT);

		adressField.getText();
		topLayout.getChildren().add(adressField);
		adressField.setOnKeyPressed(e -> onKlik(e));

		Button reload = new Button("<>");
		topLayout.getChildren().add(reload);

		borderPane.setTop(topLayout);
	}
	
	private void onKlik(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			String text = adressField.getText();
			text = correctAdress(text);
			webEngine.load(text);
			adressField.setText(text);
		}
	}
	
	private String correctAdress(String adress) {
		if (adress.contains("http")) {
			return adress;
		} else if (adress.contains("www")) {
			return "http://" + adress;
		} else if (adress.contains("://")) {
			return adress;
//		} else if (adress.contains("http")) {
			
		} else {
			return adress;
		}

	}

}
