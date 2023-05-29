package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {

    private Rota rota;
    private Duration duracao;

    private ArrayList<Rota> escalas;

    private VooEscalas(LocalDateTime dh) {
        super(dh);
        escalas = new ArrayList<>();
    }

    public void adicionarRotas(Rota rota) {
        escalas.add(rota);
    }

    @Override
    public Rota getRota() {
        return rota;
    }

    @Override
    public Duration getDuracao() {
        double distancia = 0;
        for(Rota rota : escalas) {
            distancia = rota.getDestino().getLocal().distancia(rota.getOrigem().getLocal());
            distancia = (distancia / 805) + 0.5;
        }
        duracao = Duration.ofHours((long)(distancia));
        return duracao;
    }

    public ArrayList<Rota> getRotas() {
        return escalas;
    }

}
