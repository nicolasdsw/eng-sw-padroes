package br.edu.ifrs.canoas.padroes;

import br.edu.ifrs.canoas.padroes.time.Time;
import br.edu.ifrs.canoas.padroes.time.TimeObserver;
import br.edu.ifrs.canoas.padroes.vehicle.ConcreteVehicleFactory;
import br.edu.ifrs.canoas.padroes.vehicle.VehicleFactory;
import br.edu.ifrs.canoas.padroes.vehicle.VehicleQueue;

/**
 * Hello world!
 *
 */
public class MainApp {

	private final static int DURATION = 600;
	private final static int CHANCE_CAR = 80;
	private final static int CHANCE_BUS = 12;
	private final static int CHANCE_TRUCK = 8;
	private final static double VEHICLES_PER_SECOND = 0.5;
	public final static int STOP_DURATION = 20;
	public final static int GO_DURATION = 30;
	public final static int CAUTION_DURATION = 0;

	public static void main(String[] args) {
		VehicleFactory vf = new ConcreteVehicleFactory(CHANCE_CAR, CHANCE_BUS, CHANCE_TRUCK);
		TimeObserver queue = new VehicleQueue(VEHICLES_PER_SECOND, vf);
		Time.getInstance().addTimeObserver(queue);
		Time.init(DURATION);
		Time.getInstance().run();
	}
}
