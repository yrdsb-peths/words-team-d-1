import greenfoot.*;
public class WPMCalculation extends Actor
{
    private Label wpmLabel;
    private Label accuracyLabel;
    private int wpm;
    private double accuracy;

    public WPMCalculation()
    {
        setImage((GreenfootImage) null);
        wpmLabel = new Label("WPM: " + wpm, 50);
        accuracyLabel = new Label("Accuracy: " + accuracy, 50);
    }

    public void addedToWorld(World world) {
        world.addObject(wpmLabel, 300, 150);
        world.addObject(accuracyLabel, 300, 250);
    }
    
    public int calculateWPM(int wordsTyped, int timeInSec, int wordsWrong)
    {
        return (wordsTyped - wordsWrong) / timeInSec * 60;
    }

    public double calculateAccuracy(int wordsTyped, int wordsWrong)
    {
        return (double) (wordsTyped - wordsWrong)/ wordsTyped * 100;
    }

    public void updateStats(int wordsTyped, int timeInSec, int wordsWrong)
    {
        wpm = calculateWPM(wordsTyped, timeInSec, wordsWrong);
        accuracy = calculateAccuracy(wordsTyped, wordsWrong);

        wpmLabel.setValue("WPM: " + wpm);
        accuracyLabel.setValue("Accuracy: " + String.format("%.2f", accuracy) + "%");
    }
}