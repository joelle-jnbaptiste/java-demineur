package com.example.demineur;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import com.example.util.ResourceUtility;

public class Jeu {
	private ImageIcon[][] vide = loadImagesVide();
	private ImageIcon[][] mine = loadImagesMine();

	public Jeu() throws IOException {
	}

	public ImageIcon[][] loadImagesVide() throws IOException {
		int rows = 9;
		int cols = 10;
		ImageIcon[][] images = new ImageIcon[9][10];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {
				images[i][j] = ResourceUtility.loadImage("images/vide.png");
				images[i][j].setDescription("vide");

			}

		}

		return images;
	}

	public ImageIcon[][] loadImagesMine() throws IOException {
		int rows = 1;
		int cols = 10;
		ImageIcon[][] images = new ImageIcon[1][10];

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 10; j++) {
				images[i][j] = ResourceUtility.loadImage("images/mine.png");
				images[i][j].setDescription("mine");

			}

		}

		return images;
	}

	public Deque<ImageIcon> creerPioche() throws IOException {

		Deque<ImageIcon> pioche = new LinkedList<ImageIcon>();

		ImageIcon[][] imagesVide = vide;
		ImageIcon[][] imagesMine = mine;

		for (int i = 0; i < imagesVide.length; i++) {
			for (int j = 0; j < imagesVide[i].length; j++) {
				pioche.add(imagesVide[i][j]);
			}
		}

		for (int i = 0; i < imagesMine.length; i++) {
			for (int j = 0; j < imagesMine[i].length; j++) {
				pioche.add(imagesMine[i][j]);
			}
		}

		Collections.shuffle((List<?>) pioche);

		return pioche;
	}
}