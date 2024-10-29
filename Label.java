import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import greenfoot.util.GraphicsUtilities;
import java.awt.geom.Rectangle2D;

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
    
    
    // Warning. The following code is a mangled, terrifying mess 
    // ripped straight from Greenfoot's source code and modified
    // to support wrapping and in-text colouring.
    // Viewer discretion is advised.
    private void updateImage()
    {
        wrapWidth = (int) Math.round((roomWidth * 2.5) / fontSize);
        String renderedValue = new String(value);
        if (wrap && value.indexOf('\n') == -1) {
            for (int i = wrapWidth; i < renderedValue.length(); i += wrapWidth) {
                i = renderedValue.lastIndexOf(' ', i);
                if (i == -1)
                    break;
                renderedValue = renderedValue.substring(0, i) + "\n" + renderedValue.substring(i);
                i++;
            }
        }
        
        String[] lines = GraphicsUtilities.splitLines(renderedValue);

        MultiLineStringDimensions d = renderLines(lines, Font.BOLD, fontSize);
        GreenfootImage newImage = new GreenfootImage(d.getWidth(), d.getHeight());

        BufferedImage buffer = newImage.getAwtImage();

        Graphics2D g = (Graphics2D) buffer.getGraphics();
        g.setColor(transparent);
        g.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        Color foreground = fillColor == null ? Color.BLACK : fillColor;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(int i = 0; i < d.lineShapes.length; ++i) {
            g.setColor(foreground);
            g.fill(d.lineShapes[i]);
            if (lineColor != null) {
                g.setColor(lineColor);
                g.draw(d.lineShapes[i]);
            }
        }
        g.dispose();

        setImage(newImage);
    }

    public class MultiLineStringDimensions {
        private Shape[] lineShapes;
        private Dimension overallBounds;

        public MultiLineStringDimensions(int length) {
            this.lineShapes = new Shape[length];
        }

        public int getWidth() {
            return this.overallBounds.width;
        }

        public int getHeight() {
            return this.overallBounds.height;
        }
    }
     
    private MultiLineStringDimensions renderLines(String[] lines, int style, double size)
    {
        BufferedImage image = GraphicsUtilities.createCompatibleTranslucentImage(1, 1);
        MultiLineStringDimensions r = new MultiLineStringDimensions(lines.length);
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setFontOfPixelHeight(g, style, size);
        
        FontRenderContext frc = g.getFontRenderContext();
        Rectangle2D[] lineBounds = new Rectangle2D[lines.length];
        int maxX = 1;
        int y = 0;
        for (int i = 0; i < lines.length;i++) {
            lineBounds[i] = g.getFontMetrics().getStringBounds(lines[i], g);
            maxX = Math.max(maxX, (int)Math.ceil(lineBounds[i].getWidth()));
            y += Math.ceil(lineBounds[i].getHeight());
        }
        y = Math.max(y + 1, 1);
        r.overallBounds = new Dimension(maxX, y);
        
        y = 0;
        for (int i = 0; i < lines.length;i++) {
            AffineTransform translate = AffineTransform.getTranslateInstance((r.overallBounds.getWidth() - lineBounds[i].getWidth()) / 2, y - lineBounds[i].getMinY() /* add on to baseline */);
            r.lineShapes[i] = new TextLayout(!lines[i].isEmpty()? lines[i] : " ", g.getFont(), frc).getOutline(translate);
            y += Math.ceil(lineBounds[i].getHeight());
        }
        
        g.dispose();
        
        return r;
    }

    private static void setFontOfPixelHeight(Graphics2D g, int style, double targetSize)
    {
        Font font = new Font("SansSerif", style, 1);
        
        for (int i = 1; i < targetSize; i++)
        {
            Font bigger = font.deriveFont((float)i);
            g.setFont(bigger);
            if (bigger.getLineMetrics("WBLMNqpyg", g.getFontRenderContext()).getHeight() < targetSize)
                font = bigger;
            else
                break; // Too big; keep previous
        }
        g.setFont(font);
    }
}