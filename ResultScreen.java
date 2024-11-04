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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(new GreenfootImage("background.png"));
        
        int wordsTyped = typedText.split(" ").length;     // Count words typed
        int wordsWrong = calculateWordsWrong(typedText, paragraph); // Calculate wrong words
        
        WPMCalculation wpmCalculation = new WPMCalculation();
        addObject(wpmCalculation, 0, 0); // Add off-screen initially
        wpmCalculation.updateStats(wordsTyped, timeInSec, wordsWrong);
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
