import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private SimpleTimer timer30 = new SimpleTimer();
    private SimpleTimer timer60 = new SimpleTimer();
    private boolean timer30Complete = false;
    private boolean timer60Compelete = true;
    
    
    public Timer()
    {
        // begin 30 second timer 
        timer30.mark();
        // begin 60 second timer 
        timer60.mark();
    }
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!timer30Complete && timer30.millisElapsed() >= 30000) {
            timer30Complete = true;
        }
        
        if (!timer60Compelete && timer60.millisElapsed() >= 60000) {
            timer60Compelete = true;
        }
    }
}
