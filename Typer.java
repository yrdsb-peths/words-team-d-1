import greenfoot.*;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class Typer extends Actor {
    private static HashMap<Character, Character> keyMap;
    private static Random random = new Random();
    private static String[] paragraphs = {
        "The brown fox jumps over the lazy dog."
    };

    public Typer() {
        if (keyMap == null) {
            keyMap = new HashMap<Character, Character>();
            for (char c = 'a'; c >= 'a' && c <= 'z'; c++)
                keyMap.put(c, (char) (c - 32));
            keyMap.put('`', '~');
            keyMap.put('1', '!');
            keyMap.put('2', '@');
            keyMap.put('3', '#');
            keyMap.put('4', '$');
            keyMap.put('5', '%');
            keyMap.put('6', '^');
            keyMap.put('7', '&');
            keyMap.put('8', '*');
            keyMap.put('9', '(');
            keyMap.put('0', ')');
            keyMap.put('-', '_');
            keyMap.put('=', '+');
            keyMap.put('[', '{');
            keyMap.put(']', '}');
            keyMap.put('\\', '|');
            keyMap.put(';', ':');
            keyMap.put('\'', '"');
            keyMap.put(',', '<');
            keyMap.put('.', '>');
            keyMap.put('/', '?');
        }
    }

    public void act() {
        boolean shift = Greenfoot.isKeyDown("shift");
        for (Map.Entry<Character, Character> e : keyMap.entrySet()) {
            if (Greenfoot.isKeyDown(String.valueOf(e.getKey()))) {
                if (shift)
                    System.out.println(e.getValue());
                else
                    System.out.println(e.getKey());
            }
        }
    }

    public String randomParagraph() {
        return paragraphs[random.nextInt(paragraphs.length)];
    }
}
