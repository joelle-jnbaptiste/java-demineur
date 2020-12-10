package com.example.demineur;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import com.example.swing.FrameForDemoMaker;

public class DemineurApp extends FrameForDemoMaker {
	private static final int ROW_COUNT = 10;
	private static final int COLUMN_COUNT = 10;
	private Jeu jeu = new Jeu();
	private EtatMemoire memoire = new EtatMemoire();
//	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");

	public DemineurApp() throws IOException {
		super("Mémoire");
		setDefaultBounds(100, 100, 900, 600);
	}

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));
		int count = 0;
		Deque<ImageIcon> pioche;
		try {
			pioche = jeu.creerPioche();
			for (ImageIcon image : pioche) {

				cp.add(createButton(image, count));
				count++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JComponent createButton(ImageIcon image, int count) {

		ImageIcon imageIcon = image; // Récupération depuis la pioche
		JToggleButton button = new JToggleButton();
		button.setName(Integer.toString(count));

//		button.setSelectedIcon(imageIcon);
//		button.setDisabledIcon(imageIcon);
//		button.setDisabledSelectedIcon(dosCarte);

		button.putClientProperty("carte", imageIcon.getDescription());

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if (SwingUtilities.isRightMouseButton(e)) {
					try {
						memoire.drapeau(button);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {

						memoire.nouveauBoutonSelectionne(button);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		return button;

//		JButton button = new JButton(pioche.pop());
//		return button;
	}

	public static void main(String[] args) throws IOException {
		DemineurApp example = new DemineurApp();
		SwingUtilities.invokeLater(example);
	}
}