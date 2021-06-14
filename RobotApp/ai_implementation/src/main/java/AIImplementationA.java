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
public class AIImplementationA implements RobotAI{

    int capacity = 6;
    ArrayBlockingQueue que = new ArrayBlockingQueue(capacity);
    int count = 3;
    
    private native void RunImplementationA(RobotControl rc);
                    
    @Override
    public void runAI(RobotControl rc) {
        
        //Calling the JNI Method
        System.out.println("AI Starting");
        System.loadLibrary("libRobotAIImplementation");
        RunImplementationA(rc);
        
        String direction = "north";
        
//        RobotInfo myrobot =  rc.getRobot();
//        while(true)
//        {
//            if((count==3)&&(count>1))
//            {
//                for(RobotInfo rb : rc.getAllRobots())
//            {
//                if(que.size()==capacity)
//                {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                else
//                {
//                    if((myrobot.getx()==rb.getx())&&(myrobot.gety()==rb.gety()))
//                    {
//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    else
//                    {
//                        try 
//                        {
//                            que.put(rb.getx()+","+rb.gety());
//                        } 
//                        catch (InterruptedException ex) 
//                        {
//                            Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        if((!rb.getname().equals(myrobot.getname()))&&(abs(myrobot.getx()-rb.getx())<=2)&&(abs(myrobot.gety()-rb.gety())<=2))
//                        {
//                            
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            
//                            
//
//                            if(myrobot.getname().equals(rc.getAllRobots()[0].getname()))
//                            {
//                                
//                                
//                                
//                                if(rc.fire(myrobot.getx(), myrobot.gety())==true)
//                                {
//                                    if(rb.gethealth()==0)
//                                    {
//                                        RobotMain.logger.append(rb.getname()+" is dead\n");
//                                        break;
//                                    }
//                                    else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
//                                    {
//                                        RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-35);
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                        
//                                    }
//                                    else if(rb.gethealth()==30.0)
//                                    {
//                                        RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-30);
//                                        count = count-1;
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues1(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                    }
//                                    
//                                    RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
//                                    que.remove();
//                                    
//                                    
//                                }
//                            }
//                            else if(myrobot.getname().equals(rc.getAllRobots()[1].getname()))
//                            {
//                                
//                                if(rc.fire(myrobot.getx(), myrobot.gety())==true)
//                                {
//                                    if(rb.gethealth()==0)
//                                    {
//                                        RobotMain.logger.append(rb.getname()+" is dead\n");
//                                        break;
//                                    }
//                                    else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
//                                    {
//                                        RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-35);
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                        
//                                    }
//                                    else if(rb.gethealth()==30.0)
//                                    {
//                                        RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-30);
//                                        count = count-1;
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues2(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                    }
//                                    
//                                    RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
//                                    que.remove();
//                                    
//                                }
//                            }
//                            else if(myrobot.getname().equals(rc.getAllRobots()[2].getname()))
//                            {
//                                
//                                if(rc.fire(myrobot.getx(), myrobot.gety())==true)
//                                {
//                                    if(rb.gethealth()==0)
//                                    {
//                                        RobotMain.logger.append(rb.getname()+" is dead\n");
//                                        break;
//                                    }
//                                    else if((rb.gethealth()<=100.0)&&(rb.gethealth()>30))
//                                    {
//                                        RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-35);
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                        
//                                    }
//                                    else if(rb.gethealth()==30.0)
//                                    {
//                                        RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), rb.getx(), rb.gety());
//                                        rb.sethealth(rb.gethealth()-30);
//                                        count = count-1;
//                                        try
//                                        {
//                                            Thread.sleep(250);
//                                        }
//                                        catch(Exception ex)
//                                        {
//                                           System.out.println(ex);
//                                        }
//                                        RobotMain.arena.setValues3(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                                        
//                                    }
//                                    
//                                    
//                                    RobotMain.arena.sethetalth(rb.gethealth(), rb.getx(), rb.gety());
//                                    que.remove();
//                                    
//                                }
//                            }
//                            //RobotMain.arena.setValues(myrobot.getx(), myrobot.gety(), myrobot.getx(), myrobot.gety());
//                            System.out.println("Firing : "+myrobot.getname()+" to "+rb.getname()+"\n");
//                            RobotMain.logger.append("Firing : "+myrobot.getname()+" to "+rb.getname()+"\n");
//
//                            
//                            
//                            
//                        }
//                    }
//                    
//                }
//                
//            }
//            }
//            else
//            {
//                if((rc.getAllRobots()[0].gethealth()==0)&&(rc.getAllRobots()[1].gethealth()==0))
//                {
//                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[2].getname()+" wins");
//                    System.exit(0);
//                }
//                else if((rc.getAllRobots()[1].gethealth()==0)&&(rc.getAllRobots()[2].gethealth()==0))
//                {
//                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[0].getname()+" wins");
//                    System.exit(0);
//                }
//                else if((rc.getAllRobots()[0].gethealth()==0)&&(rc.getAllRobots()[2].gethealth()==0))
//                {
//                    JOptionPane.showMessageDialog(null,"Robot "+rc.getAllRobots()[1].getname()+" wins");
//                    System.exit(0);
//                }
//            }
//            
//            RobotMain.logger.append("Robot "+rc.getRobot().getname()+" moved to : "+rc.getRobot().getx()+" , "+rc.getRobot().gety()+"\n");
//            
//            if(direction.equals("north"))
//            {
//                try 
//                {
//                    if(!rc.moveNorth()){direction="east";}
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                RobotMain.arena.UpdateArena();
//                try 
//                {
//                    Thread.sleep(1000);
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else if(direction.equals("east"))
//            {
//                try 
//                {
//                    if(!rc.moveEast()){direction="south";}
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//;
//                RobotMain.arena.UpdateArena();
//                try 
//                {
//                    Thread.sleep(1000);
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else if(direction.equals("south"))
//            {
//                
//                try 
//                {
//                    if(!rc.moveSouth()){direction="west";}
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//;
//                RobotMain.arena.UpdateArena();
//                
//                try 
//                {
//                    Thread.sleep(1000);
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else if(direction.equals("west"))
//            {
//                try 
//                {
//                    if(!rc.moveWest()){direction="north";}
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//;
//                RobotMain.arena.UpdateArena();
//                
//                try 
//                {
//                    Thread.sleep(1000);
//                } 
//                catch (InterruptedException ex) 
//                {
//                    Logger.getLogger(AIImplementationA.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//        }
        
        
    }
    
    
}
