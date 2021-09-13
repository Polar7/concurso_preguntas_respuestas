package view;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel que contiene las preguntas y sus posibles respuestas
 */
public class PanelQuestion extends JPanel implements ActionListener
{

    public static final String CHECH_ANSWER = "Check answer";

    /**
     * Campo de texto donde está ubicada la pregunta
     */
    private JTextField txtSentence;

    /**
     * Botones de opcion para las posibles respuestas
     */
    private JRadioButton optionA, optionB, optionC, optionD;

    /**
     * Boton para verificar repuesta
     */
    private JButton btnCheck;

    /**
     * Muestra la pregunta y sus posibles respuestas
     */
    public PanelQuestion()
    {
        setBorder( new TitledBorder( "Pregunta" ) );
        setLayout(new BorderLayout());

        txtSentence = new JTextField();
        txtSentence.setEnabled(false);
        txtSentence.setFont(new Font("Agency FB", Font.BOLD, 25));
        txtSentence.setHorizontalAlignment(SwingConstants.CENTER);

        optionA = new JRadioButton();
        optionA.setEnabled(false);
        optionB = new JRadioButton();
        optionB.setEnabled(false);
        optionC = new JRadioButton();
        optionC.setEnabled(false);
        optionD = new JRadioButton();
        optionD.setEnabled(false);

        btnCheck = new JButton("Verificar respuesta");
        btnCheck.setActionCommand( CHECH_ANSWER );
        btnCheck.addActionListener( this );
        btnCheck.setEnabled(false);

        ButtonGroup groupOptions = new ButtonGroup();
        groupOptions.add(optionA);
        groupOptions.add(optionB);
        groupOptions.add(optionC);
        groupOptions.add(optionD);

        JPanel panelAnswers = new JPanel();
        panelAnswers.setBorder( new TitledBorder( "Respuestas" ) );
        panelAnswers.setLayout(new GridLayout(4,1));

        panelAnswers.add(optionA);
        panelAnswers.add(optionB);
        panelAnswers.add(optionC);
        panelAnswers.add(optionD);

        add(txtSentence, BorderLayout.NORTH);
        add(panelAnswers, BorderLayout.CENTER);
        add(btnCheck, BorderLayout.SOUTH);
    }


    /**
     * Actualiza la pregunta
     * @param pSentence La nueva pregunta
     */
    public void upgradeSentence(String pSentence)
    {
        txtSentence.setText(pSentence);
    }

    /**
     * Actualiza las posibles repsuestas
     * @param pOptionA
     * @param pOptionB
     * @param pOptionC
     * @param pOptionD
     */
    public void upgradeOptions(String pOptionA, String pOptionB, String pOptionC, String pOptionD)
    {
        optionA.setText(pOptionA);
        optionB.setText(pOptionB);
        optionC.setText(pOptionC);
        optionD.setText(pOptionD);
    }

    /**
     * Retorna la respuesta escogida por el jugador
     * @return La respuesta escogida por el jugador
     */
    public String checkAnswer()
    {
        String returnAnswer = "";
        if(optionA.isSelected())
        {
            returnAnswer = optionA.getText();
        }
        else if(optionB.isSelected())
        {
            returnAnswer = optionB.getText();
        }
        else if(optionC.isSelected())
        {
            returnAnswer = optionC.getText();
        }
        else
        {
            returnAnswer = optionD.getText();
        }
        return returnAnswer;
    }

    /**
     * Habilita o desactiva los botones de las opciones y el boton de verificar
     * @param pEnable
     */
    public void enableOptions(boolean pEnable)
    {
        btnCheck.setEnabled(pEnable);
        optionA.setEnabled(pEnable);
        optionB.setEnabled(pEnable);
        optionC.setEnabled(pEnable);
        optionD.setEnabled(pEnable);
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvent Acción que generó el evento. pEvento != null.
     */
    @Override
    public void actionPerformed(ActionEvent pEvent)
    {
        String command = pEvent.getActionCommand( );
        if( command.equals( CHECH_ANSWER ) )
        {
            MainController.getInstance().checkCorrectAnswer();
        }
    }
}
