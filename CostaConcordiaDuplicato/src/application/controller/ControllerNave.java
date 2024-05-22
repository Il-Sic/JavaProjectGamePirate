package application.controller;

import application.model.*;
import application.view.Painter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ScheduledExecutorService;

public class ControllerNave extends KeyAdapter {
    private Painter painter;
    public ControllerNave(Painter painter){
        this.painter= painter;
    }


    public Proiettile proiettile;
    public ControllerProiettile controllerProiettile= new ControllerProiettile();
    public Gioco controller= Gioco.getGioco();
    public Mondo mondo= controller.getMondo();
    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode()==KeyEvent.VK_S){

            proiettile= new Proiettile(mondo.getNave().getPosizioneNave(), mondo.getNave().getGiroNave(), 0);
            controllerProiettile.ridirezioneProiettile(proiettile);

        } else if (e.getKeyCode()==KeyEvent.VK_D) {
            proiettile= new Proiettile(mondo.getNave().getPosizioneNave(), mondo.getNave().getGiroNave(), 1);
            controllerProiettile.ridirezioneProiettile(proiettile);
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        //Mettere controllo se la nave non è affondata

        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            Posizione dirSx= new Posizione(mondo.getNave().getPosizioneNave().getX()-1, mondo.getNave().getPosizioneNave().getY());
            mondo.getNave().setGiroNave(0);
            controller.Play(dirSx);
        }
        else if((e.getKeyCode()==KeyEvent.VK_RIGHT)) {
            Posizione dirDx= new Posizione(mondo.getNave().getPosizioneNave().getX()+1, mondo.getNave().getPosizioneNave().getY());
            mondo.getNave().setGiroNave(1);
            controller.Play(dirDx);
        }
        else if((e.getKeyCode()==KeyEvent.VK_UP)) {
            Posizione dirUp= new Posizione(mondo.getNave().getPosizioneNave().getX(), mondo.getNave().getPosizioneNave().getY()-1);
            mondo.getNave().setGiroNave(2);
            controller.Play(dirUp);
        }
        else if((e.getKeyCode()==KeyEvent.VK_DOWN)) {
            Posizione dirDw= new Posizione(mondo.getNave().getPosizioneNave().getX(), mondo.getNave().getPosizioneNave().getY()+1);
            mondo.getNave().setGiroNave(3);
            controller.Play(dirDw);
        }



        painter.repaint();


    }

}
