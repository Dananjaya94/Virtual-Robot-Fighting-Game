import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class RobotMain {

    //Creating the necessary objects for the program
    private static Object lock = new Object();
    public static StartGui stgui = new StartGui();

    public static RobotInfo[] roboarray = new RobotInfo[3];
    public static RobotInfo robo1;
    public static RobotInfo robo2;
    public static RobotInfo robo3;

    public static RobotControl rb1;
    public static RobotControl rb2;
    public static RobotControl rb3;

    public static RobotControl[] robocontrolarray = new RobotControl[3];

    static JButton btn1 = new JButton("Start");

    static SwingArena arena = new SwingArena();
    static JTextArea logger = new JTextArea();
    public static JScrollPane loggerArea = new JScrollPane(logger);

    public static Graphics2D grp2d;

    public static AILoader plugLoader1 = new AILoader();

    public static AILoader plugLoader2 = new AILoader();
    public static AILoader plugLoader3 = new AILoader();

    public static Map<Object, RobotAI> plginMap1 = new HashMap<>();
    public static Map<Object, RobotAI> plginMap2 = new HashMap<>();
    public static Map<Object, RobotAI> plginMap3 = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        //Creating the RobotInfor objects and RobotControl Objects
        robo1 = new RobotInfo();
        robo2 = new RobotInfo();
        robo3 = new RobotInfo();

        rb1 = new RobotControl();
        rb2 = new RobotControl();
        rb3 = new RobotControl();

        stgui.setLocationRelativeTo(null);
        stgui.setVisible(true);

        //Starting a thread to display the GUI
        Thread t = new Thread() 
        {
            public void run() 
            {
                synchronized (lock) 
                {
                    while (stgui.isVisible()) 
                    {
                        try 
                        {
                            lock.wait();
                        } 
                        catch (InterruptedException ex) 
                        {
                            System.out.println(ex);
                        }
                    }
                    System.out.println("Main Program RUNNING now");
                }
            }
        };
        t.start();

        stgui.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent arg0) {
                synchronized (lock) {
                    stgui.setVisible(false);
                    lock.notify();

                    RobotMain.roboarray[0] = robo1;
                    RobotMain.roboarray[1] = robo2;
                    RobotMain.roboarray[2] = robo3;

                }
            }

        });

        t.join();
        
        //Creating thread 1
        Thread robothread1 = new Thread() {
            public void run() {
                plginMap1.get("AIImplementationB").runAI(rb1);
            }
        };

        //Creating thread 2
        Thread robothread2 = new Thread() {
            public void run() {
                plginMap2.get("AIImplementationB").runAI(rb2);
            }
        };

        //Creating thread 3
        Thread robothread3 = new Thread() {
            public void run() {
                plginMap3.get("AIImplementationB").runAI(rb3);
            }
        };

        //Starting arena GUI
        SwingUtilities.invokeLater(() -> {

            JFrame window = new JFrame("Robot AI (Swing)");

            JToolBar toolbar = new JToolBar();
            toolbar.add(btn1);

            btn1.addActionListener((event) -> 
            {
                //Remove all the graphic contents in the arena
                arena.removeAll();
                arena.UpdateArena();
               
               try
               {
                   //Strating the threads
                   robothread1.start();
                   robothread2.start();
                   robothread3.start();
               }
               catch(Exception ex)
               {
                   System.out.println(ex);
               }


                
            });
            
            
            
            loggerArea.setBorder(BorderFactory.createEtchedBorder());
            logger.append("Robot Program\n");
            
            JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, arena, logger);

            Container contentPane = window.getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(toolbar, BorderLayout.NORTH);
            contentPane.add(splitPane, BorderLayout.CENTER);
            
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setPreferredSize(new Dimension(800, 800));
            window.pack();
            window.setVisible(true);
            
            splitPane.setDividerLocation(0.75);
        });
            
            
               
   
   
   
   
   
    
    }
    
    
}
