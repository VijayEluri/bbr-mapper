package com.slam;

import java.awt.*;
import javax.swing.*;

public class TestRansac extends JPanel {
    final int numLaser = 181;
    double[] laser = null;

    public TestRansac() {
        super();
        setPreferredSize(new Dimension(800,600));

        double[] hereLaser = {
            0.705001, 0.705084, 0.705382, 0.705895, 0.706624, 0.707571,
            0.708737, 0.710123, 0.711732, 0.713566, 0.715629, 0.717923,
            0.720452, 0.723220, 0.726232, 0.729493, 0.733008, 0.736783,
            0.740824, 0.745138, 0.749733, 0.754617, 0.759799, 0.765287,
            0.771092, 0.777225, 0.783698, 0.790523, 0.797713, 0.805284,
            0.813251, 0.821631, 0.830441, 0.839702, 0.849434, 0.859660,
            0.870405, 0.881694, 0.893557, 0.906025, 0.919130, 0.932910,
            0.947403, 0.962652, 0.978705, 0.995612, 1.013428, 1.032216,
            1.052041, 1.072977, 1.079572, 1.102650, 1.127089, 1.235946,
            1.265420, 1.296741, 1.330069, 1.365585, 1.403491, 1.444016,
            1.487420, 1.533998, 1.584089, 1.638080, 1.696419, 1.759625,
            1.828306, 1.825693, 1.851840, 1.963579, 2.057409, 2.161351,
            2.244790, 2.543253, 2.697631, 2.872899, 3.009756, 3.127908,
            3.384229, 3.687541, 4.051937, 4.497777, 5.055602, 5.773401,
            7.113069, 7.113069, 7.113069, 7.113069, 7.113069, 7.113069,
            7.113069, 7.113069, 7.113069, 7.113069, 7.113069, 7.113069,
            7.149321, 5.773401, 5.055602, 4.497777, 4.051937, 3.687541,
            3.384229, 3.127908, 3.009756, 3.023427, 3.038156, 4.753521,
            2.244790, 2.161351, 2.057409, 1.963579, 1.851840, 1.825693,
            1.834484, 1.824343, 1.814866, 1.806036, 1.797839, 1.790261,
            1.783289, 1.776913, 1.771121, 1.765906, 1.761257, 1.757169,
            1.753635, 1.750649, 1.127089, 1.102650, 1.079572, 1.072977,
            1.052041, 1.032216, 1.013428, 0.995612, 0.978705, 0.962652,
            0.947403, 0.932910, 0.919130, 0.906025, 0.893557, 0.881694,
            0.870405, 0.859660, 0.849434, 0.839702, 0.830441, 0.821631,
            0.813251, 0.805284, 0.797713, 0.790523, 0.783698, 0.777225,
            0.771092, 0.765287, 0.759799, 0.754617, 0.749733, 0.745138,
            0.740824, 0.736783, 0.733008, 0.729493, 0.726232, 0.723220,
            0.720452, 0.717923, 0.715629, 0.713566, 0.711732, 0.710123,
            0.708737, 0.707571, 0.706624, 0.705895, 0.705382, 0.705084,
            0.705001
        };
        laser = hereLaser;
    }

    @Override
    protected void paintComponent(Graphics g) {
        final double scale = 100;
        int height = getHeight(), width = getWidth();
        int xcenter = width / 2, ycenter = 10;

        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);

        // Draw laser beams.
        g.setColor(Color.green);
        for(int i = 0; i < numLaser; i++) {
            Vector2D v = new Vector2D();
            v.setPol(laser[i], i * Math.PI / 180);
            double x = v.getX() * scale,
                   y = v.getY() * scale;
            x += xcenter;
            y += ycenter;
            g.drawLine(xcenter, ycenter, (int)x, (int)y);
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        TestRansac panel = new TestRansac();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        // from: http://download.oracle.com/javase/tutorial/uiswing/examples/components/index.html#FrameDemo
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
};
