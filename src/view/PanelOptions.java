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
     * Comando guardar en base de datos
     */
    private static final String SAVE_IN_DB = "Save in database";

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
    private JButton btnNewGame, btnBackingOut, btnSaveInDB, btnAbout;


    /**
     * Construye un panel con manejo de opciones
     */
    public PanelOptions()
    {
        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 4 ) );

        btnNewGame = new JButton("Nuevo juego");
        btnNewGame.setActionCommand( NEW_GAME );
        btnNewGame.addActionListener( this );
        add( btnNewGame );

        btnBackingOut = new JButton("Retirarse voluntariamente");
        btnBackingOut.setActionCommand( BACKING_OUT );
        btnBackingOut.addActionListener( this );
        btnBackingOut.setEnabled(false);
        add( btnBackingOut );

        btnSaveInDB = new JButton("Guardar resultado en BD");
        btnSaveInDB.setActionCommand( SAVE_IN_DB);
        btnSaveInDB.addActionListener( this );
        btnSaveInDB.setEnabled(false);
        add( btnSaveInDB );

        btnAbout = new JButton("Acerca de");
        btnAbout.setActionCommand( ABOUT );
        btnAbout.addActionListener( this );
        add( btnAbout );

    }


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
            case SAVE_IN_DB -> MainController.getInstance().saveInDataBase();
            case BACKING_OUT -> MainController.getInstance().backingOut();
            case ABOUT -> MainController.getInstance().about();
        }
    }
}
