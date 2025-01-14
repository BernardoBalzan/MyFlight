package pucrs.myflight.modelo;

public class CiaAerea {
	private String codigo;
	private String nome;

	public CiaAerea(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}	

	@Override
	public String toString() {
		return String.format("(%s) - %s \n",codigo, nome);
	}

    public int compareTo(CiaAerea cia) {
        return 0;
    }
}