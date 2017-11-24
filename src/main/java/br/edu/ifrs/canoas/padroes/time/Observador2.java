package br.edu.ifrs.canoas.padroes.time;

public class Observador2 implements TimeObserver {

	@Override
	public void timeChanged(int newTime) {
		System.out.println("Observer 2, new time: " + newTime);		
	}

}
