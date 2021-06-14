/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rocket Bunny
 */
public class StartGui extends javax.swing.JFrame {

    SwingArena arena = new SwingArena();
    int height;
    int width;
    int numofrorborts;

    String roboname1;
    String roboname2;
    String roboname3;

    /**
     * Creates new form StartGui
     */
    public StartGui() {
        initComponents();
        name1label.setEnabled(false);
        txtrobot1.setEnabled(false);

        name2label.setEnabled(false);
        txtrobot2.setEnabled(false);

        name3label.setEnabled(false);
        txtrobot3.setEnabled(false);

        hgtxt.setText("12");
        wdtxt.setText("12");
        hgtxt.setEnabled(false);
        wdtxt.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hgtxt = new javax.swing.JTextField();
        wdtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numberofrobots = new javax.swing.JComboBox<>();
        name3label = new javax.swing.JLabel();
        name1label = new javax.swing.JLabel();
        name2label = new javax.swing.JLabel();
        txtrobot1 = new javax.swing.JTextField();
        txtrobot2 = new javax.swing.JTextField();
        txtrobot3 = new javax.swing.JTextField();
        startgamebutton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        robot1xtxt = new javax.swing.JTextField();
        robot2xtxt = new javax.swing.JTextField();
        robot3xtxt = new javax.swing.JTextField();
        robot1ytxt = new javax.swing.JTextField();
        robot2ytxt = new javax.swing.JTextField();
        robot3ytxt = new javax.swing.JTextField();
        robot1xlabel = new javax.swing.JLabel();
        robot2xlabel = new javax.swing.JLabel();
        robot3xlabel = new javax.swing.JLabel();
        robot1ylabel = new javax.swing.JLabel();
        robot2ylabel = new javax.swing.JLabel();
        robot3ylabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 550));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Robot Application");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Arena Height :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Arena Width :");

        hgtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        wdtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Number of Robots :");

        numberofrobots.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        numberofrobots.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3" }));
        numberofrobots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberofrobotsActionPerformed(evt);
            }
        });

        name3label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name3label.setText("Enter Robot 3 name :");

        name1label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name1label.setText("Enter Robot 1 name :");

        name2label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name2label.setText("Enter Robot 2 name :");

        txtrobot1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtrobot2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtrobot3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        startgamebutton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        startgamebutton.setText("Start Game");
        startgamebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    startgamebuttonActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Starting locations");

        robot1xtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot2xtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot3xtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot1ytxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot2ytxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot3ytxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        robot1xlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot1xlabel.setText("X:");

        robot2xlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot2xlabel.setText("X:");

        robot3xlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot3xlabel.setText("X:");

        robot1ylabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot1ylabel.setText("Y:");

        robot2ylabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot2ylabel.setText("Y:");

        robot3ylabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        robot3ylabel.setText("Y:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(hgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(wdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addComponent(numberofrobots, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(name1label)
                .addGap(9, 9, 9)
                .addComponent(txtrobot1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(robot1xlabel)
                .addGap(44, 44, 44)
                .addComponent(robot1xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(robot1ylabel)
                .addGap(24, 24, 24)
                .addComponent(robot1ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(name2label)
                .addGap(9, 9, 9)
                .addComponent(txtrobot2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(robot2xlabel)
                .addGap(44, 44, 44)
                .addComponent(robot2xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(robot2ylabel)
                .addGap(24, 24, 24)
                .addComponent(robot2ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(name3label)
                .addGap(9, 9, 9)
                .addComponent(txtrobot3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(robot3xlabel)
                .addGap(44, 44, 44)
                .addComponent(robot3xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(robot3ylabel)
                .addGap(24, 24, 24)
                .addComponent(robot3ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(startgamebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(hgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(wdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(numberofrobots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name1label)
                    .addComponent(txtrobot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot1xlabel)
                    .addComponent(robot1xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot1ylabel)
                    .addComponent(robot1ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name2label)
                    .addComponent(txtrobot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot2xlabel)
                    .addComponent(robot2xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot2ylabel)
                    .addComponent(robot2ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name3label)
                    .addComponent(txtrobot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot3xlabel)
                    .addComponent(robot3xtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(robot3ylabel)
                    .addComponent(robot3ytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(startgamebutton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberofrobotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberofrobotsActionPerformed

        //Chech which option from the dropdown is choosen
        if(numberofrobots.getSelectedItem()=="2")
        {
            name1label.setEnabled(true);
            txtrobot1.setEnabled(true);
            robot1xlabel.setEnabled(true);
            robot1ylabel.setEnabled(true);
            robot1xtxt.setEnabled(true);
            robot1ytxt.setEnabled(true);
            
            name2label.setEnabled(true);
            txtrobot2.setEnabled(true);
            robot2xlabel.setEnabled(true);
            robot2ylabel.setEnabled(true);
            robot2xtxt.setEnabled(true);
            robot2ytxt.setEnabled(true);
            
            name3label.setEnabled(false);
            txtrobot3.setEnabled(false);
            robot3xlabel.setEnabled(false);
            robot3ylabel.setEnabled(false);
            robot3xtxt.setEnabled(false);
            robot3ytxt.setEnabled(false);
            
        }
        else if(numberofrobots.getSelectedItem()=="3")
        {
            name1label.setEnabled(true);
            txtrobot1.setEnabled(true);
            robot1xlabel.setEnabled(true);
            robot1ylabel.setEnabled(true);
            robot1xtxt.setEnabled(true);
            robot1ytxt.setEnabled(true);
            
            name2label.setEnabled(true);
            txtrobot2.setEnabled(true);
            robot2xlabel.setEnabled(true);
            robot2ylabel.setEnabled(true);
            robot2xtxt.setEnabled(true);
            robot2ytxt.setEnabled(true);
            
            name3label.setEnabled(true);
            txtrobot3.setEnabled(true);
            robot3xlabel.setEnabled(true);
            robot3ylabel.setEnabled(true);
            robot3xtxt.setEnabled(true);
            robot3ytxt.setEnabled(true);
        }
    }//GEN-LAST:event_numberofrobotsActionPerformed
    
    
    
    private void startgamebuttonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {// GEN-FIRST:event_startgamebuttonActionPerformed

        height = Integer.parseInt(hgtxt.getText());
        width = Integer.parseInt(wdtxt.getText());
        numofrorborts = Integer.parseInt(numberofrobots.getSelectedItem().toString());
        
        String roboname1;
        String roboname2;
        String roboname3;
        int rob1x;
        int rob2x;
        int rob3x;
        int rob1y;
        int rob2y;
        int rob3y;
        
        //check if selected number of robots are two
        if(numofrorborts==2)
        {            
            roboname1 = txtrobot1.getText();
            RobotMain.robo1.setname(roboname1);
            RobotMain.rb1.setRobot(RobotMain.robo1);
            
            roboname2 = txtrobot2.getText();
            RobotMain.robo2.setname(roboname2);
            RobotMain.rb2.setRobot(RobotMain.robo2);
            
            
            rob1x = Integer.parseInt(robot1xtxt.getText());
            RobotMain.robo1.setx(rob1x);
            rob1y = Integer.parseInt(robot1ytxt.getText());
            RobotMain.robo1.sety(rob1y);
            rob2x = Integer.parseInt(robot2xtxt.getText());
            RobotMain.robo2.setx(rob2x);
            rob2y = Integer.parseInt(robot2ytxt.getText());
            RobotMain.robo2.sety(rob2y);
            
            RobotMain.robo1.sethealth(100.0);
            RobotMain.robo2.sethealth(100.0);


            RobotAI pluginld1 = null;
            RobotAI pluginld2 = null;
            try {
                pluginld1 = RobotMain.plugLoader1.loadPlugin("AIImplementationB");
                pluginld2 = RobotMain.plugLoader2.loadPlugin("AIImplementationB");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartGui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StartGui.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        RobotMain.plginMap1.put("AIImplementationB", pluginld1);
        RobotMain.plginMap2.put("AIImplementationB", pluginld2);

        


        }
        //check if selected number of robots are three
        else if(numofrorborts==3)
        {
            //Assigning the values to robot info objects
            roboname1 = txtrobot1.getText();
            RobotMain.robo1.setname(roboname1);
            RobotMain.rb1.setRobot(RobotMain.robo1);
            
            roboname2 = txtrobot2.getText();
            RobotMain.robo2.setname(roboname2);
            RobotMain.rb2.setRobot(RobotMain.robo2);
            
            roboname3 = txtrobot3.getText();
            RobotMain.robo3.setname(roboname3);
            RobotMain.rb3.setRobot(RobotMain.robo3);
            
            rob1x = Integer.parseInt(robot1xtxt.getText());
            RobotMain.robo1.setx(rob1x);
            rob1y = Integer.parseInt(robot1ytxt.getText());
            RobotMain.robo1.sety(rob1y);
            rob2x = Integer.parseInt(robot2xtxt.getText());
            RobotMain.robo2.setx(rob2x);
            rob2y = Integer.parseInt(robot2ytxt.getText());
            RobotMain.robo2.sety(rob2y);
            rob3x = Integer.parseInt(robot3xtxt.getText());
            RobotMain.robo3.setx(rob3x);
            rob3y = Integer.parseInt(robot3ytxt.getText());
            RobotMain.robo3.sety(rob3y);
            
            
            RobotMain.robo1.sethealth(100.0);
            RobotMain.robo2.sethealth(100.0);
            RobotMain.robo3.sethealth(100.0);



            RobotAI pluginld1 = null;
            RobotAI pluginld2 = null;
            RobotAI pluginld3 = null;

            //Calling the loadplugin funtion in the AILoader to access th sub projects


            try {
                pluginld1 = RobotMain.plugLoader1.loadPlugin("AIImplementationB");
                pluginld2 = RobotMain.plugLoader2.loadPlugin("AIImplementationB");
                pluginld3 = RobotMain.plugLoader3.loadPlugin("AIImplementationB");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartGui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StartGui.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        //Adding the loaded classes into Hash map to access from RobotMain
        RobotMain.plginMap1.put("AIImplementationB", pluginld1);
        RobotMain.plginMap2.put("AIImplementationB", pluginld2);
        RobotMain.plginMap3.put("AIImplementationB", pluginld3);


        }
        
        arena.setGridHeight(height);
        arena.setGridWidth(width);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        RobotMain.stgui.dispose();
    }//GEN-LAST:event_startgamebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hgtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel name1label;
    private javax.swing.JLabel name2label;
    private javax.swing.JLabel name3label;
    private javax.swing.JComboBox<String> numberofrobots;
    private javax.swing.JLabel robot1xlabel;
    private javax.swing.JTextField robot1xtxt;
    private javax.swing.JLabel robot1ylabel;
    private javax.swing.JTextField robot1ytxt;
    private javax.swing.JLabel robot2xlabel;
    private javax.swing.JTextField robot2xtxt;
    private javax.swing.JLabel robot2ylabel;
    private javax.swing.JTextField robot2ytxt;
    private javax.swing.JLabel robot3xlabel;
    private javax.swing.JTextField robot3xtxt;
    private javax.swing.JLabel robot3ylabel;
    private javax.swing.JTextField robot3ytxt;
    private javax.swing.JButton startgamebutton;
    private javax.swing.JTextField txtrobot1;
    private javax.swing.JTextField txtrobot2;
    private javax.swing.JTextField txtrobot3;
    private javax.swing.JTextField wdtxt;
    // End of variables declaration//GEN-END:variables
}
