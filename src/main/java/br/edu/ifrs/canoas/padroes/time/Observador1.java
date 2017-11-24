package br.edu.ifrs.canoas.padroes.time;

public class Observador1 implements TimeObserver {

	@Override
	public void timeChanged(int newTime) {
		System.out.println("Observer 1, new time: " + newTime);		
	}

}
