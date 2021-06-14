/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rocket Bunny
 */
public class RobotInfo {
    
    private String name;
    private int x;
    private int y;
    private double health = 100.0;
    private RobotControl rbc;
    
    
    //Set robot name
    public void setname(String nam)
    {
        this.name = nam;
    }
    
    //set robot X cordinate
    public void setx(int m_x)
    {
        this.x = m_x;
    }
    
    //set robot Y cordinate
    public void sety(int m_y)
    {
        this.y = m_y;
    }
    
    //set robot Health
    public void sethealth(double m_h)
    {
        this.health = m_h;
    }
    
    //Returns the robot name
    public String getname()
    {
        return this.name;
    }
    
    //returns robot X cordinate
    public int getx()
    {
        return this.x;
    }
    
    //returns robot Y cordinate
    public int gety()
    {
        return this.y;
    }
    
    //returns robot health
    public double gethealth()
    {
        return this.health;
    }
}
