package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    private GerenciadorVoos() {
        voos = new ArrayList<>();
    }
    private static GerenciadorVoos instance;
    public static GerenciadorVoos getInstance() {
        if (instance == null)
            instance = new GerenciadorVoos();

        return instance;
     }

    public void adicionar(Voo voo) {
        voos.add(voo);
    }

    /*public String listarTodas() {
        StringBuilder aux = new StringBuilder("\nVoos\n- - - - -\n");
        for (Voo voo : voos) {
            aux.append(voo.toString() + "\n");
        }
        return aux.toString();
    }*/
    public ArrayList<Voo> listarTodos() {
        return voos;
    }

    public ArrayList<Voo> buscarData(LocalDateTime data) {
        ArrayList<Voo> voosData;
        voosData = new ArrayList<>();

        for (Voo voo : voos) {
            if (voo.getDatahora().equals(data))
                voosData.add(voo);
        }
        if (voosData.size() != 0) {
            return voos;
        }
        else {
            return null;
        }

    }

}