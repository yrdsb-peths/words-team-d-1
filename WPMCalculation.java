import greenfoot.*;
public class WPMCalculation extends Actor
{
    private Label wpmLabel;
    private Label accLabel;
    private Label rawLabel;
    private Label timeLabel;

    public WPMCalculation(int timeInSec, int charsTyped, int charsWrong)
    {
        setImage((GreenfootImage) null);
        wpmLabel = new Label("", 50);
        rawLabel = new Label("", 50);
        accLabel = new Label("", 50);
        timeLabel = new Label("Time: " + timeInSec + "s", 50);
        updateStats(timeInSec, charsTyped, charsWrong);
    }

    public void addedToWorld(World world) {
        world.addObject(wpmLabel, 300, 50);
        world.addObject(rawLabel, 300, 150);
        world.addObject(accLabel, 300, 250);
        world.addObject(timeLabel, 300, 350);
    }
    
    public int getWpm(int timeInSec, int charsTyped, int charsWrong)
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

    public void updateStats(int timeInSec, int charsTyped, int charsWrong)
    {
        int wpm = getWpm(timeInSec, charsTyped, charsWrong);
        int raw = getRaw(timeInSec, charsTyped + charsWrong);
        double accuracy = getAcc(charsTyped, charsWrong);

        wpmLabel.setValue("WPM: " + wpm);
        rawLabel.setValue("Raw WPM: " + raw);
        accLabel.setValue("Accuracy: " + String.format("%.2f", accuracy) + "%");
    }
}