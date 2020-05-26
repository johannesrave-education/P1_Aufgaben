import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * P1_LE02
 * @author Johannes Rave, Medieninformatik
 * @version 1.1 20.4.2020
 */

public class HelloGUI extends JFrame {

    /*
    Falls ich es mit der Veränderung des Beispielcodes aus LE02 übertrieben haben sollte,
    tut mir das leid. Ich hatte versucht, den Schriftzug immer zentral im Panel zu Zeichnen,
    und kam dann beim Rumspielen mit paint und dem JButton vom Hundersten ins Tausendste.
    */

    /**
     * Ruft ein GUI mit einem Button auf.
     * Ein GUI wird erstellt, an dessen unteren Ende ein JButton dargestellt wird.
     * Mit einem Klick auf den Button am unteren Rand kann das GUI geschlossen
     * und das Programm terminiert  werden.
     *
     *
     *
     * @param title Dieser String wird in der Titelzeile des GUI dargestellt.
     */
    public HelloGUI (String title) {

        // Der Titel wird in der Titelzeile des GUI dargestellt.
        super(title);

        // Erstellen eines JButtons
        JButton bigButton = new JButton("Goodbye World.");

        // Das Programm wird mit dem Button beendet
        bigButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Application terminated by clicking the big button.");
                System.exit(0);
            }
        });

        // Der Button wird auf dem JPanel positioniert und dieses gezeichnet
        getContentPane().add("South", bigButton);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Stellt einen zentrierten eingerahmten Schriftzug im aktuellen Panel dar.
     * Anhand der Größe eines Strings wird er optisch im Zentrum des aktuellen Panels
     * positioniert und dann doppelt gerahmt. Durch Veränderung der Schriftart und
     * der variable frameFactor können die Größe der Schrift und des Rahmens angepasst werden.
     * @param g Der aktuelle Grafikkontext
     */
    public void paint (Graphics g) {

        // Hintergrund des JPanels
        Dimension size = getSize();
        g.setColor(getBackground());
        g.fillRect(0,0, size.width, size.height);
        g.setColor(getForeground());

        // Definition der Schrift im JPanel
        Font strFont = new Font ("Dialog", Font.BOLD, 20);
        g.setFont(strFont);
        String str = "Hello World!";

        // Ausmessen und Positionieren des Strings in der Mitte des Panels
        FontMetrics fontMetrics = getFontMetrics(strFont);
        int sWidth = fontMetrics.stringWidth(str);
        int sHeight = fontMetrics.getHeight();
        int sX = size.width/2 - sWidth/2;
        int sY = size.height/2 + (sHeight * 3/8); // Bruch bei 3/8 um auf eine int für die Pixelposition zu kommen
        g.drawString(str, sX, sY);

        // Positionieren eines Rahmens um den String
        float frameFactor = 1.2f;
        int rectWidth = (int) (sWidth * frameFactor);
        int rectHeight = (int) (sHeight * frameFactor);
        int rectX = size.width/2 - rectWidth/2;
        int rectY = size.height/2 - rectHeight/2;
        g.drawRect(rectX, rectY, rectWidth, rectHeight); // Innerer Rahmen
        g.drawRect(rectX - 5, rectY - 5, rectWidth + 10, rectHeight + 10); // Äusserer Rahmen

    }

    public static void main (String args[]){
        new HelloGUI("Hello World!");
    }
}