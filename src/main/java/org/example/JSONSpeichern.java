package org.example;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.*;


public class JSONSpeichern implements Speichern{
    /**
     * Diese Methode speichert ein Trainer-Objekt als JSON-Datei.
     * @param file Der Dateiname, unter dem das Objekt gespeichert werden soll.
     * @param trainer Das Trainer-Objekt, das gespeichert werden soll.
     */
    @Override
    public void speichern(String file, Trainer trainer) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(trainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode lädt ein Trainer-Objekt aus einer JSON-Datei.
     * @param file Der Dateiname, aus dem das Objekt geladen werden soll.
     * @return Das geladene Trainer-Objekt oder ein neues leeres Objekt, wenn ein Fehler auftritt.
     */
    @Override
    public Trainer laden(String file) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, Trainer.class);
        } catch (IOException e) {
            return loadStandard();
        }
    }
    public Trainer loadStandard(){
        ArrayList<Wortpaar> list1 = new ArrayList<>();
        list1.add(new Wortpaar("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzgEm_MjA9eqoV809zbQlj55J7EAbgkKa88w&usqp=CAU"));
        list1.add(new Wortpaar("Katze", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSPZg0wpV559fZWigYRxg062ovQjaJKqzbuQ&usqp=CAU"));
        list1.add(new Wortpaar("Adler", "https://img.welt.de/img/kmpkt/mobile192014671/6652505967-ci102l-w1024/Bald-Eagle-spreading-wings.jpg"));
        list1.add(new Wortpaar("Tiger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaB9_92ofm5aFLpe2UL4hmHwrmA_LAXlHHFg&usqp=CAU"));
        list1.add(new Wortpaar("Löwe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQldi33KDlqHkY1r7lpj2sRZvOezcecu8VbNQ&usqp=CAU"));

        Trainer rt1 = new Trainer(list1);

        rt1.wortAuswaehlen();
        return rt1;
    }

}
