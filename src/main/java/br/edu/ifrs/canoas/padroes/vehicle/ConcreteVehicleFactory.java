package br.edu.ifrs.canoas.padroes.vehicle;

public class ConcreteVehicleFactory extends VehicleFactory {

	public ConcreteVehicleFactory() {
		super();
	}

	public ConcreteVehicleFactory(double chanceCar, double chanceBus, double chanceTruck) {
		super(chanceCar, chanceBus, chanceTruck);
	}

	@Override
	public Vehicle createVehicle() {
		double randNumber = Math.random() * 100;
		if (randNumber < this.getChanceTruck()) {
			return new Truck();
		} else if (randNumber < (this.getChanceTruck() + this.getChanceBus())) {
			return new Bus();
		} else {
			return new Car();
		}
	}
}
