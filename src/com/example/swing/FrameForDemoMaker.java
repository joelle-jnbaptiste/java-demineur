package com.example.swing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public abstract class FrameForDemoMaker implements Runnable {
	protected JFrame frame;
	private String title;
	private Point origin = new Point(200, 200);
	private Dimension dimension = new Dimension(300, 240);

	public FrameForDemoMaker(String title) {
		this.title = title;
	}

	public void setDefaultBounds(int x, int y, int width, int height) {
		origin = new Point(x, y);
		dimension = new Dimension(width, height);
	}

	@Override
	public void run() {
		// Initialise la fenÃªtre
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Positionne et redimensionne la fenÃªtre
		frame.setBounds(origin.x, origin.y, dimension.width, dimension.height);

		// Initialise les composants internes
		init(frame);

		// Affiche la fenÃªtre
		frame.setVisible(true);
	}

	/**
	 * Initialise la frame qui a Ã©tÃ© crÃ©e par l'instance de cette classe
	 * 
	 * @param frame
	 */
	public abstract void init(JFrame frame);
}
