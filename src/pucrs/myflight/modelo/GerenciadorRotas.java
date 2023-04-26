package pucrs.myflight.modelo;

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
}