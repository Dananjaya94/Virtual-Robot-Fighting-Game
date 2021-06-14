/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.abs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.omg.CORBA.Environment;

/**
 *
 * @author Dananjaya
 */
public class AIImplementationB implements RobotAI{

    int capacity = 6;
    //creating an Array Blocking Queue
    ArrayBlockingQueue que = new ArrayBlockingQueue(capacity);
    int count = 3;
    
    @Override
    public void runAI(RobotControl rc) {
        
        String direction = "north";
        //Getting a robot object
        RobotInfo myrobot =  rc.getRobot();
        while(true)
        {
            //checking how many robots are available
            if((count==3)&&(count>1))
            {
                //Iterating through all the robots
                for(RobotInfo rb : rc.getAllRobots())
                {
                    //check if the queue is full
                    if(que.size()==capacity)
                    {
                        try {
                            Thread.sleep(1000);
                        }   
                        catch (InterruptedException ex) {
                        Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        //checking if myrobot an rb objects are the same objects
                        if((myrobot.getx()==rb.getx())&&(myrobot.gety()==rb.gety()))
                        {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                            Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        //Adding the firing locations to Queue
                        else
                        {
                            try 
                            {
                                que.put(rb.getx()+","+rb.gety());
                            } 
                            catch (InterruptedException ex) 
                            {
                                Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //Checks the enemy robot in 2 block radius
                            if((!rb.getname().equals(myrobot.getname()))&&(abs(myrobot.getx()-rb.getx())<=2)&&(abs(myrobot.gety()-rb.gety())<=2))
                            {
                            
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            
                            

                                if(myrobot.getname().equals(rc.getAllRobots()[0].getname()))
                                {
                                    //Checks if the robot is ready to fire
                                    if(rc.fire(myrobot.getx(), myrobot.gety())==true)
                                    {
                                        //if the selected robot is dead, Display a message inside the log
                                        if(rb.gethealth()==0)
                                        {
                                            RobotMain.logger.append(rb.getname()+" is dead\n");
                                            break;
                                        }
                                        //checking if robot health is less than 100 and greater than 30
                                        else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-35);
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                                System.out.println(ex);
                                            }
                                            RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        
                                        
                                        }
                                        //checking if robot health is eequal to 30
                                        else if(rb.gethealth()==30.0)
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-30);
                                            count = count-1;
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                                System.out.println(ex);
                                            }
                                            
                                            RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        
                                        }
                                        //Setting health of the relevant robot
                                        RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
                                        que.remove();
                                    
                                    
                                    }
                                }
                                else if(myrobot.getname().equals(rc.getAllRobots()[1].getname()))
                                {
                                    //Checks if the robot is ready to fire
                                    if(rc.fire(myrobot.getx(), myrobot.gety())==true)
                                    {
                                        //if the selected robot is dead, Display a message inside the log
                                        if(rb.gethealth()==0)
                                        {
                                            RobotMain.logger.append(rb.getname()+" is dead\n");
                                            break;
                                        }
                                        //checking if robot health is less than 100 and greater than 30
                                        else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-35);
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                                System.out.println(ex);
                                            }
                                            RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        
                                        
                                        }
                                        //checking if robot health is eequal to 30
                                        else if(rb.gethealth()==30.0)
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-30);
                                            count = count-1;
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                            System.out.println(ex);
                                            }
                                            RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        }
                                    
                                        //Set robot health label and label location
                                        RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
                                        
                                        //Remove firing locations from the queue
                                        que.remove();
                                    
                                    }
                                }
                                else if(myrobot.getname().equals(rc.getAllRobots()[2].getname()))
                                {
                                    //Checks if the robot is ready to fire
                                    if(rc.fire(myrobot.getx(), myrobot.gety())==true)
                                    {
                                        //if the selected robot is dead, Display a message inside the log
                                        if(rb.gethealth()==0)
                                        {
                                            RobotMain.logger.append(rb.getname()+" is dead\n");
                                            break;
                                        }
                                        //checking if robot health is less than 100 and greater than 30
                                        else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-35);
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                                System.out.println(ex);
                                            }
                                            RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        
                                        
                                        }
                                        //checking if robot health is eequal to 30
                                        else if(rb.gethealth()==30.0)
                                        {
                                            //Setting values to draw line for the firing location
                                            RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
                                            rb.sethealth(rb.gethealth()-30);
                                            count = count-1;
                                            try
                                            {
                                                Thread.sleep(250);
                                            }
                                            catch(Exception ex)
                                            {
                                                System.out.println(ex);
                                            }
                                            RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
                                        
                                        }
                                    
                                        //Set robot health label and label location
                                        RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
                                        //Remove firing location from the queue
                                        que.remove();
                                    
                                    }
                                }
                                //Printing firing robots names
                                System.out.println("Firing : "+myrobot.getname()+" to "+rb.getname()+"\n");
                                //Adding the firing robots names into the log
                                RobotMain.logger.append("Firing : "+myrobot.getname()+" to "+rb.getname()+"\n");

                            
                            
                            
                            }
                        }
                    
                    }
                
                }
            }
            else
            {
                //checking robot 1 and robot 2 are dead
                if((rc.getAllRobots()[0].gethealth()==0)&&(rc.getAllRobots()[1].gethealth()==0))
                {
                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[2].getname()+" wins");
                    System.exit(0);
                }
                //checking robot 2 and robot 3 are dead
                else if((rc.getAllRobots()[1].gethealth()==0)&&(rc.getAllRobots()[2].gethealth()==0))
                {
                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[0].getname()+" wins");
                    System.exit(0);
                }
                //checking robot 1 and robot 3 are dead
                else if((rc.getAllRobots()[0].gethealth()==0)&&(rc.getAllRobots()[2].gethealth()==0))
                {
                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[1].getname()+" wins");
                    System.exit(0);
                }
            }
            
            //Print the robot movement details in the logger
            RobotMain.logger.append("Robot "+rc.getRobot().getname()+" moved to : "+rc.getRobot().getx()+" , "+rc.getRobot().gety()+"\n");
            
            //check if the robot can move north further
            if(direction.equals("north"))
            {
                try 
                {
                    if(!rc.moveNorth()){direction="east";}
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
                RobotMain.arena.UpdateArena();
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //check if the robot can move east further
            else if(direction.equals("east"))
            {
                try 
                {
                    if(!rc.moveEast()){direction="south";}
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
;
                RobotMain.arena.UpdateArena();
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //check if the robot can move south further
            else if(direction.equals("south"))
            {
                
                try 
                {
                    if(!rc.moveSouth()){direction="west";}
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
;
                RobotMain.arena.UpdateArena();
                
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //check if the robot can move west further
            else if(direction.equals("west"))
            {
                try 
                {
                    if(!rc.moveWest()){direction="north";}
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
;
                RobotMain.arena.UpdateArena();
                
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        
    }
    
    
}
