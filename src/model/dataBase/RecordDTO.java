package model.dataBase;

import java.io.Serializable;

/**
 *
 */
public class RecordDTO implements Dto, Serializable
{
    /**
     * Serializable de la clase
     */
    private static final long serialVersionUID = 568794L;

    /**
     * Nombre del jugador
     */
    private String name_player;

    /**
     * Recompensas del jugador
     */
    private String rewards_player;

    /**
     * Indica si el jugador ganó
     */
    private String isWinner_player;

    public RecordDTO(String name_player, String rewards_player, String isWinner_player)
    {
        this.name_player = name_player;
        this.rewards_player = rewards_player;
        this.isWinner_player = isWinner_player;
    }

    /**
     * Arma una instruccion para agregar un nuevo registro y la retorna
     * @return Instruccion SQL
     */
    @Override
    public String insert()
    {

        String sql = "INSERT INTO public.record(name_player, rewards_player, is_winner_player) VALUES ('"
                + name_player.trim() + "','"
                + rewards_player.trim() + "','"
                + isWinner_player.trim() + "')";
        System.out.println(sql);

        return sql;
    }
}
