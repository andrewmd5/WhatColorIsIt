package com.codeusa.color.utils;

import java.util.Calendar;

import com.codeusa.color.MainColor;

import javafx.scene.control.Label;

public class Utils {
	private static Label hexLabel;
	private static Label timeLabel;

	public static String convert(final int n) {
		return Integer.toHexString(n);
	}

	public static void doSubtleColor(final Label timeLabel, final Label hexLabel) {
		final Calendar date = Calendar.getInstance();
		final int roundedSeconds = date.get(Calendar.SECOND) * 4;
		final int seconds = date.get(Calendar.SECOND);
		final int minutes = date.get(Calendar.MINUTE);
		int hours = date.get(Calendar.HOUR);
		final int roundedMinutes = (int) ((date.get(Calendar.MINUTE) * 4) + Math.floor(date.get(Calendar.SECOND) / 15));
		final int roundedHours = (int) ((date.get(Calendar.HOUR) * 10) + Math.floor(date.get(Calendar.MINUTE) / 6));

		if (hours == 0) {
			hours = 12;
		}
		String hex_seconds = convert(roundedSeconds);
		String hex_minutes = convert(roundedMinutes);
		String hex_hours = convert(roundedHours);

		final String displayHours = String.valueOf(hours);
		final String displayMinutes = String.valueOf(minutes);
		final String displaySeconds = String.valueOf(seconds);

		if (hex_seconds.length() < 2) {
			hex_seconds = "0" + hex_seconds;
		}
		if (hex_minutes.length() < 2) {
			hex_minutes = "0" + hex_minutes;
		}
		if (hex_hours.length() < 2) {
			hex_hours = "0" + hex_hours;
		}

		final String ampmString = date.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
		final String color = hex_hours + hex_minutes + hex_seconds + "";
		timeLabel.setText(pad(2, '0', displayHours) + ":" + pad(2, '0', displayMinutes) + ":"
				+ pad(2, '0', displaySeconds) + " " + ampmString);
		hexLabel.setText("#" + color);
		MainColor.root.setStyle(String.format("-fx-background: #%s;", color));
	}

	public static Label getHexLabel() {
		return hexLabel;
	}

	public static Label getTimeLabel() {
		return timeLabel;
	}

	public static String pad(final int fieldWidth, final char padChar, final String s) {
		final StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}

	public static void setHexLabel(final Label hexLabel) {
		Utils.hexLabel = hexLabel;
	}

	public static void setTimeLabel(final Label timeLabel) {
		Utils.timeLabel = timeLabel;
	}
}
