package org.example;

public interface Speichern {
    public void speichern(String file, Trainer trainer);
    public Trainer laden(String file);
}
