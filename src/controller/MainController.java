package controller;

import model.Contest;
import view.DialogPlayer;
import view.GUIContest;

/**
 * Clase que moldea el controlador de la aplicación
 * @author Jean Michael Lozano Cardoso
 */
public class MainController
{
    /**
     * Guarda la referencia al controlador principal
     */
    private static MainController mainController = null;

    /**
     * Referencia al concurso
     */
    private Contest contest;

    /**
     * Referencia la interfaz grafica principal del concurso
     */
    private GUIContest guiContest;

    /**
     * Construye el controlador principal de la aplicacion recibiendo el mundo y la interfaz grafica como parametros
     * @param pContest Concurso
     * @param pGuiContest GUI del concurso
     */
    private MainController (Contest pContest, GUIContest pGuiContest)
    {
        contest = pContest;
        guiContest = pGuiContest;
    }

    /**
     * Devuelve la refencia del controlador, si no está creada la construye
     * @return La instancia del controlador
     */
    public static MainController getInstance()
    {
        if (mainController == null)
        {
            Contest logic = new Contest();
            GUIContest gui = new GUIContest();
            mainController = new MainController(logic, gui);
        }
        return mainController;
    }

    public void newGame()
    {
        DialogPlayer dialog = new DialogPlayer( );
        dialog.setVisible( true );
    }

    public void saveResultDB()
    {

    }

    public void backingOut()
    {

    }

    /**
     * Muestra la informacion del creador de la aplicacion
     */
    public void about()
    {
         guiContest.showAbout(contest.about());
    }

    /**
     * Añade un jugador al concurso y actualiza la vista con sus datos
     * @param pName - Nombre del jugador
     */
    public void addPlayer(String pName)
    {
        contest.createPlayer(pName);
        guiContest.getPanelInformation().showNamePlayer(contest.getPlayer().getName());
        guiContest.getPanelInformation().upgradeInformation(String.valueOf(contest.getPlayer().getRewards()), String.valueOf(contest.getRounds()[0].getIndex()));
    }

    public void loadQuestionAndAnswers()
    {
        //Integer.parseInt(guiContest.getPanelInformation().getTxtRound().getText());
    }

    /**
     * Metodo principal que inicia la aplicacion
     * @param args En este caso no son necesarios.
     */
    public static void main (String[] args)
    {
        MainController controller = getInstance();
    }
}
