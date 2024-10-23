import greenfoot.*;
import java.util.*;

public class HighScoreScreen extends World
{
    private ArrayList<String> players = new ArrayList<String>();
    private Map<String, Integer> highScores = new HashMap<String, Integer>();
    private SimpleTimer timer = new SimpleTimer();
    private int index = 0;
    private int score = 100;

    public HighScoreScreen()
    {    
        super(600, 400, 1);
        prepare();
    }

    public void prepare()
    {
        Label title = new Label("High Scores", 50);
        addObject(title, 300, 50);

        highScores.put("Player 1", score);
        highScores.put("Player 2", score + 5);

        int index = 0;
        for (String name : highScores.keySet()) {
            players.add(name);
        }

        timer.mark();
        updateScore();
    }

    public void act()
    {
        // displays a different score every 2 seconds
        if (timer.millisElapsed() > 2000) {
            index = (index + 1) % players.size();
            updateScore();
            timer.mark();
        }
    }

    public void updateScore()
    {
        if (getObjects(Label.class).size() > 1) {
            removeObject(getObjects(Label.class).get(1));
        }

        String currentPlayer = players.get(index);
        Integer currentScore = highScores.get(currentPlayer);
        
        Label scoreLabel = new Label(currentPlayer + ": " + currentScore, 40);
        addObject(scoreLabel, 300, 200);
    }
}