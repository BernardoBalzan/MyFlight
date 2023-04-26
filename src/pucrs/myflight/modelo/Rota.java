package pucrs.myflight.modelo;

public class Rota implements Contavel, Comparable<Rota> {
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	private static int totalRotas = 0;

	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		totalRotas++;
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;		
	}	

	public CiaAerea getCia() {
		return cia;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public Aeroporto getOrigem() {
		return origem;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	@Override
	public String toString() {
		return String.format("%s da %s com rota de %s ate %s",aeronave, cia, origem, destino);
	}

	public void contar() {
		System.out.println("total de Rotas cadastradas: " + totalRotas);
	}

	public int compareTo(Rota outra) {
		return cia.getNome().compareTo(outra.cia.getNome());
	}

}
