import greenfoot.*;
import java.util.*;

public class HighScoreScreen extends World
{
    private World home;
    private ArrayList<String> players = new ArrayList<String>();
    private Map<String, Integer> highScores = new HashMap<String, Integer>();
    private SimpleTimer timer = new SimpleTimer();
    private int index = 0;
    private int score = 100;
    private Label backMenuLabel;
    private Label title;
    private Label scoreLabel;

    public HighScoreScreen(World home)
    {    
        super(600, 400, 1);
        this.home = home;
        prepare();

        addObject(new Button(this::backMenu), 100, 370);
        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);    
    }

    public void prepare()
    {
        title = new Label("High Scores", 50);
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
        removeObject(scoreLabel);

        String currentPlayer = players.get(index);
        Integer currentScore = highScores.get(currentPlayer);
        
        scoreLabel = new Label(currentPlayer + ": " + currentScore + " WPM", 40);
        addObject(scoreLabel, 300, 200);
    }
    
    private void backMenu()
    {
        Greenfoot.setWorld(home);
    }
}