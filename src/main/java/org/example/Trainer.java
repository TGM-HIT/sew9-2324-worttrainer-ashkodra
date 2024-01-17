package org.example;
import java.util.ArrayList;
import java.util.Random;
/**
 Ein Trainer hat eine Liste an Wortpaaren.
 Von dieser Klasse kann ein Wortpaar ausgewählt werden und auf richtigkeit überprüft werden
 */
public class Trainer {
    private ArrayList<Wortpaar> woerter;
    private Wortpaar currentWort;
    private int insgesamt = 0;
    private int richtig = 0;
    private int lastTry = 1;

    public Trainer(ArrayList<Wortpaar> woerter){
        this.woerter = woerter;
    }
    /**
     wählt ein Wortpaar aus der Liste aus
     @param index Index des auszuwählendes Wortes
     */
    public void wortAuswaehlen(int index){
        try {
            currentWort = woerter.get(index);
        }catch(Exception e){
        }
    }
    /**
     wählt ein zufälliges Wortpaar aus der Liste aus
     */
    public void wortAuswaehlen(){
        Random random = new Random();
        int index = random.nextInt(woerter.size());
        wortAuswaehlen(index);
    }
    /**
     überprüft ob das übergebene Wort dem aktuellen Wortpaar entspricht
     @param eingabe zu prüfendes Wort
     */
    public boolean pruefen(String eingabe){
        try{
            if(eingabe.equals(currentWort.getWort())){
                currentWort = null;
                insgesamt++;
                richtig++;
                wortAuswaehlen();
                lastTry = 2;
                return true;
            }
            insgesamt++;
            lastTry =3;
            return false;
        }catch(Exception e){
            return false;
        }
    }
    public Wortpaar getCurrentWort() {
        return currentWort;
    }

    public int getStatistikInsgesamt(){
        return insgesamt;
    }

    public int getStatistikRichtig(){
        return richtig;
    }

    public int getStatistikFalsch(){
        return insgesamt-richtig;
    }
    public int getLetzterVersuch() {return lastTry;}
}