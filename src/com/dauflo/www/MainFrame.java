package com.dauflo.www;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private static Cell[][] cellBoard = new Cell[100][100];
	public static int width = 500, height = 500;

	public static void main(String[] args) {

		for (int i = 0; i < cellBoard.length; i++) {
			for (int j = 0; j < cellBoard.length; j++) {
				cellBoard[i][j] = new Cell();
			}
		}
		
		JFrame myFrame = new JFrame("GOL One Loop Chalenge");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(width, height);
		myFrame.setResizable(false);
		
		Container myPanel = myFrame.getContentPane();
		myPanel.setPreferredSize(new Dimension(width, height));
		
		DisplayComponent display = new DisplayComponent(cellBoard);
		
		myPanel.add(display);
		
		myFrame.setContentPane(myPanel);
		myFrame.pack();
		myFrame.show();
	}
}
