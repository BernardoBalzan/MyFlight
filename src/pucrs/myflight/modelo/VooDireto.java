package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {

    private Rota rota;
    private Duration duracao;

    public VooDireto(LocalDateTime dh, Rota rota) {
        super(dh);
        this.rota = rota;
    }

    @Override
    public Rota getRota() {
      return rota;
    }

    @Override
    public String getDuracao() {
        double duracaoHoras = 0;
        duracaoHoras = rota.getDestino().getLocal().distancia(rota.getOrigem().getLocal());
        duracao = Duration.ofHours((long)(duracaoHoras));
        return String.format("Duracao da viagem aproximada: %02d:%02d:%02d%n", duracao.toHours(), duracao.toMinutesPart(), duracao.toSecondsPart());
    }
    
}
