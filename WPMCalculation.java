import greenfoot.*;
public class WPMCalculation extends Actor
{
    private Label wpmLabel;
    private Label accLabel;
    private Label rawLabel;
    private Label timeLabel;
    private double accuracy;

    public WPMCalculation(int timeInSec, int wordsTyped, int wordsWrong)
    {
        setImage((GreenfootImage) null);
        wpmLabel = new Label("", 50);
        rawLabel = new Label("", 50);
        accLabel = new Label("", 50);
        timeLabel = new Label("Time: " + timeInSec + "s", 50);
        updateStats(timeInSec, wordsTyped, wordsWrong);
    }

    public void addedToWorld(World world) {
        world.addObject(wpmLabel, 300, 50);
        world.addObject(rawLabel, 300, 150);
        world.addObject(accLabel, 300, 250);
        world.addObject(timeLabel, 300, 350);
    }
    
    public int getWpm(int timeInSec, int wordsTyped, int wordsWrong)
    {
        return Math.max((int) (((double) (wordsTyped - wordsWrong) / timeInSec) * 60), 0);
    }
    
    public int getRaw(int timeInSec, int wordsTyped)
    {
        return wordsTyped / timeInSec * 60;
    }

    public double getAcc(int wordsTyped, int wordsWrong)
    {
        if (wordsTyped == 0)
            return 0;
        return (double) (wordsTyped - wordsWrong) / wordsTyped * 100;
    }

    public void updateStats(int timeInSec, int wordsTyped, int wordsWrong)
    {
        int wpm = getWpm(timeInSec, wordsTyped, wordsWrong);
        int raw = getRaw(timeInSec, wordsTyped);
        double accuracy = getAcc(wordsTyped, wordsWrong);

        wpmLabel.setValue("WPM: " + wpm);
        rawLabel.setValue("Raw WPM: " + raw);
        accLabel.setValue("Accuracy: " + String.format("%.2f", accuracy) + "%");
    }
}