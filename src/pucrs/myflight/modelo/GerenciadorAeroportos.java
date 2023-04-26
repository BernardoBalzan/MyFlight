package pucrs.myflight.modelo;

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

}