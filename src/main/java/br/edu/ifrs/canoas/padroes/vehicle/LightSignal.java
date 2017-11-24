package br.edu.ifrs.canoas.padroes.vehicle;

public class LightSignal extends Signal {

	@Override
	public String getMessage() {
		switch (this.getState()) {
		case GO:
			return "\033[32m VERDE \033[0m";
		case STOP:
			return "\033[31m VERMELHO \033[0m";
		default:
			return "\033[33m AMARELO \033[0m";
		}
	}
}
