package controller;

import model.Contest;
import model.Question;
import view.DialogPlayer;
import view.GUIContest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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

    private Question chosenQuestion;

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

    public void backingOut()
    {
        finishGame();
        guiContest.getPanelInformation().paintWinnerOrLoser(Color.YELLOW);
    }

    /**
     * Guarda en la base de datos el nombre del jugador, recompensa reclamada y si ganó o perdió el concurso
     */
    public void saveInDataBase()
    {
        //String namePlayer = contest.getPlayer().getName();
        //int rewardsPlayer = contest.getPlayer().getRewards();
        //String winnerOrLoser = "";
       /*
       if( contest.getPlayer().isWinner() )
        {
           winnerOrLoser = "Ganador";
        }
        else
        {
            winnerOrLoser = "Perdedor";
        }
        */

    }
    /**
     * Muestra la informacion del creador de la aplicacion
     */
    public void about()
    {
         guiContest.showAbout(contest.about());
    }

    /**
     * Añade un jugador al concurso y actualiza la vista con sus datos, adicional muestra una primera pregunta
     * @param pName - Nombre del jugador
     */
    public void addPlayer(String pName)
    {
        contest.createPlayer(pName);
        guiContest.getPanelInformation().showNamePlayer(contest.getPlayer().getName());
        guiContest.getPanelInformation().upgradeInformation(String.valueOf(contest.getPlayer().getRewards()), String.valueOf(contest.getRounds()[0].getIndex()));
        guiContest.getPanelOptions().enableBackingOut(true);
        guiContest.getPanelInformation().paintWinnerOrLoser(Color.WHITE);

        loadQuestionAndAnswers();
    }

    /**
     * Carga una pregunta disponible segun la dificultad de la ronda donde se encuentre
     * Actualiza en la interfaz la pregunta aleatoria y sus posibles respuestas
     */
    public void loadQuestionAndAnswers()
    {
        //Encuentra un listado de las posibles preguntas que pueden salir dependiendo de la ronda en la que se encuentre
        int indexRound = Integer.parseInt(guiContest.getPanelInformation().getTxtRound().getText());
        String difficultyRound = contest.roundPerIndex(indexRound).getDifficulty();
        ArrayList<Question> questions = contest.questionsAvailablePerRound(difficultyRound);

        //Escoge una pregunta aleatoria de las posibles ya listadas, y obtiene sus posibles respuestas
        Random random = new Random();
        int numberQuestion = random.nextInt(questions.size()) + 1;

        chosenQuestion = questions.get(numberQuestion-1);
        ArrayList<String> possibleAnswer = chosenQuestion.getAnswers();

        //Actualiza en la interfaz el texto y posibles respuestas de la pregunta aleatoria
        guiContest.getPanelQuestion().upgradeSentence(chosenQuestion.getSentence());
        guiContest.getPanelQuestion().upgradeOptions(possibleAnswer.get(0), possibleAnswer.get(1), possibleAnswer.get(2), possibleAnswer.get(3) );
        guiContest.getPanelQuestion().enableOptions(true);
    }

    public void checkCorrectAnswer()
    {
        String chosenAnswer = guiContest.getPanelQuestion().checkAnswer();
        if( chosenQuestion.getCorrectAnswer().equals(chosenAnswer) )
        {
            //Verifica si es la ultima ronda
            if(Integer.parseInt(guiContest.getPanelInformation().getTxtRound().getText()) == 5)
            {
                contest.getPlayer().increaseRewards(contest.roundPerIndex(Integer.parseInt(guiContest.getPanelInformation().getTxtRound().getText())).getPrize());
                contest.getPlayer().setWinner(true);
                guiContest.getPanelInformation().paintWinnerOrLoser(Color.GREEN);
                finishGame();
            }
            else
            {
                //Suma los premios y avanza a la siguiente ronda
                contest.getPlayer().increaseRewards(contest.roundPerIndex(Integer.parseInt(guiContest.getPanelInformation().getTxtRound().getText())).getPrize());
                guiContest.getPanelInformation().increaseRound();
                guiContest.getPanelInformation().upgradeInformation(String.valueOf(contest.getPlayer().getRewards()), guiContest.getPanelInformation().getTxtRound().getText());
                //Carga una nueva pregunta
                loadQuestionAndAnswers();
            }

        }
        else
        {
            //Termina el juego
            finishGame();
            contest.getPlayer().loseAll();
            guiContest.getPanelInformation().paintWinnerOrLoser(Color.RED);

        }
    }

    public void finishGame()
    {
        contest.setGameOver(true);
        guiContest.showMessageWinnerOrLoser(contest.messageWinnerOrLoser());
        guiContest.getPanelQuestion().enableOptions(false);
        guiContest.getPanelOptions().enableBackingOut(false);
        saveInDataBase();
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
