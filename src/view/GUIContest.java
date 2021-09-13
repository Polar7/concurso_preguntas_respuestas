package view;

import javax.swing.*;
import java.awt.*;

/**
 * GUI principal del concurso
 * @author Jean Michael Lozano Cardoso
 */
public class GUIContest extends JFrame
{
    /**
     * Panel del banner
     */
    private PanelBanner panelBanner;

    /**
     * Panel de informacion
     */
    private PanelInformation panelInformation;

    /**
     * Panel de opciones
     */
    private PanelOptions panelOptions;

    /**
     * Panel de las preguntas
     */
    private PanelQuestion panelQuestion;

    public GUIContest()
    {
        setTitle( "Concurso Preguntas y Respuestas" );
        setSize( 900, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );
        setLocationRelativeTo( null );
        setLayout(new BorderLayout());

        panelBanner = new PanelBanner();
        panelInformation = new PanelInformation();
        panelQuestion = new PanelQuestion();
        panelOptions = new PanelOptions();


        add(panelBanner, BorderLayout.NORTH);
        add(panelInformation, BorderLayout.WEST);
        add(panelQuestion, BorderLayout.CENTER);
        add(panelOptions, BorderLayout.SOUTH);


        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch( Exception e )
        {
            e.printStackTrace( );
        }
        setVisible(true);
    }

    public PanelOptions getPanelOptions()
    {
        return panelOptions;
    }

    public PanelInformation getPanelInformation()
    {
        return panelInformation;
    }

    public PanelQuestion getPanelQuestion() {
        return panelQuestion;
    }

    public void showAbout(String pMensaje)
    {
        JOptionPane.showMessageDialog(null, pMensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessageWinnerOrLoser(String pMensaje)
    {
        JOptionPane.showMessageDialog(null, pMensaje, "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
    }
}
