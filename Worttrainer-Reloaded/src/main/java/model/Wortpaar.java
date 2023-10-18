package model;

public class Wortpaar {

    private String wort;
    private String bildURL;

    public Wortpaar(String wort, String bildURL){
        this.wort=wort;
        this.bildURL=bildURL;
    }
    public void setWort(String wort){
        this.wort=wort;
    }
    public void setURL(String bildURL){
        this.bildURL=bildURL;
    }
    public String getWort() {
        return wort;
    }

    public String getBildURL() {
        return bildURL;
    }
}
