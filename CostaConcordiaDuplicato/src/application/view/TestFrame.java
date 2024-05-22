package application.view;

import application.controller.ControllerNave;
import application.impostazioni.Configurazioni;
import application.model.Gioco;
import application.model.LettoreImmagini;

import javax.swing.*;

public class TestFrame extends JFrame {
    public static void lancia() {
        JFrame f = new JFrame();
        f.setSize(Configurazioni.WINDOW_SIZE, Configurazioni.WINDOW_SIZE);

        LettoreImmagini leggi = new LettoreImmagini();


        Gioco gioco= new Gioco();
        Painter painter = new Painter(gioco.getMondo());
        f.add(painter);

        f.setUndecorated(true); //Remove title bar

        ControllerNave controllerNave= new ControllerNave(painter);

        painter.addKeyListener(controllerNave);
        painter.setFocusable(true);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

