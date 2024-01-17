package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private Trainer trainer;
    private Ansicht ansicht;
    private Speichern speichern;
    public Controller(){
        speichern = new JSONSpeichern();
        trainer = speichern.laden("speicherung.json");
        ansicht = new Ansicht(this);
        updateView();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Überprüfen")) {
            Trainer.pruefen(ansicht.getEingabe());
            ansicht.resetEingabe();
            updateView();
        }
    }

    public void updateView() {
        ansicht.setStatistik(trainer.getStatistikInsgesamt(), trainer.getStatistikRichtig(), trainer.getStatistikFalsch());
        ansicht.setBild(trainer.getCurrentWort().getURL());
    }

    public static void main(String[] args){
        new Controller();
    }
}
