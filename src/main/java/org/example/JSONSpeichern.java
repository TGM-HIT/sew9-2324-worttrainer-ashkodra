package org.example;
import java.io.*;
import java.io.IOException;
import com.google.gson.*;

public class JSONSpeichern implements Speichern{
    @Override
    public void speichern(String file, Trainer trainer) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(trainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Trainer laden(String file) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, Trainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
