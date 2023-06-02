package com.basic.time;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeCountDown {

	private Timer timer;
	private int timeRemaining;

	public TimeCountDown() {
		this.timeRemaining = 0;
	}

	public void setTime(int time, TimeUnit unit) {
		this.timeRemaining = (int) unit.toSeconds(time);
	}

	public boolean isDone() {
		return timeRemaining == 0;
	}

	public void start() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (timeRemaining > 0) {
					System.out.println("Time remaining: " + timeRemaining + " seconds");
					timeRemaining--;
				} else {
					System.out.println("Time's up!");
					timer.cancel();
				}
			}
		}, 0, 1000); // 1000 milliseconds = 1 second
	}

	public static void main(String[] args) {
		TimeCountDown countdown = new TimeCountDown();
		countdown.setTime(10, TimeUnit.SECONDS); // Set the timer for 10 seconds
		countdown.start();

		while (!countdown.isDone()) {
			// Do other tasks while waiting for the countdown
		}

		System.out.println("Countdown is done.");
	}

}
