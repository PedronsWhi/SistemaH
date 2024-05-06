package entities;

import java.util.concurrent.Semaphore;

public class Recepcionista extends Thread {
    private Semaphore acessoQuartos;
    private Quarto[] quartos;
    private int maxHospedesPorQuarto;

    public Recepcionista(Semaphore acessoQuartos, Quarto[] quartos, int maxHospedesPorQuarto) {
        this.acessoQuartos = acessoQuartos;
        this.quartos = quartos;
        this.maxHospedesPorQuarto = maxHospedesPorQuarto;
    }


    @Override
    public void run() {
        while (true) {
            try {
                acessoQuartos.acquire(); // Recepcionista aguarda acesso aos quartos
                alocaHospede();
                acessoQuartos.release(); // Libera o acesso aos quartos
                Thread.sleep(1000); // Espera um segundo antes de atender o próximo hóspede
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void alocaHospede() {
        // Implemente a lógica de alocação de hóspedes nos quartos aqui
    }
}
