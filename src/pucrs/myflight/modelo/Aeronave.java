package pucrs.myflight.modelo;

public class Aeronave implements Contavel, Comparable<Aeronave> {
	private String codigo;
	private String descricao;
	private int capacidade;
	private static int totalAeronaves = 0;

	public Aeronave(String codigo, String descricao, int capacidade) {
		totalAeronaves++;
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;
	}

	public int getCapacidade(){
		return capacidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return String.format("(%s) Aeronave: %s, Capacidade: %d",codigo, descricao, capacidade);
	}

	public void contar() {
		System.out.println("Total de Aeronaves cadastradas: " + totalAeronaves);
	}

	public int compareTo(Aeronave outra) {
    	return descricao.compareTo(outra.descricao);
	}
}	