package com.codeusa.color;

import com.codeusa.color.utils.Utils;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ColorController {
	@FXML
	private Label hexLabel;

	@FXML
	private Label timeLabel;

	@FXML
	protected void initialize() {
		final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
				actionEvent -> Utils.doSubtleColor(ColorController.this.timeLabel, ColorController.this.hexLabel)),
				new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

}
