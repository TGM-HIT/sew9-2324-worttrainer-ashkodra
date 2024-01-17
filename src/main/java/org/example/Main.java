package org.example;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        //erstellen von Test Wörtern
        ArrayList<Wortpaar> list1 = new ArrayList<>();
        list1.add(new Wortpaar("Hund", "https://hund.com"));
        list1.add(new Wortpaar("Katze", "https://katze.com"));
        list1.add(new Wortpaar("Igel", "https://igel.com"));
        list1.add(new Wortpaar("Tiger", "https://tiger.com"));
        list1.add(new Wortpaar("Nashorn", "https://nashorn.com"));
        Trainer rt1 = new Trainer(list1);
        rt1.wortAuswaehlen(1);
        System.out.println(rt1.getCurrentWort().getURL());
        System.out.println(rt1.pruefen("Hund"));
        System.out.println(rt1.pruefen("Katze"));
        rt1.wortAuswaehlen();
        System.out.println(rt1.pruefen("Hund"));
        System.out.println("Gesamt: "+rt1.getStatistikInsgesamt()+" Richtig: "+rt1.getStatistikRichtig() + " Falsch: "+rt1.getStatistikFalsch());

        Ansicht ansicht = new Ansicht();

    }
}