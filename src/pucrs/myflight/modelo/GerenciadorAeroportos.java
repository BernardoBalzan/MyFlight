package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    private GerenciadorAeroportos() {
        aeroportos = new ArrayList<>();
    }
    private static GerenciadorAeroportos instance;
    public static GerenciadorAeroportos getInstance() {
        if (instance == null)
            instance = new GerenciadorAeroportos();

        return instance;
     }

     public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
     }

     public ArrayList<Aeroporto> listarTodos() {
        return aeroportos;
     }

     public Aeroporto buscaPorCodigo(String codigo) {
        for (Aeroporto aero : aeroportos) {
            if (aero.getCodigo().equals(codigo))
                return aero;
        }
        return null;
    }

    public void ordenaNome() {
        Collections.sort(aeroportos);
    }

    public void carregaDadosAeroportos() {
        Path path1 = Paths.get("airports.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String codigo = dados[0];
                double latitude = Double.parseDouble(dados[1]);
                double longitude = Double.parseDouble(dados[2]);
                String nome = dados[3];
                Geo geo = new Geo(latitude, longitude);
                Pais pais = GerenciadorPaises.getInstance().buscarPorCodigo(dados[4]);
                Aeroporto aeroporto = new Aeroporto(codigo, nome, geo, pais);
                adicionar(aeroporto);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}