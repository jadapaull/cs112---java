import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LavaLamp2 {
    // initializing so they can be used elsewhere
    JFrame frame;
    JPanel colorpanel;
    JPanel outsidepanel;
    JButton button;
    Timer timer;
    boolean isRunnning= true;
    int counter = 0;
    Point p;
    int greencounter= 150;
    int redcounter = 150;
    int blackcounter = 150;
    int pointcounter = 150;
    int pointcounter2 = 100;

    public LavaLamp2() {
        frame = new JFrame("Lava Lamp 2");// makes new jframe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// makes sure that the jframe closes and program ends

        outsidepanel = new JPanel();// JPanel
        outsidepanel.setPreferredSize(new Dimension(700,500));
        outsidepanel.setBackground(Color.BLACK);// sets the first background color to green
        outsidepanel.setLayout(null);
        colorpanel = new JPanel();// makes new jpanel
        colorpanel.setSize(new Dimension(300, 200));
        p= new Point(pointcounter,pointcounter2);
        colorpanel.setLocation(p);
        button = new JButton("Change color here");// makes a button to change the color
        frame.add(outsidepanel);// adds the panel to the frame
        outsidepanel.add(colorpanel);
        colorpanel.add(button);// adds button to pannel
        frame.pack();
        frame.setVisible(true);// makes it visable 

        button.addActionListener(new ActionListener() {// citation oracle and other sites 
            public void actionPerformed(ActionEvent v) {// looks a button actions 
                ColorAndTimer();// this is used to set the color
            }
        });

        timer = new Timer(100, new ActionListener() {// // citation oracle and other site 
            //sets timer to 100 milliseconds
            public void actionPerformed(ActionEvent j) {
            if (redcounter<250 && greencounter <250 && blackcounter<250){
            if(greencounter <250 && blackcounter<250){
                colorpanel.setBackground(new Color(redcounter--,greencounter++,blackcounter++));// citation oracle and other site
                colorpanel.setLocation(pointcounter=pointcounter+2,pointcounter2=pointcounter2+2);
            }
            else {
                colorpanel.setBackground(new Color(redcounter=150, greencounter=150, blackcounter=150));
                colorpanel.setLocation(pointcounter=pointcounter-250,pointcounter2=pointcounter2-200);
            }}
            else{
                while(greencounter>150 && blackcounter>150){
                colorpanel.setBackground(new Color(redcounter++,greencounter--,blackcounter--));
                colorpanel.setLocation(pointcounter=pointcounter-2,pointcounter2=pointcounter2-2);
            }
            }

        }});
    }

    private void ColorAndTimer() {
        if (timer.isRunning()) {// looks at boolean to see if if red is true
            timer.stop();// stop the timer
            System.out.println(greencounter+","+ redcounter+ "," +blackcounter);
        } 
        else {
            timer.start();// stops the timer
        }
    }

    public static void main(String[] args) {
        new LavaLamp2();// makes a new lava lamp or timer 
    }
}