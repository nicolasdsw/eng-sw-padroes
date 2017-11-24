package br.edu.ifrs.canoas.padroes.vehicle;

public abstract class VehicleFactory {

	private double chanceCar;
	private double chanceBus;
	private double chanceTruck;

	public VehicleFactory() {
		this(80, 12, 8);
	}

	public VehicleFactory(double chanceCar, double chanceBus, double chanceTruck) {
		if (chanceCar + chanceBus + chanceTruck <= 100 
				&& chanceCar >= 0 && chanceBus >= 0 && chanceTruck >= 0) {
			this.chanceCar = chanceCar;
			this.chanceBus = chanceBus;
			this.chanceTruck = chanceTruck;
		}
	}

	public abstract Vehicle createVehicle();

	public double getChanceCar() {
		return chanceCar;
	}

	public void setChanceCar(double chanceCar) {
		this.chanceCar = chanceCar;
	}

	public double getChanceBus() {
		return chanceBus;
	}

	public void setChanceBus(double chanceBus) {
		this.chanceBus = chanceBus;
	}

	public double getChanceTruck() {
		return chanceTruck;
	}

	public void setChanceTruck(double chanceTruck) {
		this.chanceTruck = chanceTruck;
	}
}
