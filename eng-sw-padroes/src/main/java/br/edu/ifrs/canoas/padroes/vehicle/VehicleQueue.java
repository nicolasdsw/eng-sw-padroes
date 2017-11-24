package br.edu.ifrs.canoas.padroes.vehicle;

import java.util.LinkedList;

import br.edu.ifrs.canoas.padroes.MainApp;
import br.edu.ifrs.canoas.padroes.time.TimeObserver;

public class VehicleQueue implements TimeObserver {

	LinkedList<Vehicle> theQueue;
	double queueLength = 0;
	double vehiclesPerSecond;
	VehicleFactory theFactory;
	
	private Signal signal;
	private int stateStartTime;
	private int countRequests;
	
	public VehicleQueue(double vehiclesPerSecond, VehicleFactory vf) {
		this.vehiclesPerSecond = vehiclesPerSecond;
		this.theFactory = vf;
		this.theQueue = new LinkedList<>();
		this.signal = new LightSignal();
		this.stateStartTime = 0;
		this.countRequests = 0;
	}
	
	public void enter() {
		if (Math.random() < vehiclesPerSecond) {
			theQueue.addLast(theFactory.createVehicle());			
		}
	}

	public void leave() {
		if (getSize() > 0 && signal.getState() == Signal.GO) {
			theQueue.removeFirst();			
		}
	}
	
	public double getLength() {
		double len = 0;
		for (Vehicle vehicle : theQueue) {
			len += vehicle.getLength();
		}
		return len;
	}
	
	public int getSize() {
		return theQueue.size();
	}
	
	public void list() {
		for (Vehicle vehicle : theQueue) {
			System.out.println(vehicle.toString());
		}
	}

	private int getMaxStateDuration() {
		switch (signal.getState()) {
		case Signal.STOP:
			return MainApp.STOP_DURATION;
		case Signal.GO:
			return MainApp.GO_DURATION;
		default:
			return MainApp.CAUTION_DURATION;
		}
	}
	
	@Override
	public void timeChanged(int newTime) {
		int stateDuration = newTime - this.stateStartTime;
		if (stateDuration > getMaxStateDuration()) {
			signal.changeState();
			this.stateStartTime = newTime;
			this.countRequests = 0;
			System.out.println("================SINAL ALTERADO PARA: "+ this.signal.getMessage());
		}
		this.enter();
		this.leave();		
		double randNumber = Math.random() * 100;
		if (randNumber < 10) {
			signal.requestHaltLine();
			this.countRequests = this.countRequests+1;
		}			

		System.out.println("---------------------------");
		System.out.println("Tempo atual:     " + newTime);	
		System.out.println("Tamanho da fila: " + this.getLength());	
		System.out.println("Nº de veículos na fila: " + this.getSize());	
		System.out.println("Solicitações de parada: " + this.countRequests);	
	}
}
