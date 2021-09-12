package model;

import java.util.ArrayList;

/**
 * Clase que moldea una ronda del concurso
 */
public class Round
{
    /**
     * Cantidad de rondas en el concurso
     */
    public static final int NUMBER_OF_ROUNDS = 5;

    /**
     * Número de la ronda en la que va el jugador
     */
    private int index;

    /**
     * Lista de preguntas disponibles
     */
    private ArrayList<Question> questionAvailable;

    /**
     * Recompensa que otorga la ronda
     */
    private int prize;

    /**
     * Dificultad de la ronda
     */
    private String difficulty;

    public Round(int index, int prize, String pDifficulty)
    {
        this.index = index;
        this.questionAvailable = new ArrayList<Question>();
        this.prize = prize;
        difficulty = pDifficulty;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Question> getQuestionAvailable() {
        return questionAvailable;
    }

    public int getPrize() {
        return prize;
    }
}
