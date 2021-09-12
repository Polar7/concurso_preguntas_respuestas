package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Panel que contiene informacion del jugador
 * @author Jean Michael Lozano Cardoso
 */
public class PanelInformation extends JPanel
{
    /**
     * Campos de texto para el nombre y premios del jugador, y el numero de ronda en la cual va
     */
    private JTextField txtPlayerName, txtPlayerRewards, txtRound;

    /**
     * Construye el panel con informacion del jugador, los premios que lleva
     * y el numero de la ronda
     */
    public PanelInformation()
    {
        setBorder( new TitledBorder( "Información" ) );
        setLayout(new GridLayout(3,2));

        txtPlayerName = new JTextField();
        txtPlayerName.setEnabled(false);
        txtPlayerName.setFont(new Font("Agency FB", Font.BOLD, 35));
        txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);

        txtPlayerRewards = new JTextField();
        txtPlayerRewards.setEnabled(false);
        txtPlayerRewards.setFont(new Font("Agency FB", Font.BOLD, 35));
        txtPlayerRewards.setHorizontalAlignment(SwingConstants.CENTER);

        txtRound = new JTextField();
        txtRound.setEnabled(false);
        txtRound.setFont(new Font("Agency FB", Font.BOLD, 35));
        txtRound.setHorizontalAlignment(SwingConstants.CENTER);

        add(new JLabel("Nombre del jugador: "));
        add(txtPlayerName);
        add(new JLabel("Premio acumulado: "));
        add(txtPlayerRewards);
        add(new JLabel("Ronda actual: "));
        add(txtRound);
    }

    public JTextField getTxtPlayerName() {
        return txtPlayerName;
    }

    public JTextField getTxtPlayerRewards() {
        return txtPlayerRewards;
    }

    public JTextField getTxtRound() {
        return txtRound;
    }

    /**
     * Actualiza los datos de premios y numero de ronda dados por parametro
     * @param pRewards - Premios que lleva el jugador
     * @param pRound - Ronda que va el jugador
     */
    public void upgradeInformation(String pRewards, String pRound)
    {
        txtPlayerRewards.setText(pRewards);
        txtRound.setText(pRound);
    }

    /**
     * Actualiza el nombre del jugador recibido por parametro
     * @param pName - Nombre del jugador
     */
    public void showNamePlayer(String pName)
    {
        txtPlayerName.setText(pName);
    }
}
