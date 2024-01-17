package org.example;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        //erstellen von Test Wörtern
        ArrayList<Wortpaar> list1 = new ArrayList<>();

        list1.add(new Wortpaar("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzgEm_MjA9eqoV809zbQlj55J7EAbgkKa88w&usqp=CAU"));
        list1.add(new Wortpaar("Katze", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSPZg0wpV559fZWigYRxg062ovQjaJKqzbuQ&usqp=CAU"));
        list1.add(new Wortpaar("Adler", "https://img.welt.de/img/kmpkt/mobile192014671/6652505967-ci102l-w1024/Bald-Eagle-spreading-wings.jpg"));
        list1.add(new Wortpaar("Tiger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaB9_92ofm5aFLpe2UL4hmHwrmA_LAXlHHFg&usqp=CAU"));
        list1.add(new Wortpaar("Loewe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQldi33KDlqHkY1r7lpj2sRZvOezcecu8VbNQ&usqp=CAU"));

        Trainer rt1 = new Trainer(list1);
        rt1.wortAuswaehlen();

        //Ansicht ansicht = new Ansicht();
        Speichern speichern = new JSONSpeichern();
        speichern.speichern("speicherung.json", rt1);

    }
}