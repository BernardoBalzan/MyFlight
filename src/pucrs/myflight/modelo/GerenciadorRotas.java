package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    private GerenciadorRotas() {
        rotas = new ArrayList<>();
    }
    private static GerenciadorRotas instance;
    public static GerenciadorRotas getInstance() {
        if (instance == null)
            instance = new GerenciadorRotas();

        return instance;
     }

    public void adicionar(Rota rota) {
        rotas.add(rota);
    }

    public ArrayList<Rota> listarTodas() {
        return rotas;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto orig) {
        ArrayList<Rota> rotasOrig;
        rotasOrig = new ArrayList<>();

        for (Rota rota : rotas) {
            if (rota.getOrigem().equals(orig))
                rotasOrig.add(rota);
        }
        if (rotasOrig.size() != 0) {
            return rotasOrig;
        }
        else {
            return null;
        }

    }
    
    public void ordenaCias() {
        Collections.sort(rotas);
    }

    public void carregaDadosRotas() {
        Path path1 = Paths.get("routes.dat");
        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(";");
                String origem = dados[1];
                String destino = dados[2];
                String codCiaAerea = dados[0];
                String codAeronave = dados[5];
                Aeroporto aeroportoOrigem = GerenciadorAeroportos.getInstance().buscaPorCodigo(origem);
                Aeroporto aeroportoDestino = GerenciadorAeroportos.getInstance().buscaPorCodigo(destino);
                CiaAerea ciaAerea = GerenciadorCias.getInstance().buscarPorCodigo(codCiaAerea);
                Aeronave aeronave = GerenciadorAeronaves.getInstance().buscarPorCodigo(codAeronave);
                Rota rota = new Rota(ciaAerea, aeroportoOrigem, aeroportoDestino, aeronave);
                adicionar(rota);
            }
        }
        catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}