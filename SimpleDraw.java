/*
SimpleDraw.java
Code straight from MIT OCW 6.092

*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Displays a window and delegates drawing to DrawGraphics. */
public class SimpleDraw extends JPanel implements Runnable {
    private boolean animate = true;
    private final int FRAME_DELAY = 50; // 50 ms = 20 FPS
    private DrawGraphics draw;
	
	public static final int WIN_WIDTH =  500; 
    public static final int WIN_HEIGHT = 500;
    
	public SimpleDraw(DrawGraphics drawer) {
        this.draw = drawer;
    }
    
    /* Paint callback from Swing. Draw graphics using g. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	
        // Enable anti-aliasing for better looking graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        draw.draw(g2);
    }
	
	
    /* Enables periodic repaint calls. */
    public synchronized void start() {
        animate = true;
    }
	
	
    /* Pauses animation. */
    public synchronized void stop() {
        animate = false;
    }
	
	
    private synchronized boolean animationEnabled() {
        return animate;
    }
	
	
    public void run() {
        while (true) {
            if (animationEnabled()) {
                repaint();
            }
            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String args[]) {
        final SimpleDraw content = new SimpleDraw(new DrawGraphics());
        JFrame frame = new JFrame("Conway's Game of Life");
        Color bgColor = Color.white;
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
        content.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
		
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)     { System.exit(0);  }
            public void windowDeiconified(WindowEvent e) { content.start(); }
            public void windowIconified(WindowEvent e)   { content.stop();  }
        });
    
	    new Thread(content).start();
        frame.setVisible(true);
    }
}