package browser;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class CenterPane {

	private WebEngine webEngine;
	private WebView browser;
	private BorderPane borderPane;

	public CenterPane(BorderPane borderPane, WebEngine webEngine, WebView browser) {
		this.borderPane = borderPane;
		this.browser = browser;
		this.webEngine = webEngine;
	}

	public void prepareCenter(String adress) {
		webEngine.load(adress);
		borderPane.setCenter(browser);
	}

}
