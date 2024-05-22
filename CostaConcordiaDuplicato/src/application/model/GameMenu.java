package application.model;

import application.view.TestFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame implements ActionListener          // ho usato ActionListener per la ricezione nell' interfaccia degli eventi
{
    public GameMenu()
    {
        setTitle("Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel menuPanel = createMenuPanel();
        add(menuPanel);
    }

    // Vorrei creare una funzione che crea i bottoni con le immagini che abbiamo (da implementare)
    private JButton createButton()
    {
        ImageIcon icon = new ImageIcon("risorse/Menu/bottone.png");
        JButton button = new JButton(icon);
        button.setContentAreaFilled(false);                                     // Rende il pulsante trasparente
        button.setBorderPainted(false);                                         // Rimuove i bordi del pulsante
        button.setFocusPainted(false);                                          // Rimuove il punto di focus del pulsante
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
    private JPanel createMenuPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));           // Ho usato Arial per provare
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton playButton = new JButton ("Avvia");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(this);

        JButton optionsButton = new JButton("Opzioni");
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.addActionListener(this);

        JButton exitButton = new JButton("Esci");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(this);

        // per gli spazi
        panel.add(Box.createVerticalStrut(50));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(playButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(optionsButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exitButton);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)              // per la gestione degli eventi della pressione dei bottoni
    {
        String comando = e.getActionCommand();

        switch (comando)
        {
            case "Avvia":
                // Avvia il gioco
                try
                {
                    startGame();
                }
                catch (Exception ex)
                {
                    throw new RuntimeException(ex);
                }
                break;

            case "Opzioni":
                JOptionPane.showMessageDialog(this, "I pirati sono belli ma bastardi :)");
                break;

            case "Esci":
                System.exit(0);
                break;
        }
    }

    private void startGame() throws Exception
    {
        dispose();

        // Avvia il gioco (Prima era nella classe Main)
        TestFrame.lancia();
    }
}


