package br.edu.ifrs.canoas.padroes.vehicle;

public abstract class Vehicle {

	protected double speed = 0;
	protected double maxSpeed;
	protected double length;
	
	public Vehicle(double length, double maxSpeed) {
		this.length = length;
		this.maxSpeed = maxSpeed;
	}

	public double getSpeed() {
		return speed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getLength() {
		return length;
	}

	public void accelerate(double deltaV) {
		this.speed = validateSpeed(this.speed + deltaV);
	}

	public void decelerate(double deltaV) {
		this.speed = validateSpeed(this.speed - deltaV);
	}

	private double validateSpeed(double speedAux) {
		if (speedAux < 0) {
			speedAux = 0;
		} else if (speedAux > this.maxSpeed) {
			speedAux = this.maxSpeed;
		}
		return speedAux;
	}

	@Override
	public String toString() {
		return "Vehicle [speed=" + speed + ", maxSpeed=" + maxSpeed + ", length=" + length + "]";
	}
}
