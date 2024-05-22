package application.model;

import java.util.concurrent.ScheduledExecutorService;

public class Proiettile {
    private static Proiettile proiettile;
    private Posizione posProiettile;
    public int giroNave;
    public int direzione;
    public Gioco controller= Gioco.getGioco();
    public Mondo mondo= controller.getMondo();
    public Proiettile(){}
    public Proiettile(Posizione posizioneNave, int giroNave, int direzione) {
        this.posProiettile= posizioneNave;
        this.giroNave= giroNave;
        this.direzione= direzione;

    }
    public static Proiettile getProiettile() {
        if(proiettile==null){
            proiettile= new Proiettile();
        }
        return proiettile;
    }
    public Posizione getPosProiettile() {
        return posProiettile;
    }
    public void setPosProiettile(Posizione posProiettile) {
        this.posProiettile = posProiettile;
    }

}
