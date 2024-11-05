import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResultScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultScreen extends World
{
    private Label backMenuLabel;
    private Label playAgain;
 
    public ResultScreen(String typedText, String paragraph, int timeInSec)
    {    
        super(600, 400, 1);
        setBackground(new GreenfootImage("background.png"));
        
        String[] stringSplit = typedText.split(" ");
        int wordsTyped = stringSplit.length;
        if (stringSplit[0].equals(""))
            wordsTyped--;
        int wordsWrong = calculateWordsWrong(typedText, paragraph);
        
        WPMCalculation wpmCalculation = new WPMCalculation(timeInSec, wordsTyped, wordsWrong);
        addObject(wpmCalculation, 0, 0);
        
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 500, 370);
        playAgain = new Label("Play again", 20);
        addObject(playAgain, 500, 338);
        
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 100, 370);
        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);
    }
    
    private int calculateWordsWrong(String typedText, String paragraph)
    {
        String[] typedSplit = typedText.split(" ");
        int wordsTyped = typedSplit.length;
        if (typedSplit[0].equals(""))
            wordsTyped--;
        
        String[] paragraphSplit = paragraph.split(" ");
        int paragraphWords = paragraphSplit.length;
        if (paragraphSplit[0].equals(""))
            paragraphWords--;
            
        int wrongWords = 0;
        
        for (int i = 0; i < Math.max(wordsTyped, paragraphWords); i++) {
            if (i >= wordsTyped || i >= paragraphWords || !typedSplit[i].equals(paragraphSplit[i])) {
                wrongWords++;
            }
        }
        
        return wrongWords;
    }
}
