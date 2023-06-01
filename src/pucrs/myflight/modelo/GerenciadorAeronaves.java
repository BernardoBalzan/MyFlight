package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    private GerenciadorAeronaves() {
        aeronaves = new ArrayList<>();
    }
    private static GerenciadorAeronaves instance;
    public static GerenciadorAeronaves getInstance() {
        if (instance == null)
            instance = new GerenciadorAeronaves();

        return instance;
     }


    public void adicionar(Aeronave aviao) {
        aeronaves.add(aviao);
    }

    /*public String listarTodas() {
        StringBuilder aux = new StringBuilder("\nCadastro de Aeronaves\n- - - - - - - - - - -\n");
        for (Aeronave aviao : aeronaves) {
            aux.append(aviao.toString() + "\n");
        }
        return aux.toString();
    }*/
    public ArrayList<Aeronave> listarTodas() {
        return aeronaves;
    }

    public Aeronave buscarPorCodigo(String codigo) {
        for (Aeronave aviao : aeronaves) {
            if (aviao.getCodigo().equals(codigo))
                return aviao;
        }
        return null;
    }

    public void ordenaDescricao() {
        Collections.sort(aeronaves);
    }

    public void carregaDadosAeronaves() {
        Path path1 = Paths.get("equipment.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String codigo = dados[0];
                String descricao = dados[1];
                int capacidade = Integer.parseInt(dados[2]);
                Aeronave aeronave = new Aeronave(codigo, descricao, capacidade);
                adicionar(aeronave);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}