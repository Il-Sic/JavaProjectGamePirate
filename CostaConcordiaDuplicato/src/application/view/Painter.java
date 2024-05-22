package application.view;

import application.impostazioni.Configurazioni;
import application.model.Gioco;
import application.model.LettoreImmagini;
import application.model.Mondo;

import javax.swing.*;
import java.awt.*;

public class Painter extends JPanel {
    private Mondo mondo;
    Gioco controller= Gioco.getGioco();
    public Painter(Mondo mondo){
        this.mondo= mondo;
    }
    public void dipingi(){
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        mondo= controller.getMondo();

        for(int i=0; i<mondo.blocchi.length; i++){
            for(int j=0; j<mondo.blocchi.length; j++) {
                switch (mondo.blocchi[i][j]){
                    case acqua:
                        g.drawImage(LettoreImmagini.getAcqua(), i * Configurazioni.BLOCK_SIZE, j * Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, this);
                        break;
                    case nave:
                        g.drawImage(LettoreImmagini.getAcqua(), i * Configurazioni.BLOCK_SIZE, j * Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, this);
                        g.drawImage(LettoreImmagini.getNave(), i * Configurazioni.BLOCK_SIZE, j * Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, this);
                        break;
                    case proiettile:
                        g.fillOval(i * Configurazioni.BLOCK_SIZE, j * Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE, Configurazioni.BLOCK_SIZE);
                        break;
                }
            }
        }

    }

}
