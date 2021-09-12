package model;

/**
 * Clase que moldea un jugador del concurso
 * @author Jean Michael Lozano Cardoso
 */
public class Player
{
    /**
     * Moldea el nombre del jugador
     */
    private String name;

    /**
     * Cantidad de premios del jugador
     */
    private int rewards;

    /**
     * Indica si el jugador ganó o perdió el concurso
     */
    private boolean winner;

    public Player(String pName)
    {
        name = pName;
        rewards = 0;
        winner = false;
    }

    /**
     * Devuelve el nombre del jugador
     * @return el nombre del jugador
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve las recompensas que lleva el jugador
     * @return las recompensas que lleva el jugador
     */
    public int getRewards() {
        return rewards;
    }

    /**
     * Devuelve si el jugador a ganado el concurso
     * @return True si ha ganado, false de lo contrario
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Cambia el estado de ganador del jugador
     * @param winner Estado del jugador
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
