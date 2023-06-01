package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GerenciadorPaises {
    private ArrayList<Pais> paises;
    
    
    private GerenciadorPaises() {
        paises = new ArrayList<>();
    }
    private static GerenciadorPaises instance;
    public static GerenciadorPaises getInstance() {
        if (instance == null)
            instance = new GerenciadorPaises();

        return instance;
     }

     public void adicionar(Pais pais) {
        paises.add(pais);
    }

    public ArrayList<Pais> listarTodos() {
		return paises;
	} 

    public Pais buscarPorCodigo(String codigo) {
        for (Pais pais : paises) {
            if (pais.getCodigo().equals(codigo))
                return pais;
        }
        return null;
    }

    public void carregaDadosPaises() {
        Path path1 = Paths.get("countries.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String codigo = dados[0];
                String nome = dados[1];
                Pais pais = new Pais(nome, codigo);
                adicionar(pais);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
