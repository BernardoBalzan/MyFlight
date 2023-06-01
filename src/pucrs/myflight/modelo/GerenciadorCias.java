package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void carregaDadosCias() {
        Path path1 = Paths.get("airlines.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String codigo = dados[0];
                String nome = dados[1];
                CiaAerea ciaAerea = new CiaAerea(codigo, nome);
                adicionar(ciaAerea);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}