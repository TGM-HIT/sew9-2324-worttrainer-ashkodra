package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * In dieser Klasse werden das Modell und das View vereint
 */

public class Controller implements ActionListener{
    private Trainer trainer;
    private Ansicht ansicht;
    private Speichern speichern;
    public Controller(){
        speichern = new JSONSpeichern();
        trainer = speichern.laden("speicherung.json");
        ansicht = new Ansicht(this);
        updateAnsicht();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Überprüfen")) {
            trainer.pruefen(ansicht.getEingabe());
            ansicht.resetEingabe();
            updateAnsicht();
        }
        if(e.getActionCommand().equals("exit")) {
            speichern.speichern("speicherung.json",trainer);
            System.exit(0);
        }
    }
    /**
     * updated die View mit aktuellen Werten
     */
    public void updateAnsicht() {
        ansicht.setStatistik(trainer.getStatistikInsgesamt(), trainer.getStatistikRichtig(), trainer.getStatistikFalsch());
        ansicht.setBild(trainer.getCurrentWort().getURL());
        ansicht.setLV(trainer.getLetzterVersuch());
    }

    public static void main(String[] args){
        new Controller();
    }
}
