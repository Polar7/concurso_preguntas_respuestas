package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Panel que contiene las preguntas y sus posibles respuestas
 */
public class PanelQuestion extends JPanel
{
    /**
     * Campo de texto donde está ubicada la pregunta
     */
    private JTextField txtSentence;

    /**
     * Botones de opcion para las posibles respuestas
     */
    private JRadioButton optionA, optionB, optionC, optionD;

    /**
     * Botones para verificar repuesta o retirarse voluntariamente
     */
    private JButton btnCheck, btnBackingOut;

    public PanelQuestion()
    {
        setBorder( new TitledBorder( "Pregunta" ) );
        setLayout(new BorderLayout());

        txtSentence = new JTextField();
        txtSentence.setEnabled(false);
        txtSentence.setFont(new Font("Agency FB", Font.BOLD, 25));
        txtSentence.setHorizontalAlignment(SwingConstants.CENTER);

        optionA = new JRadioButton();
        optionA.setText("HOLAA");
        optionB = new JRadioButton();
        optionB.setText("HOLAA");
        optionC = new JRadioButton();
        optionC.setText("HOLAA");
        optionD = new JRadioButton();
        optionD.setText("HOLAA");

        btnCheck = new JButton("Verificar respuesta");

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


    public void upgradeSentente(String pSentence)
    {
        txtSentence.setText(pSentence);
    }

    public void upgradeOptions(String pOptionA, String pOptionB, String pOptionC, String pOptionD)
    {
        optionA.setText(pOptionA);
        optionB.setText(pOptionB);
        optionC.setText(pOptionC);
        optionD.setText(pOptionD);
    }

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


}
