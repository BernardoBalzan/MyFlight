package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {

    private Rota rota;
    private Duration duracao;

    private ArrayList<Rota> escalas;

    public VooEscalas(LocalDateTime dh) {
        super(dh);
        escalas = new ArrayList<>();
    }

    public void adicionarRotas(Rota rota) {
        escalas.add(rota);
    }

    @Override
    public Rota getRota() {
        for (Rota rota : escalas) {
            return rota;
        }
        return null;
    }

    @Override
    public String getDuracao() {
        double distancia = 0;
        for(Rota rota : escalas) {
            distancia += rota.getDestino().getLocal().distancia(rota.getOrigem().getLocal());
        }
        distancia = ((distancia / 805) + (escalas.size() * 0.5));
        duracao = Duration.ofHours((long)(distancia));
        return String.format("Duracao da viagem aproximada: %02d:%02d:%02d%n", duracao.toHours(), duracao.toMinutesPart(), duracao.toSecondsPart());
    }

    public ArrayList<Rota> getRotas() {
        return escalas;
    }

}
