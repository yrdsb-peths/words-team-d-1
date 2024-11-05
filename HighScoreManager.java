import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Collections;

public class HighScoreManager {
    private ArrayList<Integer> highScores;

    public HighScoreManager() {
        highScores = new ArrayList<>();
    }

    public void addScore(int score) {
        highScores.add(score);
        Collections.sort(highScores, Collections.reverseOrder()); 
        if (highScores.size() > 5) { 
            highScores.remove(highScores.size() - 1);
        }
    }

    public ArrayList<Integer> getHighScores() {
        return highScores;
    }
    
}
