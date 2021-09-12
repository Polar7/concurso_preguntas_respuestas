package model;

/**
 * Clase que moldea la categoria de una pregunta del concurso
 */
public class Category
{
    /**
     * Dificultad de la categoria
     */
    private String difficulty;

    /**
     * Nombre de la categoria
     */
    private String name;

    /**
     * Construye una nueva categoria
     */
    public Category(String pName, String pDifficulty)
    {
        name = pName;
        difficulty = pDifficulty;
    }

    /**
     * Devuelve la dificultad de la categoria
     * @return La dificultad de la categoria
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Cambia la dificultad de la categoria
     * @param pDifficulty - Dificultad de la categoria. pDifficulty != null y pDifficulty != ""
     */
    public void setDifficulty(String pDifficulty) {
        difficulty = pDifficulty;
    }

    /**
     * Devuelve el nombre de la categoria
     * @return El nombre de la categoria
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre de la categoria
     * @param name - Nombre de la categoria . pName != null y pName != ""
     */
    public void setName(String name) {
        this.name = name;
    }

}
