import greenfoot.util.GraphicsUtilities;
import java.awt.Font;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Label class that allows you to display a textual value on screen.
 * 
 * The Label is an actor, so you will need to create it, and then add it to the world
 * in Greenfoot.  If you keep a reference to the Label then you can change the text it
 * displays.  
 *
 * @author Amjad Altadmri 
 * @version 1.1
 */
public class Label extends Actor
{
    private String value;
    private int fontSize;
    private boolean wrap;
    private int wrapWidth;
    private int roomWidth = 600;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    
    private static final Color transparent = new Color(0,0,0,0);

    
    /**
     * Create a new label, initialise it with the int value to be shown and the font size 
     */
    public Label(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize, false);
    }
    
    /**
     * Create a new label, initialise it with the needed text and the font size 
     */
    public Label(String value, int fontSize)
    {
        this(value, fontSize, false);
    }

    public Label(int value, int fontSize, boolean wrap)
    {
        this(Integer.toString(value), fontSize, wrap);
    }

    public Label(String value, int fontSize, boolean wrap)
    {
        this.value = value;
        this.fontSize = fontSize;
        this.wrap = wrap;
        updateImage();
    }

    /**
     * Sets the value  as text
     * 
     * @param value the text to be show
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    /**
     * Sets the value as integer
     * 
     * @param value the value to be show
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    /**
     * Sets the line color of the text
     * 
     * @param lineColor the line color of the text
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    /**
     * Sets the fill color of the text
     * 
     * @param fillColor the fill color of the text
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    
    
    // Custom implementation to support wrapping
    private void updateImage()
    {
        wrapWidth = (int) Math.round((roomWidth * 2.5) / fontSize);
        String[] lines = GraphicsUtilities.splitLines(value);
        String renderedValue = new String(value);
        if (wrap && lines.length == 1) {
            for (int i = wrapWidth; i < renderedValue.length(); i += wrapWidth) {
                i = renderedValue.lastIndexOf(' ', i);
                if (i == -1)
                    break;
                renderedValue = renderedValue.substring(0, i) + "\n" + renderedValue.substring(i);
                i++;
            }
        }
        setImage(new GreenfootImage(renderedValue, fontSize, fillColor, transparent, lineColor));
    }
}