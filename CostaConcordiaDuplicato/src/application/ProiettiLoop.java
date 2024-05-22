package application;

import application.model.Gioco;
import application.model.Mondo;
import application.model.Posizione;
import application.model.Proiettile;

public class ProiettiLoop extends Thread {
    private Posizione p;
    private Gioco controller = Gioco.getGioco();
    private Mondo mondo = controller.getMondo();
    private Proiettile proiettile;

    public ProiettiLoop(Proiettile proiettile) {
        this.proiettile = proiettile;
        this.p = proiettile.getPosProiettile();
    }

    @Override
    public void run() {
        try {
            // Simula il movimento del proiettile
            for (int i = 0; i < 10; i++) { // Esegui 10 movimenti (ad esempio)
                muoviProiettile();
                mondo.aggiorna(); // Aggiorna l'interfaccia grafica, se applicabile
                Thread.sleep(200); // Attendi 200ms tra ogni movimento
            }

            // Attende 2 secondi dopo l'ultimo movimento
            Thread.sleep(2000);

            // Sostituisce il proiettile con l'acqua
            mondo.sostituisciConAcqua(p);

            // Aggiorna l'interfaccia grafica, se necessario
            mondo.aggiorna();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void muoviProiettile() {
        int px = p.getX();
        int py = p.getY();
        Posizione nuovaPosizione = null;

        switch (proiettile.giroNave) {
            case 0 -> nuovaPosizione = new Posizione(px, py + 1); // punta sx
            case 1 -> nuovaPosizione = new Posizione(px, py - 1); // punta dx
            case 2 -> nuovaPosizione = new Posizione(px - 1, py); // punta up
            case 3 -> nuovaPosizione = new Posizione(px + 1, py); // punta down
        }

        // Aggiorna la posizione del proiettile nel mondo
        mondo.blocchi[p.getX()][p.getY()] = Mondo.Blocco.acqua; // Libera la vecchia posizione
        p = nuovaPosizione;
        proiettile.setPosProiettile(p);
        mondo.blocchi[p.getX()][p.getY()] = Mondo.Blocco.proiettile; // Imposta la nuova posizione
    }

    public static void main(String[] args) {
        // Crea una posizione di esempio
        Posizione p = new Posizione(5, 5); // Sostituisci con la posizione effettiva del proiettile
        Proiettile proiettile = new Proiettile(p, 0, 0); // Crea un nuovo proiettile di esempio
        ProiettiLoop oggetto = new ProiettiLoop(proiettile);
        oggetto.start();
    }
}
