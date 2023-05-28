package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooVariasEscalas extends VooEscalas {
    
    private VooEscalas escalas;

    public VooVariasEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao, VooEscalas escalas) {
        super(rota, rotaFinal, datahora, duracao);
        this.escalas = escalas;
    }

    public VooEscalas getEscalas() {
        return escalas;
    }
}
