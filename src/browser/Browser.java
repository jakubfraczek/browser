package browser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Browser extends Application {

	private final BorderPane borderPane = new BorderPane();
	private final WebView browser = new WebView();
	private final String DEFAULT = "https://www.google.pl/";
	private final WebEngine webEngine = browser.getEngine();

	public static void main(final String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CenterPane center = new CenterPane(borderPane, webEngine, browser);
		center.prepareCenter(DEFAULT);
		
		TopPane top = new TopPane(webEngine);
		top.prepareTop(borderPane, DEFAULT);

		LeftPane left = new LeftPane();
		left.prepareLeft();
		
		BottomPane bottom = new BottomPane();
		bottom.prepareBottom();
		
		RightPane right = new RightPane();
		right.prepareRigth();
		
		primaryStage.setScene(new Scene(borderPane, 800, 600));
		primaryStage.show();
}

}
