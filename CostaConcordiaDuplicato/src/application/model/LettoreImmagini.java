package application.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LettoreImmagini {
    private static Image acqua;
    private static Image nave;
    public Gioco controller= Gioco.getGioco();
    public Mondo mondo= controller.getMondo();
    private final static String pathAmbientazione= "src/Risorse/ambientazione/";
    private final static String pathNave= "src/risorse/NostraNave/";
    public String getDirezione(){
        int direzioneNave= mondo.getNave().getGiroNave();

        if(direzioneNave==0){
            return "L.png";
        }
        else if(direzioneNave==1){
            return "R.png";
        }
        else if(direzioneNave==2){
            return "UP.png";
        }
        else{
            return "D.png";
        }
    }
    public LettoreImmagini() {
        try {
            lettoreAcqua();
            lettoreNave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void lettoreAcqua() throws IOException {
        acqua= ImageIO.read(new File(pathAmbientazione + "acqua.png"));
    }
    public static Image getAcqua() {
        return acqua;
    }
    private void lettoreNave() throws IOException {
        String direzione= getDirezione();

        nave= ImageIO.read(new File(pathNave + "nostraNave_" + direzione));
        setNave(nave);
    }
    public static void setNave(Image nave) {
        LettoreImmagini.nave = nave;
    }
    public static Image getNave() {
        LettoreImmagini lettoreImmagini= new LettoreImmagini();
        return nave;
    }
}
