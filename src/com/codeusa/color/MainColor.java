package com.codeusa.color;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainColor extends Application {
	public static BorderPane root;

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {
		System.setProperty("prism.lcdtext", "false");
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("Color.fxml"));
			root.setStyle("-fx-background: #232323;");
			final Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setFullScreen(true);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
