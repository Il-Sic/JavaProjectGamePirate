package application.model;

public class Nave {
    public static Nave nave;
    private  Posizione posizioneNave;
    public int vita= 104;
    public int giroNave=2;
    public boolean affondata;
    public Nave(Posizione p){
        posizioneNave= p;
    }
    public boolean isAffondata(){
        return affondata;
    }
    public void setVita(int vita) {
        this.vita = vita;
    }
    public int getVita() {
        return vita;
    }
    public void setPosizioneNave(Posizione posizioneNave) {
        this.posizioneNave = posizioneNave;
    }
    public Posizione getPosizioneNave() {
        return posizioneNave;
    }
    public void setGiroNave(int giroNave) {
        this.giroNave = giroNave;
    }
    public int getGiroNave() {
        return giroNave;
    }

}
