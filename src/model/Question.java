package model;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que moldea una pregunta del concurso
 * @author Jean Michael Lozano Cardoso
 */
public class Question
{

    /**
     * Indice de la pregunta
     */
    private int index;

    /**
     * Categoria de la pregunta
     */
    private Category category;

    /**
     * Enunciado de la pregunta
     */
    private String sentence;

    /**
     * Vector que almacena las posibles respuestas
     */
    private ArrayList<String> answers;

    /**
     * Respuesta correcto de la pregunta
     */
    private String correctAnswer;


    /**
     * Construye una nueva pregunta con sus posibles respuestas, categoria, y respuesta correcta
     * @param pIndex Indice de la pregunta
     * @param pCategory
     * @param pSentence
     * @param pCorrectAnswer
     */
    public Question(int pIndex, Category pCategory, String pSentence, String pCorrectAnswer )
    {
        index = pIndex;
        category = pCategory;
        sentence = pSentence;
        correctAnswer = pCorrectAnswer;
        answers = new ArrayList<String>();
    }

    /**
     * Devuelve el indice de la pregunta
     * @return el indice de la pregunta
     */
    public int getIndex() {
        return index;
    }

    /**
     * Devuelve la categoria de la pregunta
     * @return la categoria de la pregunta
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Devuelve la frase o mocion de la pregunta
     * @return la frase de la pregunta
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Devuelve el listado de posibles respuestas
     * @return El listado de posibles respuestas
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * Devuelve la respuesta correcta de la pregunta
     * @return La respuesta correcta
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void loadAnswers()
    {
        Properties answersProperties = new Properties();

        try
        {
            answersProperties.load(new FileInputStream("data/questions.properties"));

            String answerA = answersProperties.getProperty("a" + index);
            answers.add(answerA);
            String answerB = answersProperties.getProperty("b" + index);
            answers.add(answerB);
            String answerC = answersProperties.getProperty("c" + index);
            answers.add(answerC);
            String answerD = answersProperties.getProperty("d" + index);
            answers.add(answerD);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
