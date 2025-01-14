package pucrs.myflight.modelo;

public class Pais {
    private String nome;
    private String codigo;

    public Pais(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")\n";
    }
}
