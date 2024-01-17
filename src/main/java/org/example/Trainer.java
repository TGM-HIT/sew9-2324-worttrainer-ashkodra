package org.example;
import java.util.ArrayList;
import java.util.Random;
public class Trainer {
    private ArrayList<Wortpaar> woerter;
    private Wortpaar currentWort;
    private int insgesamt = 0;
    private int richtig = 0;

    public Trainer(ArrayList<Wortpaar> woerter){
        this.woerter = woerter;
    }
    public void wortAuswaehlen(int index){
        try {
            currentWort = woerter.get(index);
        }catch(Exception e){
        }
    }

    public void wortAuswaehlen(){
        Random random = new Random();
        int index = random.nextInt(woerter.size());
        wortAuswaehlen(index);
    }

    public boolean pruefen(String eingabe){
        try{
            if(eingabe.equals(currentWort.getWort())){
                currentWort = null;
                insgesamt++;
                richtig++;
                wortAuswaehlen();
                return true;
            }
            insgesamt++;
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
}