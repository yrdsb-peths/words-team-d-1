import greenfoot.*;
public class WPMCalculation extends Actor
{
    private Label wpmLabel;
    private Label accuracyLabel;
    private int totalWordsTyped;
    private int totalMistypedWords;
    private int timeInSeconds;
    private double wpm;
    private double accuracy;

    public WPMCalculation()
    {
        wpmLabel = new Label("WPM: " + wpm, 50);
        accuracyLabel = new Label("Accuracy: " + accuracy, 50);
    }
    
    public int calculateWPM(int wordsTyped, int time, int wordsWrong)
    {
        return (wordsTyped - wordsWrong) / time;
    }

    public int calculateAccuracy(int wordsTyped, int wordsWrong)
    {
        return (wordsTyped - wordsWrong )/ wordsTyped;
    }

    public void addWPM(int x, int y)
    {
        addObject(wpmLabel, x, y);
    }

    public void addAccuracy(int x, int y)
    {
        addObject(accuracyLabel, x, y);
    }
}
