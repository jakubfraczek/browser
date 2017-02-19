package javaFx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class ShapesExamples extends Application {

	private Group root = new Group();

	@Override
	public void start(Stage primaryStage) throws Exception {

		face();

		eye(100, 100);
		eye(200, 100);
		nose(120, 175, 150, 120, 180, 175);
		
		smile();
		
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void smile() {
		QuadCurve smile = new QuadCurve(90, 210, 150, 260, 200, 210);
		
		root.getChildren().add(smile);
	}

	private void nose(int x, int y, int a, int b, int c, int d) {
		Polygon nose = new Polygon(x, y, a, b, c, d);
		nose.setFill(Color.BROWN);
		root.getChildren().add(nose);
	}

	private void eye(int x, int y) {
		Ellipse eye = new Ellipse(x, y, 30, 20);
		eye.setFill(Color.WHITE);
		root.getChildren().add(eye);
		Circle iris = new Circle(x, y, 5);
		iris.setFill(Color.BLACK);
		root.getChildren().add(iris);
	}

	private void face() {
		Circle circle = new Circle(150, 150, 140);
		circle.setFill(Color.ANTIQUEWHITE);
		root.getChildren().add(circle);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
