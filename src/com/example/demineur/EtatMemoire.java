package com.example.demineur;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JToggleButton;

import com.example.util.ResourceUtility;

public class EtatMemoire {

	List<JToggleButton> listeDrapeau = new LinkedList<>();
	int nombreCoups = 0;
	int nombreDoublons = 0;

	public void drapeau(JToggleButton button) throws IOException {
		if (button.isEnabled()) {
			button.setEnabled(false);
			button.setIcon(ResourceUtility.loadImage("images/drapeau.png"));
			listeDrapeau.add(button);

		} else if (listeDrapeau.contains(button)) {
			button.setEnabled(true);
			button.setIcon(null);
			listeDrapeau.remove(button);
		}
	}

	public void getVoisin(JToggleButton button) {
		int coor = Integer.parseInt(button.getName());
		int coor2 = coor + 1;

	}

	public void nouveauBoutonSelectionne(JToggleButton button) throws IOException {

		nombreCoups++;
		if (!listeDrapeau.contains(button)) {
			if (button.getClientProperty("carte") == "mine") {
				button.setIcon(ResourceUtility.loadImage("images/mine.png"));
				System.out.println("miaou");
				getVoisin(button);
			} else {

				button.setIcon(ResourceUtility.loadImage("images/vide.png"));
				System.out.println("miaou");
			}
			button.setEnabled(false);
		}

	}
}
