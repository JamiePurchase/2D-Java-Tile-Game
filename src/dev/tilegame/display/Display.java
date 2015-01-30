package dev.tilegame.display;
import dev.tilegame.Keyboard;
import dev.tilegame.Mouse;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display
{
	public JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}
	
	private void createDisplay()
	{
		// Create the frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Temp
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.setResizable(false);
		
		// Create a JPanel
		JPanel panel = new JPanel();
        panel.addKeyListener(new Keyboard());
        //panel.addMouseListener(new Mouse());
        panel.requestFocusInWindow();
        panel.setFocusable(true);
        frame.add(panel);
		
		// Create the canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		// Temp
		canvas.addKeyListener(new Keyboard());
		frame.addKeyListener(new Keyboard());
		
		// Add the canvas to the frame
		frame.add(canvas);
		frame.pack();

		// May need to move these back to the gap in the temp suite later
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}