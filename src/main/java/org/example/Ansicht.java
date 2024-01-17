package org.example;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionListener;
/**
Die Ansicht des Trainers
 */
public class Ansicht extends JFrame {
    private JLabel imageLabel;
    private JTextField eingabe;
    private JLabel letzterVersuch;
    private JLabel statistik;
    public static final int LV_NONE = 1;
    public static final int LV_RICHTIG = 2;
    public static final int LV_FALSCH = 3;
    public Ansicht(ActionListener ac){
        super("Trainer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        //Hauptpanel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //MittelPanel (beinhaltet Bild, Letzten Versuch und Statistik)
        JPanel midPanel = new JPanel(new BorderLayout());

        //ButtonPanel
        JPanel buttonPanel = new JPanel(new BorderLayout());

        //Bild
        ImageIcon bild;

        try {
            bild = new ImageIcon(new URL("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        imageLabel = new JLabel(bild);
        panel.add(imageLabel, BorderLayout.NORTH);
        midPanel.add(imageLabel, BorderLayout.CENTER);

        //Eingabe Feld
        eingabe = new JTextField();
        panel.add(eingabe, BorderLayout.CENTER);

        //Senden Button
        JButton submit = new JButton("Abschicken");
        submit.setActionCommand("Überprüfen");
        submit.addActionListener(ac);
        buttonPanel.add(submit, BorderLayout.CENTER);

        //Beenden Button
        JButton exit = new JButton("Exit");
        exit.setActionCommand("exit");
        exit.addActionListener(ac);
        buttonPanel.add(exit, BorderLayout.SOUTH);

        //letzer Versuch
        letzterVersuch = new JLabel("Letzter Versuch: ");
        midPanel.add(letzterVersuch, BorderLayout.WEST);

        //Statistik
        statistik = new JLabel("<html>Gesamt: <br/>Richtig: <br/>Falsch: </html>");
        midPanel.add(statistik, BorderLayout.EAST);

        panel.add(midPanel,BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(panel);
        this.setVisible(true);

    }
    /**
     setzt ein neues Bild
     @param url URL des neuen Bildes
     */
    public void setBild(String url){

        try {
            ImageIcon ic = new ImageIcon(new URL(url));
            Image image = ic.getImage ().getScaledInstance (1200, 750, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     setzt den letzten try auf eine von 4 Möglichkeiten
     @param status neuer Status des letzten Versuches
     */
    public void setLV(int status){

        switch (status){
            case LV_NONE:_NONE: letzterVersuch.setText("Erster Versuch");
                break;
            case LV_RICHTIG:RICHTIG: letzterVersuch.setText("<html>Letzter Versuch: <br/>Richtig</html>");
                break;
            case LV_FALSCH: letzterVersuch.setText("<html>Letzter Versuch: <br/>Falsch</html>");
                break;
            default: letzterVersuch.setText("");
        }
    }
    /**
     setzt eine neue Statistik
     @param gesamt Anzahl aller Wörter
     @param richtig Anzahl aller richtigen Wörter
     @param falsch Anzahl aller falschen Wörter
     */
    public void setStatistik(int gesamt, int richtig, int falsch){

        statistik.setText("<html>Gesamt: "+gesamt+"<br/>Richtig: "+richtig+"<br/>Falsch: "+falsch+"</html>");
    }

    public String getEingabe(){
        return eingabe.getText();
    }
    /**
     setzt das Eingabefeld wieder auf leer
     */
    public void resetEingabe() {
        eingabe.setText("");
    }
}
