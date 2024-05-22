package application.model;

import application.gamestates.Gamestate;

public class Gioco {
    private Mondo mondo;
    private boolean win;
    private static Gioco gioco;
    public Gioco(){
        win = false;
        mondo=new Mondo();
    }
    public void Play(Posizione p){
        Mondo.Blocco contenutoBlocco= mondo.getContenutoBlocchi(p);

        switch (contenutoBlocco){
            case acqua -> {
                Posizione posCorrente= mondo.getNave().getPosizioneNave();
                mondo.aggiornaMondo(posCorrente, p);
            }
        }
    }
    public Mondo getMondo(){
        return mondo;
    }
    public static Gioco getGioco() {
        if(gioco==null){
            gioco= new Gioco();
        }
        return gioco;
    }

    /* update
    public void update ()
    {
        switch (Gamestate.state)
        {
            case GIOCO:

            case MENU:

            default:
                break;
            }
        }
    }*/
}
