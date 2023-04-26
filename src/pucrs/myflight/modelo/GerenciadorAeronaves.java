package pucrs.myflight.modelo;

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
}