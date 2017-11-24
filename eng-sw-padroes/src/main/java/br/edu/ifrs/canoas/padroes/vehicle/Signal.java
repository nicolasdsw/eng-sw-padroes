package br.edu.ifrs.canoas.padroes.vehicle;

public abstract class Signal {
	
	public final static int STOP = 1;
	public final static int CAUTION = 2;
	public final static int GO = 3;

	private boolean haltLine = false;
	private int state = STOP;
	
	public void changeState() {
		switch (this.state) {
		case GO:
			this.state = CAUTION;
			this.haltLine = false;
			break;
		case STOP:
			this.state = GO;
			break;
		default:
			this.state = STOP;
			break;
		}
	}
	
	public void setState() {
		this.state = GO;
		this.haltLine = false;
	}

	public int getState() {
		return state;
	}

	public boolean getHaltLine() {
		return haltLine;
	}
	
	public void requestHaltLine() {
		this.haltLine = true;
	}

	public void haltGranted() {
		this.haltLine = false;
	}
	
	public abstract String getMessage();
}
