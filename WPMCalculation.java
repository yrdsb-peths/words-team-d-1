import greenfoot.*;
public class WPMCalculation extends Actor
{
    private Label wpmLabel;
    private Label accLabel;
    private Label rawLabel;
    private int wpm;
    private int rawWpm;
    private double accuracy;

    public WPMCalculation()
    {
        setImage((GreenfootImage) null);
        wpmLabel = new Label("WPM: " + wpm, 50);
        rawLabel = new Label("Raw WPM: " + rawWpm, 50);
        accLabel = new Label("Accuracy: " + accuracy, 50);
    }

    public void addedToWorld(World world) {
        world.addObject(wpmLabel, 300, 50);
        world.addObject(rawLabel, 300, 150);
        world.addObject(accLabel, 300, 250);
    }
    
    public int getWpm(int timeInSec, int wordsTyped, int wordsWrong)
    {
        return (wordsTyped - wordsWrong) / timeInSec * 60;
    }
    
    public int getRaw(int timeInSec, int wordsTyped)
    {
        return wordsTyped / timeInSec * 60;
    }

    public double getAcc(int wordsTyped, int wordsWrong)
    {
        return (double) (wordsTyped - wordsWrong)/ wordsTyped * 100;
    }

    public void updateStats(int timeInSec, int wordsTyped, int wordsWrong)
    {
        wpm = getWpm(timeInSec, wordsTyped, wordsWrong);
        rawWpm = getRaw(timeInSec, wordsTyped);
        accuracy = getAcc(wordsTyped, wordsWrong);
        
        
        wpmLabel.setValue("WPM: " + wpm);
        rawLabel.setValue("Raw WPM: " + rawWpm);
        accLabel.setValue("Accuracy: " + accuracy + "%");
    }
}