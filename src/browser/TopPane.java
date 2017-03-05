package browser;

import java.io.IOException;
import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;

public class TopPane {
	private WebEngine webEngine;
	private TextField adressField = new TextField();
	private HBox topLayout = new HBox();
//	private String text;
	final private Image buttonImage = new Image("https://lh3.ggpht.com/A0x3jzuH1qRkE10HcTiT4qQr_6iAqVg-CTsoIqxnoIFyv92V91WI3KqiVlOvLtfoMRg=w300");
	final private Image reloadImage = new Image("http://www.free-icons-download.net/images/reload-icon-47520.png");
	
	public TopPane(WebEngine webEngine) {
		this.webEngine = webEngine;
	}
	
	
	public void prepareTop(BorderPane borderPane, String DEFAULT) {
		adressField.setMinWidth(500);
		adressField.setText(DEFAULT);
		
		topLayout.setPadding(new Insets(5, 0, 5, 0));
		topLayout.setAlignment(Pos.CENTER);

		setHomeButton(DEFAULT);

		adressField.getText();
		topLayout.getChildren().add(adressField);
		adressField.setOnKeyPressed(e -> onKlikReload(e));

		setReloadButton();
		

		borderPane.setTop(topLayout);
	}


	private void setReloadButton() {
		ToggleButton reloadButton = new ToggleButton();
		ImageView iv = new ImageView(reloadImage);
		iv.setFitHeight(16);
		iv.setFitWidth(16);
		reloadButton.setGraphic(iv);
		topLayout.getChildren().add(reloadButton);
		reloadButton.setOnAction(e -> {webEngine.load(webEngine.locationProperty().getValue()); adressField.setText(webEngine.locationProperty().getValue());});
	}
	
	private void setHomeButton(String DEFAULT) {
		ToggleButton homeButton = new ToggleButton();
		ImageView iv = new ImageView(buttonImage);
		iv.setFitHeight(16);
		iv.setFitWidth(16);
		homeButton.setGraphic(iv);
		topLayout.getChildren().add(homeButton);
		homeButton.setOnAction(Event -> {webEngine.load(DEFAULT); adressField.setText(DEFAULT);});
	}
	
	private void onKlikReload(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			String text = adressField.getText();
			if (!isValidURL(text)){
				text = correctAdress(text);
			}
			webEngine.load(text);
			adressField.setText(text);
		}
	}
	
	public boolean isValidURL(String url){
		    try {
		         new URL(url);
		    } catch (IOException e) {
		    	return false;
		    }
		    return true;
	}

	
	private String correctAdress(String adress) {
		if (adress.startsWith("http", 4)) {
			return adress;
		} else if (adress.startsWith("www")) {
			return "http://" + adress;
		} else if (adress.startsWith("://")) {
			return adress;
		} else {
			return "http://www." + adress;
		}

	}

}
