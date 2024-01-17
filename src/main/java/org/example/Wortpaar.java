package org.example;
/**
 Ein Wortpaar bestehend aus dem Wort und der dazugehörigen URL des Bildes
 */
public class Wortpaar {
    private String wort;
    private String bildURL;

    public Wortpaar(String wort, String bildURL){
        this.wort = wort;
        this.bildURL = bildURL;
    }

    public String getWort(){
        return this.wort;
    }

    public String getURL(){
        return this.bildURL;
    }

    public void setWort(String wort){
        this.wort = wort;
    }

    public void setURL(String bildURL){
        this.bildURL = bildURL;
    }
}
