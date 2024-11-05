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
 
    ResultScreen(String typedText, String paragraph, int timeInSec)
    {    
        super(600, 400, 1);
        setBackground(new GreenfootImage("background.png"));
        
        int wordsTyped = typedText.split(" ").length;   
        int wordsWrong = calculateWordsWrong(typedText, paragraph);
        
        WPMCalculation wpmCalculation = new WPMCalculation();
        addObject(wpmCalculation, 0, 0);
        wpmCalculation.updateStats(wordsTyped, timeInSec, wordsWrong);
        
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 500, 370);
        playAgain = new Label("Play again", 20);
        addObject(playAgain, 500, 338);
        
        addObject(new Button(() -> Greenfoot.setWorld(new TimerScreen(this))), 100, 370);
        backMenuLabel = new Label("Back to menu", 20);
        addObject(backMenuLabel, 100, 338);
    }
    
    private int calculateWordsWrong(String typedText, String paragraph)
    {
        String[] typedWords = typedText.split(" ");
        String[] paragraphWords = paragraph.split(" ");
        int wrongWords = 0;
        
        for (int i = 0; i < typedWords.length; i++) {
            if (i >= paragraphWords.length || !typedWords[i].equals(paragraphWords[i])) {
                wrongWords++;
            }
        }
        
        if (typedWords.length > paragraphWords.length) {
            wrongWords += typedWords.length - paragraphWords.length;
        }
        
        return wrongWords;
    }
}
