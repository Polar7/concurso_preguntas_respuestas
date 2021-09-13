package view;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel con diversas opciones
 * @author Jean Michael Lozano Cardoso
 */
public class PanelOptions extends JPanel implements ActionListener
{
    /**
     * Comando nuevo juego
     */
    private static final String NEW_GAME = "New game";

    /**
     * Comando retirarse del concurso
     */
    private static final String BACKING_OUT = "Backing out";

    /**
     * Comando acerca de
     */
    private static final String ABOUT = "About";

    /**
     * Botones de nuevo juego, retirse, guardar en BD y acerca de
     */
    private JButton btnNewGame, btnBackingOut, btnAbout;


    /**
     * Construye un panel con manejo de opciones
     */
    public PanelOptions()
    {
        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 3 ) );

        btnNewGame = new JButton("Nuevo juego");
        btnNewGame.setActionCommand( NEW_GAME );
        btnNewGame.addActionListener( this );
        add( btnNewGame );

        btnBackingOut = new JButton("Retirarse voluntariamente");
        btnBackingOut.setActionCommand( BACKING_OUT );
        btnBackingOut.addActionListener( this );
        btnBackingOut.setEnabled(false);
        add( btnBackingOut );

        btnAbout = new JButton("Acerca de");
        btnAbout.setActionCommand( ABOUT );
        btnAbout.addActionListener( this );
        add( btnAbout );

    }


    /**
     * Habilita o deshabilita el boton de retirarse voluntariamente
     * @param pEnable Activar o desactivar boton
     */
    public void enableBackingOut(boolean pEnable)
    {
        btnBackingOut.setEnabled(pEnable);
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvent Acción que generó el evento. pEvento != null.
     */
    @Override
    public void actionPerformed(ActionEvent pEvent)
    {
        switch (pEvent.getActionCommand()) {
            case NEW_GAME -> MainController.getInstance().newGame();
            case BACKING_OUT -> MainController.getInstance().backingOut();
            case ABOUT -> MainController.getInstance().about();
        }
    }
}
