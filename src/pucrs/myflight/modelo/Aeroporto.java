package pucrs.myflight.modelo;

public class Aeroporto implements Contavel, Comparable<Aeroporto> {
	private String codigo;
	private String nome;
	private Geo loc;
	private static int quantAeroporto = 0;
	private Pais pais;

	public Aeroporto(String codigo, String nome, Geo loc, Pais pais) {
		quantAeroporto++;
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Geo getLocal() {
		return loc;
	}

	@Override
	public String toString() {
		return String.format("%s (%s), %s %s \n",nome, codigo, pais, loc);
	}

	public int compareTo(Aeroporto outro) {
		return nome.compareTo(outro.nome);
	}

	public void contar() {
		System.out.println("Quantidade de Aeroportos cadastrados: " + quantAeroporto);
	}
}