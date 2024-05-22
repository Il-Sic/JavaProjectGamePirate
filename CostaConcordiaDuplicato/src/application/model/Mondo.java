package application.model;

import application.impostazioni.Configurazioni;
import application.view.Painter;

public class Mondo {
    public enum Blocco {acqua, nave, nemico, scoglio, proiettile, scia, effetti}
    public final Blocco[][] blocchi;
    private static Mondo mondo;
    private static Nave nave;
    private static Painter painter;
    boolean rotto = false;

    public Mondo() {
        // Creazione matrice
        blocchi = new Blocco[Configurazioni.WORLD_SIZE][Configurazioni.WORLD_SIZE];

        for (int i = 0; i < blocchi.length; i++) {
            for (int j = 0; j < blocchi.length; j++) {
                blocchi[i][j] = Blocco.acqua;
            }
        }

        Posizione posizioneNave = new Posizione(blocchi.length / 2 - 1, blocchi.length / 2 - 1);
        nave = new Nave(posizioneNave);
        blocchi[posizioneNave.getX()][posizioneNave.getY()] = Blocco.nave;
        painter = new Painter(this);
    }

    public Blocco[][] getBlocchi() {
        return blocchi;
    }

    public static Mondo getMondo() {
        if (mondo == null) {
            mondo = new Mondo();
        }
        return mondo;
    }

    public Blocco getContenutoBlocchi(Posizione p) {
        return blocchi[p.getX()][p.getY()];
    }

    public Nave getNave() {
        return nave;
    }

    public void aggiornaMondo(Posizione posCorrente, Posizione p) {
        blocchi[posCorrente.getX()][posCorrente.getY()] = Blocco.acqua;
        blocchi[p.getX()][p.getY()] = Blocco.nave;
        nave.setPosizioneNave(p);
        System.out.println(p.getY() + " " + p.getX());
    }

    public void aggiorna() {
        aggiornaProiettile(Proiettile.getProiettile().getPosProiettile());
        // Aggiorna l'interfaccia grafica
        painter.repaint();
    }

    public void aggiornaProiettile(Posizione p) {
        blocchi[p.getX()][p.getY()] = Blocco.proiettile;
    }

    public void sostituisciConAcqua(Posizione p) {
        blocchi[p.getX()][p.getY()] = Blocco.acqua;
        // Aggiorna l'interfaccia grafica
        painter.repaint();
    }

    public void setRotto(boolean rotto) {
        this.rotto = rotto;
    }

    public boolean isRotto() {
        return rotto;
    }
}
