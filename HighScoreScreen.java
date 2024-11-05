import greenfoot.*;
import java.util.*;

public class HighScoreScreen extends World
{
    private World home;
    private List<Label> scoreLabels = new ArrayList<>();
    private SimpleTimer timer = new SimpleTimer();
    private int index = 0;
    private Label backLabel;
    private Label title;
    private Label scoreLabel;

    public HighScoreScreen(World home)
    {    
        super(600, 400, 1);
        this.home = home;
        
        setBackground(new GreenfootImage("background.png"));

        addObject(new Button(this::backMenu), 100, 370);
        backLabel = new Label("Back", 20);
        addObject(backLabel, 100, 338);  
        prepare();
    }

    public void prepare()
    {
        title = new Label("High Scores", 50);
        addObject(title, getWidth() / 2, 50);
        displayScores();
    }

    public void displayScores()
    {
        for (Label label : scoreLabels) {
            removeObject(label);
        }
        scoreLabels.clear();

        int bestWPM = HighScoreManager.getBestWPM();
        int bestRawWPM = HighScoreManager.getBestRawWPM();
        double bestAccuracy = HighScoreManager.getBestAccuracy();
        
        Label wpmLabel = new Label("Best WPM: " + bestWPM, 30);
        Label rawWpmLabel = new Label("Best Raw WPM: " + bestRawWPM, 30);
        Label accuracyLabel = new Label("Best Accuracy: " + String.format("%.2f", bestAccuracy) + "%", 30);
        
        addObject(wpmLabel, getWidth() / 2, 100);
        addObject(rawWpmLabel, getWidth() / 2, 150);
        addObject(accuracyLabel, getWidth() / 2, 200);
        
        scoreLabels.add(wpmLabel);
        scoreLabels.add(rawWpmLabel);
        scoreLabels.add(accuracyLabel);
    }
    
    private void backMenu()
    {
        Greenfoot.setWorld(home);
    }
}