package model;

import java.io.FileInputStream;
import java.sql.Array;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que moldea el concurso de preguntas y respuestas
 * @author Jean Michael Lozano Cardoso
 */
public class Contest
{

    /**
     * Vector con las preguntas del concurso
     */
    private ArrayList<Question> questions;

    /**
     * Vector con las categorias del concurso
     */
    private ArrayList<Category> categories;

    /**
     * Arreglo con las rondas del concurso
     */
    private Round[] rounds;

    /**
     * Jugador del concurso
     */
    private Player player;

    /**
     * Estado del juego
     */
    private boolean gameOver;



    public Contest()
    {
        questions = new ArrayList<Question>();
        categories = new ArrayList<Category>();

        loadCategories();
        loadQuestions();

        player = null;
        gameOver = false;

        rounds = new Round[Round.NUMBER_OF_ROUNDS];
        rounds[0] = new Round(1, 100, "ROOKIE");
        rounds[1] = new Round(2, 500, "EASY");
        rounds[2] = new Round(3, 1200, "MEDIUM");
        rounds[3] = new Round(4, 2500, "HARD");
        rounds[4] = new Round(5, 7000, "EXTREME");
    }

    /**
     * Devuelve las preguntas del concurso
     * @return la lista con las preguntas del concurso
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Devuelve las categorias del concurso
     * @return las categorias del concurso
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Round[] getRounds() {
        return rounds;
    }

    /**
     * Indica si el concurso se ha terminado
     * @return True si se ha terminado, false de lo contrario
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Cambia el estado del concurso
     * @param gameOver Estado del concurso
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Carga las preguntas de un archivo de propiedades
     */
    private void loadQuestions()
    {
        Properties questionsProperties = new Properties();

        try
        {
            questionsProperties.load(new FileInputStream("data/questions.properties"));

            int quantity = Integer.parseInt(questionsProperties.getProperty("quantity"));

            for (int i = 1; i <= quantity; i++)
            {
                String nameCategory = questionsProperties.getProperty("category" + i);
                String sentence = questionsProperties.getProperty("sentence" + i);
                String correctAnswer = questionsProperties.getProperty("correct" + i);;
                Category category = searchCategoryByName(nameCategory);

                Question question = new Question(i, category, sentence, correctAnswer );
                questions.add(question);
                question.loadAnswers();
            }

            System.out.println("Successful creation of questions");

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Carga las categorias de un archivo de propiedades
     */
    private void loadCategories()
    {
        Properties categoriesProperties = new Properties();

        try
        {
            categoriesProperties.load(new FileInputStream("data/categories.properties"));

            int quantity = Integer.parseInt(categoriesProperties.getProperty("quantity"));

            for (int i = 1; i <= quantity; i++)
            {
                String nameCategory = categoriesProperties.getProperty("name" + i);
                String difficultyCategory = categoriesProperties.getProperty("difficulty" + i);

                categories.add(new Category(nameCategory, difficultyCategory));
            }

            System.out.println("Successful creation of categories");

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Devuelve una categoria dada su nombre por parametro
     * <b> pre: </b> La lista de categorias ha sido inicializada.
     * @param pName Nombre de la categoria a buscar
     * @return La categoria encontrada, null si no existe ninguna con ese nombre
     */
    public Category searchCategoryByName(String pName)
    {
        Category categoryFind = null;

        for (Category category : categories)
        {
            if (category.getName().equals(pName))
            {
                categoryFind = category;
            }
        }

        return categoryFind;
    }

    /**
     * Devuelve una lista de preguntas que tengan la dificultad dada por parametro
     * <b> pre: </b> La lista de preguntas ha sido inicializada.
     * @param pDifficulty - Dificultad de la ronda
     * @return La preguntas disponibles en la ronda
     */
    public ArrayList<Question> questionsAvailablePerRound(String pDifficulty)
    {
        ArrayList<Question> questionsAvailable = new ArrayList<Question>();

        for (Question question : questions) {
            if (question.getCategory().getDifficulty().equals(pDifficulty))
            {
                questionsAvailable.add(question);
            }
        }
        return questionsAvailable;
    }

    public void createPlayer(String pName)
    {
        player = new Player(pName);
    }

    /**
     * Devuelve un mensaje con los datos del credador del juego
     * @return Mensaje sobre el creador del juego
     */
    public String about()
    {
        return "Juego creado por:\n" + "Jean Michael Lozano Cardoso";
    }

}
