
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * A Swing GUI element that displays a grid on which you can draw images, text and lines.
 */
public class SwingArena extends JPanel
{
    // Represents the image to draw. You can modify this to introduce multiple images.
    private static final String IMAGE_FILE = "droid2.png";
    private ImageIcon robot1;

    // The following values are arbitrary, and you may need to modify them according to the 
    // requirements of your application.
    public int gridWidth = 11;
    public int gridHeight = 12;
    private double robotX = 1;
    private double robotY = 3;
    
    private double gridSquareSize; // Auto-calculated
    

    /**
     * Creates a new arena object, loading the robot image.
     */
    public SwingArena()
    {
        // Here's how you get an Image object from an image file (which you provide in the 
        // 'resources/' directory.
        java.net.URL imageURL = getClass().getResource(IMAGE_FILE);
        // You will get an exception here if the specified image file cannot be found.
        
        try
        {
            if(imageURL != null)
            {
                robot1 = new ImageIcon(imageURL);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
    
    
    /**
     * Moves a robot image to a new grid position. This method is a *demonstration* of how you
     * can do such things, and you may want or need to modify it substantially.
     */
    public void setRobotPosition(double x, double y)
    {
        robotX = x;
        robotY = y;
        repaint();
    }
    
    public double getRobotX()
    {
        return robotX;
    }
    
    public double getRobotY()
    {
        return robotY;
    }
    
    public void setRobotX(double num)
    {
        this.robotX = num;
    }
    
    public void setRobotY(double num)
    {
        this.robotY = num;
    }
    
    public int getGridWidth()
    {
        return gridWidth;
    }
    
    public int getGridHeight()
    {
        return gridHeight;
    }
    
    public void setGridWidth(int num)
    {
        this.gridWidth = num;
    }
    
    public void setGridHeight(int num)
    {
        this.gridHeight = num;
    }
    
    Graphics g1;
    private Graphics2D gfx;
    private int robo1x,robo1y,robo1ex,robo1ey;
    private int robo2x,robo2y,robo2ex,robo2ey;
    private int robo3x,robo3y,robo3ex,robo3ey;
    private int finalx,finaly,finalex,finaley;
    

    //Set health label of the relevant robot
    public void sethetalth(Double val,int x,int y)
    {
        drawHealthLabel(gfx, Double.toString(val) ,x, y);
        repaint();
    }

    //set cordinates of two robots ready for firing
    public void setValues1(int x1, int y1, int x2, int y2)
    {
        robo1x = x1;
        robo1y = y1;
        robo2x = x2;
        robo2y = y2;

        finalx = robo1x;
        finaly = robo1y;
        finalex = robo2x;
        finaley = robo2y;
        
        repaint();
    }
    
    //set cordinates of two robots ready for firing
    public void setValues2(int x1, int y1, int x2, int y2)
    {
        robo2x = x1;
        robo2y = y1;
        robo2ex = x2;
        robo2ey = y2;

        finalx = robo2x;
        finaly = robo2y;
        finalex = robo2ex;
        finaley = robo2ey;
        repaint();
    }
    
    //set cordinates of two robots ready for firing
    public void setValues3(int x1, int y1, int x2, int y2)
    {
        robo3x = x1;
        robo3y = y1;
        robo3ex = x2;
        robo3ey = y2;

        finalx = robo3x;
        finaly = robo3y;
        finalex = robo3ex;
        finaley = robo3ey;
        repaint();
    }
    /**
     * This method is called in order to redraw the screen, either because the user is manipulating 
     * the window, OR because you've called 'repaint()'.
     *
     * You will need to modify the last part of this method; specifically the sequence of calls to
     * the other 'draw...()' methods. You shouldn't need to modify anything else about it.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        
        
        g1=g;
        super.paintComponent(g);
        gfx = (Graphics2D) g;
        gfx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                             RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        
        // First, calculate how big each grid cell should be, in pixels. (We do need to do this
        // every time we repaint the arena, because the size can change.)
        gridSquareSize = Math.min(
            (double) getWidth() / (double) gridWidth,
            (double) getHeight() / (double) gridHeight);
            
        int arenaPixelWidth = (int) ((double) gridWidth * gridSquareSize);
        int arenaPixelHeight = (int) ((double) gridHeight * gridSquareSize);
            
            
        // Draw the arena grid lines. This may help for debugging purposes, and just generally
        // to see what's going on.
        gfx.setColor(Color.GRAY);
        gfx.drawRect(0, 0, arenaPixelWidth - 1, arenaPixelHeight - 1); // Outer edge

        for(int gridX = 1; gridX < gridWidth; gridX++) // Internal vertical grid lines
        {
            int x = (int) ((double) gridX * gridSquareSize);
            gfx.drawLine(x, 0, x, arenaPixelHeight);
        }
        
        for(int gridY = 1; gridY < gridHeight; gridY++) // Internal horizontal grid lines
        {
            int y = (int) ((double) gridY * gridSquareSize);
            gfx.drawLine(0, y, arenaPixelWidth, y);
        }

        
        // Invoke helper methods to draw things at the current location.
        // ** You will need to adapt this to the requirements of your application. **
        
        //Displays all three robots in the relevant locations
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            drawImage(gfx, robot1, RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
            drawLabel(gfx, RobotMain.roboarray[i].getname(), RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
            drawHealthLabel(gfx, Double.toString(RobotMain.roboarray[i].gethealth()), RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
        }
        drawLine(gfx, finalx, finaly, finalex, finaley);
    }
    
    //Refreshes the robot locations
    public void UpdateArena()
    {
        super.removeAll();
        Graphics g = g1;
        Graphics2D gfx = (Graphics2D) g;
        gfx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                             RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            drawImage(gfx, robot1, RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
            drawLabel(gfx, RobotMain.roboarray[i].getname(), RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
            drawHealthLabel(gfx, Double.toString(RobotMain.roboarray[i].gethealth()), RobotMain.roboarray[i].getx(), RobotMain.roboarray[i].gety());
        }
        
        repaint();
    }
    
     
    
    
    
    
    
    /** 
     * Draw an image in a specific grid location. *Only* call this from within paintComponent(). 
     *
     * Note that the grid location can be fractional, so that (for instance), you can draw an image 
     * at location (3.5,4), and it will appear on the boundary between grid cells (3,4) and (4,4).
     *     
     * You shouldn't need to modify this method.
     */
    private void drawImage(Graphics2D gfx, ImageIcon icon, double gridX, double gridY)
    {
        // Get the pixel coordinates representing the centre of where the image is to be drawn. 
        double x = (gridX + 0.5) * gridSquareSize;
        double y = (gridY + 0.5) * gridSquareSize;
        
        // We also need to know how "big" to make the image. The image file has a natural width 
        // and height, but that's not necessarily the size we want to draw it on the screen. We 
        // do, however, want to preserve its aspect ratio.
        double fullSizePixelWidth = (double) robot1.getIconWidth();
        double fullSizePixelHeight = (double) robot1.getIconHeight();
        
        double displayedPixelWidth, displayedPixelHeight;
        if(fullSizePixelWidth > fullSizePixelHeight)
        {
            // Here, the image is wider than it is high, so we'll display it such that it's as 
            // wide as a full grid cell, and the height will be set to preserve the aspect 
            // ratio.
            displayedPixelWidth = gridSquareSize;
            displayedPixelHeight = gridSquareSize * fullSizePixelHeight / fullSizePixelWidth;
        }
        else
        {
            // Otherwise, it's the other way around -- full height, and width is set to 
            // preserve the aspect ratio.
            displayedPixelHeight = gridSquareSize;
            displayedPixelWidth = gridSquareSize * fullSizePixelWidth / fullSizePixelHeight;
        }

        // Actually put the image on the screen.
        gfx.drawImage(icon.getImage(), 
            (int) (x - displayedPixelWidth / 2.0),  // Top-left pixel coordinates.
            (int) (y - displayedPixelHeight / 2.0), 
            (int) displayedPixelWidth,              // Size of displayed image.
            (int) displayedPixelHeight, 
            null);
    }
    
    
    /**
     * Displays a string of text underneath a specific grid location. *Only* call this from within 
     * paintComponent(). 
     *
     * You shouldn't need to modify this method.
     */
    private void drawLabel(Graphics2D gfx, String label, double gridX, double gridY)
    {
        gfx.setColor(Color.BLUE);
        FontMetrics fm = gfx.getFontMetrics();
        gfx.drawString(label, 
            (int) ((gridX + 0.5) * gridSquareSize - (double) fm.stringWidth(label) / 2.0), 
            (int) ((gridY + 1.0) * gridSquareSize) + fm.getHeight());
    }
    
    private void drawHealthLabel(Graphics2D gfx, String label, double gridX, double gridY)
    {
        RobotMain.grp2d = gfx;
        gfx.setColor(Color.BLUE);
        FontMetrics fm = gfx.getFontMetrics();
        gfx.drawString(label, 
            (int) ((gridX + 0.5) * gridSquareSize - (double) fm.stringWidth(label) / 2.0), 
            (int) ((gridY + 1.25) * gridSquareSize) + fm.getHeight());
    }
    
    /** 
     * Draws a (slightly clipped) line between two grid coordinates. 
     *
     * You shouldn't need to modify this method.
     */
    public void drawLine(Graphics2D gfx, double gridX1, double gridY1, 
                                          double gridX2, double gridY2)
    {
        gfx.setColor(Color.RED);
        
        // Recalculate the starting coordinate to be one unit closer to the destination, so that it
        // doesn't overlap with any image appearing in the starting grid cell.
        final double radius = 0.0;
        double angle = Math.atan2(gridY2 - gridY1, gridX2 - gridX1);
        double clippedGridX1 = gridX1 + Math.cos(angle) * radius;
        double clippedGridY1 = gridY1 + Math.sin(angle) * radius;
        
        gfx.drawLine((int) ((clippedGridX1 + 0.5) * gridSquareSize), 
                     (int) ((clippedGridY1 + 0.5) * gridSquareSize), 
                     (int) ((gridX2 + 0.5) * gridSquareSize), 
                     (int) ((gridY2 + 0.5) * gridSquareSize));
    }
}
