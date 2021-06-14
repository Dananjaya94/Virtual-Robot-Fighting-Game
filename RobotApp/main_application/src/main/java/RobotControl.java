/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Dananjaya
 */
public class RobotControl {
    
    RobotInfo rbi;
    boolean mnorth = true;
    boolean meast = true;
    boolean msouth = true;
    boolean mwest = true;
    boolean mfire;
    
    //Returns the RobotInfo object
    public RobotInfo getRobot()
    {
        return rbi;
    }
    
    //Sets a RobotInfo object
    public void setRobot(RobotInfo ri)
    {
        this.rbi = ri;
    }
    
    //Returns an array of RobotInfo Objects
    public RobotInfo[] getAllRobots()
    {
        return RobotMain.roboarray;
    }
    
    //Check if the Robot can move north
    public boolean moveNorth() throws InterruptedException
    {
        mnorth = true;
        
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            if(rbi.getname()!=RobotMain.roboarray[i].getname())
            {
                for(int j=0; j<RobotMain.roboarray.length; j++)
                {
                    if((rbi.getx()==RobotMain.roboarray[j].getx())&&rbi.gety()==RobotMain.roboarray[j].gety())
                    {
                        Thread.sleep(1000);
                    }
                }
            }
        }
        
        if(rbi.gety()!=0)
        {
            rbi.sety(rbi.gety()-1);
            Thread.sleep(1000);
        }
        else
        {
            mnorth = false;
        }
        
        return mnorth;
    }
    
    //Check if the Robot can move East
    public boolean moveEast() throws InterruptedException
    {
        meast = true;
        
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            if(rbi.getname()!=RobotMain.roboarray[i].getname())
            {
                for(int j=0; j<RobotMain.roboarray.length; j++)
                {
                    if((rbi.getx()==RobotMain.roboarray[j].getx())&&rbi.gety()==RobotMain.roboarray[j].gety())
                    {
                        Thread.sleep(1000);
                    }
                }
            }
        }
        
        if(rbi.gety()!=11)
        {
            rbi.sety(rbi.gety()+1);
            Thread.sleep(1000);
        }
        else
        {
            meast = false;
        }
        
        return meast;
    }
    
    //Check if the Robot can move south
    public boolean moveSouth() throws InterruptedException
    {
        msouth = true;
        
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            if(rbi.getname()!=RobotMain.roboarray[i].getname())
            {
                for(int j=0; j<RobotMain.roboarray.length; j++)
                {
                    if((rbi.getx()==RobotMain.roboarray[j].getx())&&rbi.gety()==RobotMain.roboarray[j].gety())
                    {
                        Thread.sleep(1000);
                    }
                }
            }
        }
        
        if(rbi.gety()!=11)
        {
            rbi.sety(rbi.gety()+1);
            Thread.sleep(1000);
        }
        else
        {
            msouth = false;
        }
        return msouth;
    }
    
    //Check if the Robot can move west
    public boolean moveWest() throws InterruptedException
    {
        mwest = true;
        
        for(int i=0; i<RobotMain.roboarray.length; i++)
        {
            if(rbi.getname()!=RobotMain.roboarray[i].getname())
            {
                for(int j=0; j<RobotMain.roboarray.length; j++)
                {
                    if((rbi.getx()==RobotMain.roboarray[j].getx())&&rbi.gety()==RobotMain.roboarray[j].gety())
                    {
                        Thread.sleep(1000);
                    }
                }
            }
        }
        
        if(rbi.getx()!=0)
        {
            rbi.setx(rbi.getx()-1);
            Thread.sleep(1000);
        }
        else
        {
            mwest = false;
        }
        return mwest;
    }
    
    //Check whether the robot is ready to fire
    public boolean fire(int x,int y)
    {
        mfire = true;
        if((rbi.getx()==x)&&(rbi.gety()==y))
        {
            mfire = true;
        }
        else
        {
            mfire = false;
        }
        return mfire;
    }
    
    //Passes the values to SwingArena class.
    //This method is used by JNI
    public void drawline1(int x, int y, int x2, int y2)
    {
        RobotMain.arena.setValues1(x, y, x2, y2);
    }

    //Passes the values to SwingArena class.
    //This method is used by JNI
    public void drawline2(int x, int y, int x2, int y2)
    {
        RobotMain.arena.setValues2(x, y, x2, y2);
    }
    
    //Passes the values to SwingArena class.
    //This method is used by JNI
    public void drawline3(int x, int y, int x2, int y2)
    {
        RobotMain.arena.setValues3(x, y, x2, y2);
    }
    
    //Passes the values to SwingArena class.
    //This method is used by JNI
    public void sethealt(double health , int x, int y)
    {
        RobotMain.arena.sethetalth(health, x, y);
    }
    
    //Calls a method in SwingArena class.
    //This method is used by JNI
    public void updatear()
    {
        RobotMain.arena.UpdateArena();
    }
    
    //Recieves the values from JNI to display the winner.
    public void DisplayWinnner(String name)
    {
        JOptionPane.showMessageDialog(null, "Robot "+name+" Wins");
        System.exit(0);
    }
}
