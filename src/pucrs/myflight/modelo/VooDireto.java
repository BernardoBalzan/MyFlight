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
    public Duration getDuracao() {
        return duracao;
    }
    
}
