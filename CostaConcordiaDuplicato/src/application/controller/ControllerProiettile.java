package application.controller;

import application.ProiettiLoop;
import application.model.Gioco;
import application.model.Mondo;
import application.model.Posizione;
import application.model.Proiettile;

public class ControllerProiettile {
    private Gioco controller = Gioco.getGioco();
    private Mondo mondo = controller.getMondo();

    public void ridirezioneProiettile(Proiettile proiettile) {
        switch (proiettile.direzione) {
            case 0 -> caseSparoSX(proiettile);
            case 1 -> caseSparoDX(proiettile);
        }
    }

    private void caseSparoSX(Proiettile proiettile) {
        Posizione p = calcolaNuovaPosizione(proiettile);
        proiettile.setPosProiettile(p);
        mondo.aggiornaProiettile(p);

        // Avvia il thread per gestire il proiettile
        ProiettiLoop loop = new ProiettiLoop(proiettile);
        loop.start();
    }

    private void caseSparoDX(Proiettile proiettile) {
        Posizione p = calcolaNuovaPosizione(proiettile);
        proiettile.setPosProiettile(p);
        mondo.aggiornaProiettile(p);

        // Avvia il thread per gestire il proiettile
        ProiettiLoop loop = new ProiettiLoop(proiettile);
        loop.start();
    }

    private Posizione calcolaNuovaPosizione(Proiettile proiettile) {
        int px = proiettile.getPosProiettile().getX();
        int py = proiettile.getPosProiettile().getY();
        return switch (proiettile.giroNave) {
            case 0 -> new Posizione(px, py + 1); // punta sx
            case 1 -> new Posizione(px, py - 1); // punta dx
            case 2 -> new Posizione(px - 1, py); // punta up
            case 3 -> new Posizione(px + 1, py); // punta down
            default -> throw new IllegalStateException("Unexpected value: " + proiettile.giroNave);
        };
    }
}
