package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;

	private GerenciadorCias() {
        empresas = new ArrayList<>();
    }
    private static GerenciadorCias instance;
    public static GerenciadorCias getInstance() {
        if (instance == null)
            instance = new GerenciadorCias();

        return instance;
     }

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	} 

	public CiaAerea buscarPorCodigo(String codigo) {
        for (CiaAerea cia : empresas) {
            if (cia.getCodigo().equals(codigo))
                return cia;
        }
        return null;
    }

	public CiaAerea buscarPorNome(String nome) {
        for (CiaAerea cia : empresas) {
            if (cia.getNome().equals(nome))
                return cia;
        }
        return null;
    }

}