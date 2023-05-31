package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {

	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };

	private LocalDateTime datahora;
	private double duracao;
	private Rota rota;
	private Status status;

	public Voo(LocalDateTime datahora) {
		this.datahora = datahora;
		this.status = Status.CONFIRMADO; // default é confirmado
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public abstract Rota getRota();
	public abstract String getDuracao();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status novo) {
		this.status = novo;
	}

	@Override
	public String toString() {
		return String.format("Rota: %s, no horário de %s, com duracao de %s --- STATUS: %s \n",rota, datahora, duracao, status);
	}
}