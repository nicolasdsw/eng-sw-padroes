package br.edu.ifrs.canoas.padroes.time;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private int currentTime;
	private static int endOfTime;
	private static Time instance;
	private List<TimeObserver> observers;
	
	private Time(int endOfTime) {
		this.currentTime = 0;
		Time.endOfTime = endOfTime;
		this.observers = new ArrayList<>();
	}

	public static Time getInstance() {
		if (instance == null)
			instance = new Time(Time.endOfTime);
		return instance;
	}
	
	public static void init(int endOfTime) {
		Time.endOfTime = endOfTime;
	}
	
	public void run() {
		while (this.currentTime < Time.endOfTime) {
			this.currentTime++;
			for (TimeObserver timeObserver : observers) {
				timeObserver.timeChanged(this.currentTime);
			}
		}
	}
	
	public void addTimeObserver(TimeObserver timeObserver) {
		this.observers.add(timeObserver);
	}
	
	public void removeTimeObserver(TimeObserver timeObserver) {
		this.observers.remove(timeObserver);		
	}
	
	public int getCurrentTime() {
		return currentTime;
	}
	
	public static int getEndOfTime() {
		return endOfTime;
	}
}
