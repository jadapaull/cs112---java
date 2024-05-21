import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LavaLamp {
    // initializing so they can be used elsewhere
    JFrame frame;
    JPanel panel;
    JButton button;
    Timer timer;
    boolean isRed = true;
    int counter = 0;

    public LavaLamp() {
        frame = new JFrame("Lava Lamp");// makes new jframe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// makes sure that the jframe closes and program ends
        panel = new JPanel();// makes new jpanel
        panel.setPreferredSize(new Dimension(700, 500));
        panel.setBackground(Color.GREEN);// sets the first background color to green
        button = new JButton("Change color here");// makes a button to change the color
        frame.add(panel);// adds the panel to the frame
        panel.add(button);// adds button to pannel
        frame.pack();
        frame.setVisible(true);// makes it visable 

        button.addActionListener(new ActionListener() {// citation oracle and other sites 
            public void actionPerformed(ActionEvent v) {// looks a button actions 
                ColorAndTimer();// this is used to set the color
            }
        });

        timer = new Timer(100, new ActionListener() {// // citation oracle and other site 
            //sets timer to 100 milliseconds
            public void actionPerformed(ActionEvent j) {// citation oracle and other site
                System.out.println(counter++);// every time the counter runs through milliseconds it prints
            }
        });
    }

    private void ColorAndTimer() {
        if (isRed) {// looks at boolean to see if if red is true
            panel.setBackground(Color.RED);// changes color to red
            timer.start();// starts the timer
        } else {// looks to see if boolean is false
            panel.setBackground(Color.GREEN);// changes the color to green
            timer.stop();// stops the timer
        }
        isRed = !isRed;// changes boolean
    }

    public static void main(String[] args) {
        new LavaLamp();// makes a new lava lamp or timer 
    }
}