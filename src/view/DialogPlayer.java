package view;

import com.sun.tools.javac.Main;
import controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo que permite agregar un nuevo jugador al concurso
 */
public class DialogPlayer extends JDialog implements ActionListener
{

    /**
     * Comando agregar jugador
     */
    private static final String ADD = "Add";


    /**
     * Campo de texto para el nombre del jugador
     */
    private JTextField txtNamePlayer;

    /**
     * Boton para agregar al jugador
     */
    private JButton btnAddPlayer;


    /**
     * Construye una ventana de dialogo para agregar un jugador
     */
    public DialogPlayer()
    {
        setLayout( new BorderLayout() );
        setSize( 335, 150 );
        setModal( true );
        setLocationRelativeTo( null );
        setTitle( "Agregar jugador" );

        txtNamePlayer = new JTextField();
        btnAddPlayer = new JButton("Agregar");
        btnAddPlayer.setActionCommand( ADD );
        btnAddPlayer.addActionListener( this );

        JPanel panelData = new JPanel();
        panelData.setLayout(new GridLayout(1,2));

        panelData.add(new JLabel("Nombre del jugador: "));
        panelData.add(txtNamePlayer);

        add(panelData, BorderLayout.CENTER);
        add(btnAddPlayer, BorderLayout.SOUTH);


    }


    /**
     * Manejo de los eventos de los botones.
     * @param pEvent Acción que generó el evento. pEvento != null.
     */
    @Override
    public void actionPerformed(ActionEvent pEvent)
    {
        String command = pEvent.getActionCommand( );
        if( command.equals( ADD ) )
        {
            MainController.getInstance().addPlayer(txtNamePlayer.getText());
            this.dispose( );
        }
    }
}
