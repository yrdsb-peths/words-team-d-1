import greenfoot.*;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class Typer extends Actor {
    private static HashMap<Character, Character> keyMap;
    private static HashMap<Character, Boolean> pressedKeys;
    private static Random random = new Random();
    private static String currentParagraph;
    private static String typed;
    private static String[] paragraphs = {
        "The stars twinkled overhead as the cool breeze swept across the open field. It was a quiet night, perfect for reflection. The city lights in the distance were a constant reminder of how far the world had come, yet moments like this reminded me of how important it was to slow down and simply breathe. We often get caught up in the rush of daily life, forgetting to pause and appreciate the present moment.",
        "Technology has become an integral part of our daily lives. We rely on it for communication, entertainment, and even work. While it has made many aspects of life easier, it's important to disconnect from time to time and appreciate the simple pleasures that exist without the aid of a screen or device. Taking a break allows us to recharge and reconnect with the world around us, free from constant digital distractions.", 
        "The journey to success is never linear. There are ups and downs, moments of triumph, and periods of doubt. What matters most is persistence. Even when the road seems difficult, those who continue moving forward, learning from failures, and growing through challenges, will eventually reach their goals. Success is not just about talent or luck, but also about resilience and the determination to keep going.", 
        "Learning is a lifelong process, not something that ends after formal education. Every day presents new opportunities to gain knowledge, whether it's through reading, experiencing new things, or interacting with others. Embracing a mindset of curiosity helps foster growth and personal development. The more we engage with the world, the more we expand our understanding of ourselves and the world around us.", 
        "Nature has a unique way of teaching us balance. The changing seasons, the ebb and flow of tides, the cycle of life and death all serve as reminders that everything has its time. Just like nature, we too must learn to adapt, let go of what no longer serves us, and embrace new beginnings with grace. Life's transitions can be challenging, but they also offer opportunities for growth and renewal, if we are open to them.", 
        "Friendship is one of the most valuable gifts in life. True friends stand by you in both good times and bad, offering support, laughter, and comfort. Building and maintaining these relationships requires effort, understanding, and compassion. The reward, however, is a connection that brings meaning and joy to everyday life. Friendship reminds us that we are not alone and that shared experiences enrich our lives.", 
        "Books have the power to transport us to different worlds. Whether it's a fictional universe filled with magic or a historical narrative that brings the past to life, reading opens doors to new perspectives. Through stories, we can explore emotions, ideas, and experiences that shape who we are. Reading allows us to connect with characters and events beyond our reality, enriching our minds and hearts.", 
        "The vastness of the ocean is both awe-inspiring and humbling. Standing on the shore, watching the waves crash against the sand, it's easy to feel small in the grand scheme of things. Yet, there's a sense of peace that comes from knowing we are all part of something larger. The ocean's power and mystery remind us of life's endless possibilities, encouraging us to embrace the unknown with curiosity and courage.", 
        "In a world that moves so quickly, it's important to take moments for self-care. Whether it's a quiet cup of tea in the morning, a walk in nature, or time spent with loved ones, these moments of stillness allow us to recharge and find balance amidst the chaos of everyday life. Self-care is not selfish, but a necessary practice to maintain mental, emotional, and physical well-being, allowing us to be our best selves."
    };

    public Typer() {
        setImage((GreenfootImage) null);
        if (keyMap == null) {
            keyMap = new HashMap<Character, Character>();
            pressedKeys = new HashMap<Character, Boolean>();
            for (char c = 'a'; c <= 'z'; c++)
                mapKeys(c, (char) (c - 32));
            mapKeys('`', '~');
            mapKeys('1', '!');
            mapKeys('2', '@');
            mapKeys('3', '#');
            mapKeys('4', '$');
            mapKeys('5', '%');
            mapKeys('6', '^');
            mapKeys('7', '&');
            mapKeys('8', '*');
            mapKeys('9', '(');
            mapKeys('0', ')');
            mapKeys('-', '_');
            mapKeys('=', '+');
            mapKeys('[', '{');
            mapKeys(']', '}');
            mapKeys('\\', '|');
            mapKeys(';', ':');
            mapKeys('\'', '"');
            mapKeys(',', '<');
            mapKeys('.', '>');
            mapKeys('/', '?');
            mapKeys(' ', ' ');
            mapKeys('\b', '\b');
        }
        randomParagraph();
    }

    private void mapKeys(char lowercase, char uppercase) {
        keyMap.put(lowercase, uppercase);
        pressedKeys.put(lowercase, false);
    }

    public void act() {
        boolean shift = Greenfoot.isKeyDown("shift");
        for (Map.Entry<Character, Character> e : keyMap.entrySet()) {
            String keyName = String.valueOf(e.getKey());
            if (keyName.equals(" "))
                keyName = "space";
            else if (keyName.equals("\b"))
                keyName = "backspace";

            if (Greenfoot.isKeyDown(keyName)) {
                if (!pressedKeys.get(e.getKey())) {
                    if (keyName == "backspace" && typed.length() > 0)
                        typed = typed.substring(0, typed.length() - 1);
                    else
                        typed += shift ? e.getValue() : e.getKey();
                    pressedKeys.put(e.getKey(), true);
                }
            } else
                pressedKeys.put(e.getKey(), false);
        }

        System.out.println(typed);
    }

    public void randomParagraph() {
        typed = "";
        currentParagraph = paragraphs[random.nextInt(paragraphs.length)];
    }

    public String getParagraph() {
        return currentParagraph;
    }

    public String getTyped() {
        return typed;
    }
}
