package view;

import javax.swing.*;
import java.awt.*;

/**
 * Panel con la imagen del encabezado
 */
public class PanelBanner extends JPanel
{
    /**
     * Label donde va guardada la imagen
     */
    private JLabel lblImage;

    /**
     * Método constructor por defecto. Coloca la imagen del encabezado de la aplicación.
     */
    public PanelBanner ()
    {
        lblImage = new JLabel();
        lblImage.setSize(550,150);

        ImageIcon image = new ImageIcon("data/contestBanner.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
        lblImage.setIcon(icon);

        add(lblImage);
    }
}
