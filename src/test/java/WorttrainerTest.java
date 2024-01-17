import org.example.Trainer;
import org.example.Wortpaar;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class WorttrainerTest {
    ArrayList<Wortpaar> list1 = new ArrayList<>();
    Wortpaar wp1;
    Wortpaar wp2;
    Wortpaar wp3;
    Wortpaar wp4;
    Wortpaar wp5;
    Trainer rt1;


    @DisplayName("Testen ob ein Wort ausgewählt wird")
    @Test
    public void testAddPair()   {
        wp1 = new Wortpaar("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzgEm_MjA9eqoV809zbQlj55J7EAbgkKa88w&usqp=CAU");
        list1.add(wp1);
        wp2 = new Wortpaar("Katze", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSPZg0wpV559fZWigYRxg062ovQjaJKqzbuQ&usqp=CAU");
        list1.add(wp2);
        wp3 = new Wortpaar("Adler", "https://img.welt.de/img/kmpkt/mobile192014671/6652505967-ci102l-w1024/Bald-Eagle-spreading-wings.jpg");
        list1.add(wp3);
        wp4 = new Wortpaar("Tiger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaB9_92ofm5aFLpe2UL4hmHwrmA_LAXlHHFg&usqp=CAU");
        list1.add(wp4);
        wp5 = new Wortpaar("Loewe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQldi33KDlqHkY1r7lpj2sRZvOezcecu8VbNQ&usqp=CAU");
        list1.add(wp5);

        rt1 = new Trainer(list1);

        // Ein Wortpaar aus der Liste auswählen.
        rt1.wortAuswaehlen(0);

        // Überprüfen, ob das ausgewählte Wortpaar dem erwarteten entspricht.
        assertEquals(wp1, rt1.getCurrentWort());
    }

    @DisplayName("Testen ob ein zufälliges Wort ausgewählt wird")
    @Test
    public void testWortAuswaehlenRandom() {
        wp1 = new Wortpaar("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzgEm_MjA9eqoV809zbQlj55J7EAbgkKa88w&usqp=CAU");
        list1.add(wp1);
        wp2 = new Wortpaar("Katze", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSPZg0wpV559fZWigYRxg062ovQjaJKqzbuQ&usqp=CAU");
        list1.add(wp2);
        wp3 = new Wortpaar("Adler", "https://img.welt.de/img/kmpkt/mobile192014671/6652505967-ci102l-w1024/Bald-Eagle-spreading-wings.jpg");
        list1.add(wp3);
        wp4 = new Wortpaar("Tiger", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaB9_92ofm5aFLpe2UL4hmHwrmA_LAXlHHFg&usqp=CAU");
        list1.add(wp4);
        wp5 = new Wortpaar("Loewe", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQldi33KDlqHkY1r7lpj2sRZvOezcecu8VbNQ&usqp=CAU");
        list1.add(wp5);

        rt1 = new Trainer(list1);

        // Ein zufälliges Wortpaar aus der Liste auswählen.
        rt1.wortAuswaehlen();

        // Überprüfen, ob das ausgewählte Wortpaar in der Liste enthalten ist.
        assertTrue(list1.contains(rt1.getCurrentWort()));
    }

    @DisplayName("Testen ob prüfen funktioniert")
    @Test
    public void testPruefen() {
        wp1 = new Wortpaar("Hund", "https://th.bing.com/th/id/R.542611eacb5c3972de6a1fecc74de38b?rik=ycZGLnItV7s%2bAQ&riu=http%3a%2f%2fwallpapercave.com%2fwp%2fJgYQiAp.jpg&ehk=fFlqdbVQY9ouK0xw%2bBZMS3nGESR1GRHJOcL1c4M0t5M%3d&risl=&pid=ImgRaw&r=0");
        list1.add(wp1);
        wp2 = new Wortpaar("Katze", "https://th.bing.com/th/id/OIP.M9UpJPCBRKl9U2JKDqJPhgHaEK?pid=ImgDet&rs=1");
        list1.add(wp2);
        wp3 = new Wortpaar("Igel", "https://th.bing.com/th/id/OIP.TfSik2avbGBkvZVtOGlmrAHaE8?pid=ImgDet&rs=1");
        list1.add(wp3);
        wp4 = new Wortpaar("Tiger", "https://th.bing.com/th/id/OIP.MccTUyTQmGwGUDtaeO8A3gHaHa?pid=ImgDet&rs=1");
        list1.add(wp4);
        wp5 = new Wortpaar("Nashorn", "https://img.fotocommunity.com/nashorn-portrait-4122ea52-84e8-419b-9c32-dc2b8cddeaf2.jpg?width=1000");
        list1.add(wp5);

        rt1 = new Trainer(list1);

        // Ein Wortpaar aus der Liste auswählen.
        rt1.wortAuswaehlen(1);

        // Ein richtiges Wort eingeben und überprüfen, ob die Methode true zurückgibt.
        assertTrue(rt1.pruefen("Katze"));

        // Ein Wortpaar aus der Liste auswählen.
        rt1.wortAuswaehlen(2);

        // Ein falsches Wort eingeben und überprüfen, ob die Methode dalse zurückgibt.
        assertFalse(rt1.pruefen("Katze"));

        // Überprüfen, ob die Statistik richtig aktualisiert wurde.
        assertEquals(2, rt1.getStatistikInsgesamt());
        assertEquals(1, rt1.getStatistikRichtig());
        assertEquals(1, rt1.getStatistikFalsch());
    }
}
