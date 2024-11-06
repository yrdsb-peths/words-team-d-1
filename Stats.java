import greenfoot.*;
public class Stats extends Actor
{
    private Label cpmLabel;
    private Label accLabel;
    private Label rawLabel;
    private Label completionLabel;
    private Label timeLabel;
    
    public Stats(int timeInSec, int charsTyped, int charsWrong, int paragraphLength)
    {
        setImage((GreenfootImage) null);
        cpmLabel = new Label("", 50);
        rawLabel = new Label("", 50);
        accLabel = new Label("", 50);
        completionLabel = new Label("Time: " + timeInSec + "s", 50);
        timeLabel = new Label("Time: " + timeInSec + "s", 50);
        updateStats(timeInSec, charsTyped, charsWrong, paragraphLength);
    }

    public void addedToWorld(World world) {
        world.addObject(cpmLabel, 300, 50);
        world.addObject(rawLabel, 300, 50 + 75);
        world.addObject(accLabel, 300, 50 + 150);
        world.addObject(completionLabel, 300, 50 + 225);
        world.addObject(timeLabel, 300, 50 + 300);
    }
    
    public int getCpm(int timeInSec, int charsTyped, int charsWrong)
    {
        return Math.max((int) (((double) (charsTyped - charsWrong) / timeInSec) * 60), 0);
    }
    
    public int getRaw(int timeInSec, int totalChars)
    {
        return totalChars / timeInSec * 60;
    }

    public double getAcc(int charsTyped, int charsWrong)
    {
        return (double) charsTyped / (charsTyped + charsWrong) * 100;
    }

    public double getCom(int charsTyped, int paragraphLength) {
        return (double) charsTyped / paragraphLength * 100;
    }

    public void updateStats(int timeInSec, int charsTyped, int charsWrong, int paragraphLength)
    {
        int cpm = getCpm(timeInSec, charsTyped, charsWrong);
        int raw = getRaw(timeInSec, charsTyped + charsWrong);
        double accuracy = getAcc(charsTyped, charsWrong);
        double completion = getCom(charsTyped, paragraphLength);

        cpmLabel.setValue("CPM: " + cpm);
        rawLabel.setValue("Raw CPM: " + raw);
        accLabel.setValue("Accuracy: " + String.format("%.2f", accuracy) + "%");
        completionLabel.setValue("Completion: " + String.format("%.2f", completion) + "%");
        HighScoreManager.updateHighScores(cpm, raw, accuracy);
    }
}